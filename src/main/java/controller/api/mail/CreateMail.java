package controller.api.mail;

import com.sun.mail.smtp.SMTPTransport;
import core.AppConfig;
import core.IBaseApi;
import core.om.StatusEnum;
import core.om.request.CreateMailRequest;
import core.om.response.CreateMailResponse;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

public class CreateMail implements IBaseApi<CreateMailRequest, CreateMailResponse> {

    public CreateMailResponse execute(CreateMailRequest request) {

        Properties prop = new Properties();
        prop.put("mail.smtp.host", AppConfig.smtpConfig.getHost());
        prop.put("mail.smtp.auth", AppConfig.smtpConfig.getAuth());
        prop.put("mail.smtp.port", AppConfig.smtpConfig.getPort().toString());

        Session session = Session.getInstance(prop, null);
        Message msg = new MimeMessage(session);

        try {

            msg.setFrom(new InternetAddress(request.getEmailFrom()));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(request.getEmailTo(), false));
            if (Objects.nonNull(request.getEmailCc())) {
                msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(request.getEmailCc(), false));
            }
            msg.setSubject(request.getEmailSubject());
            msg.setText(request.getEmailText());
            msg.setSentDate(new Date());

            SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

            t.connect(AppConfig.smtpConfig.getHost(),
                    AppConfig.smtpConfig.getUsername(),
                    AppConfig.smtpConfig.getPassword());
            t.sendMessage(msg, msg.getAllRecipients());

            System.out.println("Response Code: " + t.getLastReturnCode());
            t.close();

            return new CreateMailResponse(StatusEnum.OK);
        } catch (MessagingException e) {
            e.printStackTrace();
            return new CreateMailResponse(StatusEnum.KO);
        }


    }
}
