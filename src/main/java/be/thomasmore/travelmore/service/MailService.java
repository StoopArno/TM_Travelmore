package be.thomasmore.travelmore.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService {
    private static Session mailSession;

    private static final String HOST = "smtp.gmail.com";
    private static final int PORT = 465;
    private static final String USER = "javaproject.thomasmore";
    private static final String PASSWORD = "TravelMore";
    private static final String FROM = "Java Project <javaproject.thomasmore@gmail.com>";

    public static void send(String to,String sub,String msg)throws MessagingException{
        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", HOST);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.from", FROM);
        props.put("mail.smtps.quitwait", "false");

        mailSession = Session.getInstance(props);
        mailSession.setDebug(true);

        MimeMessage mimeMessage = new MimeMessage(mailSession);

        mimeMessage.setFrom(new InternetAddress(FROM));
        mimeMessage.setSender(new InternetAddress(FROM));
        mimeMessage.setSubject(sub);
        mimeMessage.setContent(msg, "text/html; charset=utf-8");

        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        Transport transport = mailSession.getTransport("smtps");
        transport.connect(HOST, PORT, USER, PASSWORD);

        transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.TO));
        transport.close();


    }
}
