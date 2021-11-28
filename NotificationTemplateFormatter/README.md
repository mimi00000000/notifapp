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
                    
  - Resposne if notificationMode is SMS:
                      {
                          "status": "SUCCESS",
                          "statusDescription": "TSuccessfully merged the template with the template parameters",
                          "emailContent": null,
                          "smsContent": "Hello Vamshi\nWelcome to the Citizen Bank\nYour Phonenumber is changed from 12345 to 09828723\n",
                          "emailSubject": null
                      }
