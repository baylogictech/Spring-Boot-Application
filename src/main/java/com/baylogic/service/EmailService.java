package com.baylogic.service;

import com.baylogic.model.EmailDetails;

public interface EmailService {
    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);
}
