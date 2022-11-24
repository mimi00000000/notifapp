# Test the swagger
http://localhost:8080/swagger-ui/

# Postman
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