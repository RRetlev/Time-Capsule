package com.codecool.timecapsule.services;

import com.codecool.timecapsule.model.Email;
import com.codecool.timecapsule.model.Message;
import com.codecool.timecapsule.model.OneuseURL;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service

public class EmailService {

    private final String username = "capsuleoftimeofcc@gmail.com";
    private final String psw = "Csicsiphp";

    public void sendEmail(List<Email> emails) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, psw);
                    }
                });

        for (Email email: emails
             ) {
            try {

                javax.mail.Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("capsuleoftimeofcc@gmail.com"));
                message.setRecipients(
                        javax.mail.Message.RecipientType.TO,
                        InternetAddress.parse(email.getAddress())
                );
                message.setSubject(email.getSubject());
                message.setText(email.getPayload());
                Transport.send(message);

                System.out.println("Done");

            } catch (MessagingException e) {
                e.printStackTrace();
            }

        }

    }

    /* cron is a  date format as follows second/minute/hour/day/year
      "*" means all "?" means any  */

    @Scheduled(cron = "0 0 10 * * ?")
    public void sendMessage() {

    }
}
