package com.mimi.notification.preferences.services;

import com.mimi.notification.preferences.model.NotificationParameters;
import com.mimi.notification.preferences.model.NotificationTemplateRequest;
import com.mimi.notification.preferences.model.NotificationTemplateResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;


import java.io.File;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NotificationTemplateService {


    @Autowired
    private SpringTemplateEngine templateEngine;

    @Value("${notification.template.path}")
    private String notificationTemplatePath;

    public NotificationTemplateResponse getNotificationMergedTemplate(NotificationTemplateRequest notificationTemplateRequest) {
        log.info(" ********** Notification Type " + notificationTemplateRequest.getNotificationMode());
        String notificationContent = "";
        Map<String, Object> notificationParametersMap =  notificationTemplateRequest.getNotificationParameters()
                .stream()
                .collect(Collectors.toMap(NotificationParameters::getNotificationParameterName, NotificationParameters::getNotificationParameterValue));
        NotificationTemplateResponse notificationTemplateResponse = new NotificationTemplateResponse();
        if (notificationTemplateRequest.getNotificationMode().equals("EMAIL")) {
            Context context = new Context();
            context.setVariables(notificationParametersMap);
            File emailTemplateFile = new File(notificationTemplatePath + notificationTemplateRequest.getNotificationTemplateName() + ".html");
            log.info(" ********** Email path " + emailTemplateFile.getAbsolutePath());
            NotificationTemplateResponse response = new NotificationTemplateResponse();
            if (emailTemplateFile.exists()) {
                notificationContent = templateEngine.process("./email/" + notificationTemplateRequest.getNotificationTemplateName() + ".html", context);
                response.setEmailContent(notificationContent);
                notificationTemplateResponse.setStatus("SUCCESS");
                notificationTemplateResponse.setStatusDescription("Successfully merged the template with the template parameters");
                notificationTemplateResponse.setEmailSubject("Message from Citizen Bank");
                notificationTemplateResponse.setEmailContent(notificationContent);
            } else {
                notificationTemplateResponse.setStatus("ERROR");
                notificationTemplateResponse.setStatusDescription("Email Template is not available");
            }
        }
        if (notificationTemplateRequest.getNotificationMode().equals("SMS")) {
            String smstemplateString = "";
            if (notificationTemplateRequest.getNotificationTemplateName().equalsIgnoreCase("ViewBalance")) {
                smstemplateString = NotificationTemplateService.getBalanceSMSTemplate();
            } else if (notificationTemplateRequest.getNotificationTemplateName().equalsIgnoreCase("PhoneNumberChanged")){
                smstemplateString = this.getPhoneNumberChanged();
            }
            if(!smstemplateString.equals("")) {
                StringSubstitutor sub = new StringSubstitutor(notificationParametersMap);
                notificationContent = sub.replace(smstemplateString);
                log.info(" ********** SMS notification content " + notificationContent);
                notificationTemplateResponse.setStatus("SUCCESS");
                notificationTemplateResponse.setStatusDescription("Successfully merged the template with the template parameters");
                notificationTemplateResponse.setSmsContent(notificationContent);
            }
            else {
                notificationTemplateResponse.setStatus("ERROR");
                notificationTemplateResponse.setStatusDescription("Email Template is not available");
            }
        }
        return notificationTemplateResponse;
    }

    public static String getBalanceSMSTemplate() {
        return "Hello ${name}"
                .concat("\n")
                .concat("Welcome to the Citizen Bank\n")
                .concat("Your balance is ${balance}\n")
                .concat("Thanks");
    }

    private String getPhoneNumberChanged() {
        return "Hello ${name}"
                .concat("\n")
                .concat("Welcome to the Citizen Bank\n")
                .concat("Your Phone number is changed from ${oldPhoneNumber} to ${newPhoneNumber}\n");
    }
}
