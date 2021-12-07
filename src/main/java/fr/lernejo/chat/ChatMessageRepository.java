package fr.lernejo.chat;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChatMessageRepository {
    private List<String> messages = new ArrayList<String>();

    public void addChatMessage(String message){
        messages.add(message);
    }

    public List<String> getLastTenMessages(){
        try {
            int messageSize = this.messages.size();
            System.out.println("Taille :" + messageSize);
            List<String> tenMessages = this.messages.subList(messageSize-10, this.messages.size());

            return tenMessages;
        }catch (IndexOutOfBoundsException e){
            System.out.println("Erreur");
            return messages;
        }

    }
}
