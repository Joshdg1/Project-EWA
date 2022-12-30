package com.flo4.server.service;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendMessage(Mail mail){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("Joshdg1999@gmail.com");
        simpleMailMessage.setTo(mail.getTo());
        simpleMailMessage.setSubject("Reset password");
        simpleMailMessage.setText(mail.getCode());
        this.javaMailSender.send(simpleMailMessage);
    }
}
