package com.booksmart.utility;


import com.booksmart.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

@Component
public class MailConstructor {
    @Autowired
    private Environment env;

    @Autowired
    private TemplateEngine templateEngine;

    public SimpleMailMessage constructNewUserEmail(User user) {
        String message = "\nYour Username is " + user.getUsername() +" and your password is " + user.getPassword();
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("BookSmart - New User");
        email.setText(message);
        email.setFrom("noreply@booksmart.com");
        return email;
    }
}
