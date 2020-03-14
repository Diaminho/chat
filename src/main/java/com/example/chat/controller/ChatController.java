package com.example.chat.controller;

import com.example.chat.message.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message message,
                           SimpMessageHeaderAccessor headerAccessor) throws Exception {
        final Map<String, Object> attributes = headerAccessor.getSessionAttributes();
        if (attributes == null) {
            throw new Exception("Cannot get session attributes");
        }
        // Add username in web socket session
        attributes.put("username", message.getSender());
        return message;
    }

}