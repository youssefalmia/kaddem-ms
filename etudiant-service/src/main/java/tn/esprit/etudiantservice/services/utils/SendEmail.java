package tn.esprit.etudiantservice.services.utils;

import javax.swing.*;
import java.util.*;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.MimeMessage;

/**
 * @author Jozef
 */
public class SendEmail {

    public static void sendEmail(String to, String sub, String msg) {
        String email = "joeytest9001@gmail.com";
        String password = "fllezfumiiqjvzeg";

        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");   // Assuming you are sending email from gmail
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        System.setProperty("mail.pop3s.ssl.protocols", "TLSv1.2");


        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {//un objet Authenticator optionnel qui permet d'authentifier l'utilisateur auprès du serveur de mails
                return new PasswordAuthentication(email, password);
            }
        });

        try {
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress("joeytest9001@gmail.com"));
            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject(sub);

            // Now set the actual message
            message.setText(msg);

            // Send message
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
