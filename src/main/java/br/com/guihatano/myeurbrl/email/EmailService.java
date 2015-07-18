package br.com.guihatano.myeurbrl.email;

import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
public class EmailService {

    @Resource(mappedName = "java:/mail/quotationMail")
    private Session mailSession;

    public void sendEmail(String to, String subject, String body) {
        MimeMessage message = new MimeMessage(mailSession);
        try {

            message.setFrom(new InternetAddress("myProject"));
            InternetAddress[] address = {new InternetAddress(to)};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText(body);

            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}
