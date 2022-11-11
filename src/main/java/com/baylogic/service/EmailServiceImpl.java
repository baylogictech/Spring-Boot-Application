package com.baylogic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.baylogic.model.EmailDetails;

@Service
public class EmailServiceImpl implements EmailService {

    
    @Autowired
    private JavaMailSender javaMailSender;
    
    @Value("${spring.mail.username}") private String sender;
    @Value("${spring.mail.signature}") private String signature;
 
    // Method 1
    // To send a simple email
    public String sendSimpleMail(EmailDetails details)
    {
 
        // Try block to check for exceptions
        try {
 
            // Creating a simple mail message
            SimpleMailMessage mailMessage
                = new SimpleMailMessage();
 
            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(details.getRecipient());
            mailMessage.setSubject(details.getSubject());
            details.setMsgBody(details.getMsgBody() + signature);
            mailMessage.setText(details.getMsgBody());
            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
	
}
