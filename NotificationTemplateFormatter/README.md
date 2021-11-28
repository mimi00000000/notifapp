# Test the the swagger url
http://localhost:8082/swagger-ui/
    
# Test with postman
- Post Url: http://localhost:8082/api/notifications/templates
- Post Body:
                  {
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
                        "emailContent": "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <title>Citizen Bank</title>\n\n  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n\n  <link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'/>\n\n  <!-- use the font -->\n  <style>\n        body {\n            font-family: 'Roboto', sans-serif;\n            font-size: 48px;\n        }\n    </style>\n</head>\n<body>\n<p>Hello Vamshi</p>\n\n<p>Welcome to Citizen Bank</p>\n</p>\n<p>Your Phone number is changed from 12345 to 09828723 as of 28 Nov 2021 23:05</p>\n<p>\n  You can login to internet banking channel to view more details on the account</p>\n<p>\n  Regards, <br />\n<p>Citizen Bank</p>\n<p>United States</p>\n</p>\n</body>\n</html>\n",
                        "smsContent": null,
                        "emailSubject": "Message from Citizen Bank"
                    }
