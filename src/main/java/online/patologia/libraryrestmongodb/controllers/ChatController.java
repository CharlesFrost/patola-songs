package online.patologia.libraryrestmongodb.controllers;

import online.patologia.libraryrestmongodb.models.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class ChatController {
    @MessageMapping("/chat")
    @SendTo("/topic/public")
    public ChatMessage message(@Payload ChatMessage chatMessage, Principal principal) {
        return new ChatMessage(chatMessage.getValue(),principal.getName());
    }

}
