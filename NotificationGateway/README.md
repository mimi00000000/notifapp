# Test the swagger
http://localhost:8083/swagger-ui/

# Postman
- request: post to url http://localhost:8083/api/notifications/send
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