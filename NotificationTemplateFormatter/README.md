# Test the the swagger url
http://localhost:8082/swagger-ui/
    
# Test with postman
  - Post Url: http://localhost:8082/api/notifications/templates
  - Post Body:  {
                    "notificationParameters": [
                  {
                      "notificationParameterName":"name",
                      "notificationParameterValue":"Vamshi"
                  },
                  {
                      "notificationParameterName":"oldPhoneNumber",
                      "notificationParameterValue":"12345"
                  },
                  {
                      "notificationParameterName":"newPhoneNumber",
                      "notificationParameterValue":"09828723"
                  }

                    ],
                    "notificationTemplateName": "PhoneNumberChanged",
                    "notificationMode":"EMAIL"
                  }
  - Response:
                    {
                        "status": "SUCCESS",
                        "statusDescription": "Successfully merged the template with the template parameters",
                        "emailContent": "",
                        "smsContent": null,
                        "emailSubject": "Message from Citizen Bank"
                    }
