package fr.lernejo.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChatMessageController {
    private static ChatMessageRepository messageRepository = null;

    public ChatMessageController(ChatMessageRepository repository){
        messageRepository = repository;
    }

    @GetMapping(path = "/api/message")
    public List<String> getLastTenMessages() {
        List<String> messages = messageRepository.getLastTenMessages();

        return messages;
    }
}
