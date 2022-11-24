# Notification Preferences: 
Applications verify the customer’s preferences and send the notification to his or her preferred channel.

# Test Using Postman
Post to http://localhost:8081/notification/preferences
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