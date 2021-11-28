package com.manning.application.notification.template.formatter.services;

import com.manning.application.notification.template.formatter.model.NotificationParameters;
import com.manning.application.notification.template.formatter.model.NotificationTemplateRequest;
import com.manning.application.notification.template.formatter.model.NotificationTemplateResponse;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;


import java.io.File;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NotificationTemplateService {


    @Autowired
    private SpringTemplateEngine templateEngine;




    public NotificationTemplateResponse getNotificationMergedTemplate(NotificationTemplateRequest notificationTemplateRequest) {
        String notificationContent="";
        Map<String, Object> notificationParametersMap =
            notificationTemplateRequest.getNotificationParameters().
                stream()
                .collect(Collectors
                    .toMap(NotificationParameters::getNotificationParameterName, NotificationParameters::getNotificationParameterValue));
        NotificationTemplateResponse notificationTemplateResponse=new NotificationTemplateResponse();

        if(notificationTemplateRequest.getNotificationMode().equals("EMAIL")) {
            Context context = new Context();
            context.setVariables(notificationParametersMap);
            File emailTemplateFile=new File("./src/main/resources/templates/email/"+notificationTemplateRequest.getNotificationTemplateName() + ".html");
            //System.out.println(emailTemplateFile.getAbsolutePath());
            NotificationTemplateResponse response = new NotificationTemplateResponse();
          if(emailTemplateFile.exists()) {
              notificationContent = templateEngine.process("./email/" + notificationTemplateRequest.getNotificationTemplateName() + ".html", context);
              response.setEmailContent(notificationContent);
              notificationTemplateResponse.setStatus("SUCCESS");
              notificationTemplateResponse.setStatusDescription("Successfully merged the template with the template parameters");
              notificationTemplateResponse.setEmailSubject("Message from Citizen Bank");
              notificationTemplateResponse.setEmailContent(notificationContent);
          }
            else
            {
                notificationTemplateResponse.setStatus("ERROR");
                notificationTemplateResponse.setStatusDescription("Email Template is not available");
            }

        }
        else {
            String smstemplateString = "";
            if (notificationTemplateRequest.getNotificationTemplateName().equalsIgnoreCase("ViewBalance")) {
                smstemplateString = this.getBalanceSMSTemplate();
            } else if (notificationTemplateRequest.getNotificationTemplateName().equalsIgnoreCase("PhoneNumberChanged")){
                smstemplateString = this.getPhoneNumberChanged();
            }
            if(!smstemplateString.equals("")) {
                StringSubstitutor sub = new StringSubstitutor(notificationParametersMap);
                notificationContent = sub.replace(smstemplateString);
                System.out.println(notificationContent);
                notificationTemplateResponse.setStatus("SUCCESS");
                notificationTemplateResponse.setStatusDescription("TSuccessfully merged the template with the template parameters");
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
            .concat("Your Phonenumber is changed from ${oldPhoneNumber} to ${newPhoneNumber}\n");
    }
}
