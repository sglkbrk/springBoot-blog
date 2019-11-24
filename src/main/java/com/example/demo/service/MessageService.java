package com.example.demo.service;

import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public Message sendMessage(Message message){
        message.setMail("S");
        return messageRepository.save(message);
    }

    public List<Message> getsendMail(String message){
        return messageRepository.findAllByMail(message);
    }

    public Message savedMail(Message message){
        return messageRepository.save(message);
    }
}
