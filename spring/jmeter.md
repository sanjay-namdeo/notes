## JMeter
JMeter is used for performance Lad Testing

It acts like a group of users sending requests to a target server. It collects response from the target server and other statistics which show the performance of the application or server via graphs or tables.

### Thread Group
*The begining part of any test plan* You can set number of users and time to load all the users given in the thread group.

### Samplers
*It allows JMeter to send specific types of requests to the server. Through samplers, thread group decided which type of request it need to make. Some of the useful samplers are HTTP request, FTP request, JDBC request and so on.

### Assertions
It helps to verify that your server under test returns the expected results. Some commonly used Assertions in JMeter are
1. Response assertion
2. Duration assertion
3. Size assertion
4. XML assertion
5. HTML assertion
