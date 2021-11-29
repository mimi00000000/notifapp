package com.mimi.notification.preferences.services;

import com.mimi.notification.preferences.model.NotificationGatewayRequest;
import com.mimi.notification.preferences.model.NotificationGatewayResponse;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
@Configuration
public class NotificationGatewayService {

    @Autowired
    private JavaMailSender emailSender;

    @Value("${email.from}")
    private String emailFrom;

    @Value("${twilio.username}")
    private String twilioUsername;

    @Value("${twilio.password}")
    private String twilioPassword;

    @Value("${twilio.fromPhoneNumber}")
    private String twilioFromPhoneNumber;

    public NotificationGatewayResponse sendEmailNotification(@RequestBody NotificationGatewayRequest notificationGatewayRequest) {

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            helper.addAttachment("CitizenBank.png", new ClassPathResource("CitizenBank.png"));

            helper.setTo(notificationGatewayRequest.getEmailAddress());
            helper.setText(notificationGatewayRequest.getNotificationContent(), true);
            helper.setSubject(notificationGatewayRequest.getEmailSubject());
            helper.setFrom(emailFrom);
            emailSender.send(message);

        }
        catch (MessagingException e) {
            e.printStackTrace();
        }
        NotificationGatewayResponse response = new NotificationGatewayResponse();
        response.setStatus("SUCCESS");
        response.setStatusDescription("Send Sucessfully");
        return response;
    }


    public NotificationGatewayResponse sendSMSNotification(NotificationGatewayRequest notificationGatewayRequest) {
        NotificationGatewayResponse response=new NotificationGatewayResponse();
        Twilio.init(twilioUsername, twilioPassword);
        Message message = Message.creator(
                new PhoneNumber(notificationGatewayRequest.getPhoneNumber()),
                new PhoneNumber(twilioFromPhoneNumber),
                notificationGatewayRequest.getNotificationContent())
                .create();
        if(message.getStatus().toString().equalsIgnoreCase("SENT")) {
            response.setStatus("SUCCESS");
            response.setStatusDescription(message.getStatus().toString());
        }
        else
            response.setStatus("SUCCESS");
        response.setStatusDescription("Send Sucessfully");
        return response;

    }
}
