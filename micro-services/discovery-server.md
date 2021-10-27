## How Can You Set Up Service Discovery?
There are multiple ways to set up service discovery. I’ll choose the one that I think to be most efficient, Eureka by Netflix. It is a hassle-free procedure that does not weigh much on the application. Plus, it supports numerous types of web applications.

Eureka configuration involves two steps – client configuration and server configuration.
Client configuration can be done easily by using the property files. In the classpath, Eureka searches for a eureka-client.properties file. It also searches for overrides caused by the environment in property files which are environment specific.

For server configuration, you have to configure the client first. Once that is done, the server fires up a client which is used to find other servers. The Eureka server, by default, uses the Client configuration to find the peer server.
