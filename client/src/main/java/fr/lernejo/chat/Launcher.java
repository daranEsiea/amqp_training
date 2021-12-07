package fr.lernejo.chat;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Launcher {
    public static void main(String[] args){
        while(true){
            Scanner sc = new Scanner(System.in);
            ApplicationContext context = new AnnotationConfigApplicationContext(Launcher.class);
            RabbitTemplate template = context.getBean(RabbitTemplate.class);
            template.setRoutingKey("chat_messages");
            String message = sc.next();
            template.convertAndSend(message);
            System.out.println("Sent: " + message);
        }

    }
}
