# Project Structure

## Application Notification: 
Applications trigger the notification services to initiate the notification flow, and the services orchestrate the flow of notification messages.
## Notification Preferences: 
Applications verify the customer’s preferences and send the notification to his or her preferred channel.
## Notification Template: 
Applications format the notification to create a unique, tailor-made message to the customer, such as a notification about a change of mobile number or address.
## Notification Gateway: 
Applications send the notification to the customer’s email or mobile phone.


## Add and Test the swagger with spring boot
- for spring boot version: <parent>
                            <groupId>org.springframework.boot</groupId>
                            <artifactId>spring-boot-starter-parent</artifactId>
                            <version>2.5.7</version>
                            <relativePath/> <!-- lookup parent from repository -->
                        </parent>
- add: <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-boot-starter</artifactId>
                <version>3.0.0</version>
            </dependency>
- to test it http://localhost:8081/swagger-ui/


# Project packages

## config:
 All the configuration classes should be placed in this package.
## controllers:
 All the controller classes that contain the exposed API should be placed in this package.
## model:
 All the Java POJOs for the service should be placed in this package.
## entities:
 All the database entity objects should be placed in this package with the correct annotations used, such as @Entity, @Table, @Id, and @OneToMany.
## formatters:
 All the request/response translations to the target service methods should be placed in this package.
## repositories:
 All the JPA repositories should be placed in this package.
## services:
 All the services supporting the controller classes should be placed in this package.
## integration:
 All the integrations with the destination services or database should be placed in this package.


# Test Using Postman

    -Post to http://localhost:8081/notification/preferences

    - Request: { "customerId": "123" }

    - Response: {
                        "customerId": "123",
                        "status": "SUCCESS",
                        "statusDescription": "Notification Received Successfully",
                        "smsPreferenceFlag": false,
                        "emailPreferenceFlag": true,
                        "emailAddress": "vamshi.kesetty@gmail.com",
                        "phoneNumber": "+6588232374"
                    }




## Test the the swagger url
http://localhost:8082/swagger-ui/
    
## Test with postman
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
