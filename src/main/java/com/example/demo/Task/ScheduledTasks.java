package com.example.demo.Task;

import com.example.demo.model.Message;
import com.example.demo.service.MailService;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@Component
public class ScheduledTasks {

    @Autowired
    MailService mailService;

    @Autowired
    MessageService messageService;

    @Scheduled(fixedRate = 900000)
    public void mailScheduledTask() throws IOException, MessagingException {
        List<Message> messages = messageService.getsendMail("S");
        for(Message message : messages) {
            message.setMail("X");
            mailService.sendEmail(message.getMessage(),message.getName());
            messageService.savedMail(message);

        }
    }
}