package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;


@Service
public class MailService {


    @Autowired
    private JavaMailSender javaMailSender;

    private TemplateEngine templateEngine;

    @Autowired
    public MailService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Async
    public void sendEmail(String message,String name) throws MessagingException, IOException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("burak.saglik@detaysoft.com");
        helper.setSubject("Blog Mesajı Adı: " + name);
//        String content = this.build(message);
        helper.setText(message);
        javaMailSender.send(msg);
    }

    public String build(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        return templateEngine.process("RolTemplate", context);
    }

}

