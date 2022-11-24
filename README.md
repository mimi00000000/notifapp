# Notifapp

## Project Structure

### Application Notification: 
The application triggers the notification services to initiate the notification flow, and the services orchestrate the flow of notification messages.
http://localhost:8080/api/notifications

### Notification Preferences: 
The application verifies the customer’s preferences and send the notification to his or her preferred channel.
- http://localhost:8081/notification/preferences

### Notification Template: 
The application formats the notification to create a unique, tailor-made message to the customer, such as a notification about a change of mobile number or address.
- http://localhost:8082/api/notifications/templates

### Notification Gateway: 
The application sends the notification to the customer’s email or mobile phone.
http://localhost:8083/api/notifications/send

## Add and Test the swagger with spring boot
- configure swagger: add @EnableSwagger2 annotation on the configuration class
along with the Docket bean.
```
  @Bean
  public Docket swagger() {
     return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
            .paths(PathSelectors.any())
            .build();
  }
```
- for spring boot version: 
```
            <parent>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-parent</artifactId>
               <version>2.5.7</version>
               <relativePath/> <!-- lookup parent from repository -->
            </parent>
```
- add: 
```
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-boot-starter</artifactId>
            <version>3.0.0</version>
       </dependency>
```
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
- [postman collection](https://api.postman.com/collections/8343597-8887c460-9d09-4f3b-b5e3-817efc7c8617?access_key=PMAT-01GJMHTGVJVKBQE346WQNFMBM5)

## Test Preferences:
-Post to http://localhost:8081/notification/preferences
```
    - Request: { "customerId": "123" }

    - Response: {
                        "customerId": "123",
                        "status": "SUCCESS",
                        "statusDescription": "Notification Received Successfully",
                        "smsPreferenceFlag": false,
                        "emailPreferenceFlag": true,
                        "emailAddress": "mariam.machaallah@gmail.com",
                        "phoneNumber": "+6588232374"
                    }
```

## Test Template:
- Post Url: http://localhost:8082/api/notifications/templates
```
  - Post Body:
                    {
                        "notificationParameters": [
                            {
                                "notificationParameterName": "name",
                                "notificationParameterValue": "Vamshi"
                            },
                            {
                                "notificationParameterName": "oldPhoneNumber",
                                "notificationParameterValue": "12345"
                            },
                            {
                                "notificationParameterName": "newPhoneNumber",
                                "notificationParameterValue": "09828723"
                            }
                        ],
                        "notificationTemplateName": "PhoneNumberChanged",
                        "notificationMode": "EMAIL"
                    }
  - Response:
                      {
                          "status": "SUCCESS",
                          "statusDescription": "Successfully merged the template with the template parameters",
                          "emailContent": "",
                          "smsContent": null,
                          "emailSubject": "Message from Citizen Bank"
                      }
```

## Test Notification Gateway:
- request: post to url http://localhost:8083/api/notifications/send
```
- request body: {
                  "customerId": "123",
                  "notificationMode": "EMAIL",
                  "notificationContent": "Hello Vamshi\n Welcome to the Citizen Bank\nYour balance is $ 47464646.50\nThanks",
                  "emailSubject": "ViewBalance",
                  "emailAddress":"mariam.machaallah@gmail.com",
                  "phoneNumber":"+6588232374"
                }
- request response: {
                        "status": "SUCCESS",
                        "statusDescription": "Send Sucessfully"
                    }
```

## Test Notification:
- request: post to url http://localhost:8080/api/notifications
```
- request body: {
                  "customerId": "123",
                  "notificationMode": "",
                  "notificationParameters": [
                {
                    "notificationParameterName":"name",
                    "notificationParameterValue":"Spandana"
                },
                {
                    "notificationParameterName":"accountnumber",
                    "notificationParameterValue":"XXXX12323245666"
                },  
                {
                    "notificationParameterName":"balance",
                    "notificationParameterValue":"$ 47464646.50"
                }
                
                  ],
                  "notificationTemplateName": "ViewBalance"
                }
                
- request response: {
                        "status": "SUCCESS",
                        "statusDescription": "Notification Received Successfully",
                        "notificationReferenceId": 1
                    }
```


