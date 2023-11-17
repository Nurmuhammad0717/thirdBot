package uz.pdp.bot.mail;

import lombok.SneakyThrows;
import uz.pdp.bot.MessageDetails;
import uz.pdp.bot.RegistrationDetails;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class MailManager {


    @SneakyThrows
    public static void sendMail( MessageDetails details, RegistrationDetails user){

        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "2525");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");



        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user.getUserName(),
                        user.getPassword());
            }
        };


        Session session = Session.getInstance(props, authenticator);

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(user.getUserName()));
        message.setRecipient(Message.RecipientType.TO,
                new InternetAddress(details.getRecipient()));
        message.setSubject(details.getSubject());
        message.setSubject(details.getText());

        System.out.println(user.toString());
        System.out.println(details.toString());

        Transport.send(message);

        System.out.println("done");



    }



}
