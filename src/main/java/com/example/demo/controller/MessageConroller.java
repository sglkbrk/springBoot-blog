package com.example.demo.controller;


import com.example.demo.model.Message;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("MessageService")
@RestController
public class MessageConroller {

    @Autowired
    MessageService messageService;

    @PostMapping("/sendMessage")
    public Message sendMessage(@Valid @RequestBody Message message) {
        return messageService.sendMessage(message);
    }
}
