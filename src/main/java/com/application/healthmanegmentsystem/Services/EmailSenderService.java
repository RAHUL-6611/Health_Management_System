package com.application.healthmanegmentsystem.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public Boolean sendSimpleMail(String toEmail,String body,String subject){
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("medcareplatform@gmail.com");
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(body);
//            message.setCc("akashtandle987@gmail.com");
            mailSender.send(message);
            return true;
        }
        catch (Exception exception){
            return false;
        }

    }
}
