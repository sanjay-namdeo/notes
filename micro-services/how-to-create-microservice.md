## How to create a microservice

### Server
1. Annotate main class with *@EnableEurekaServer* It will activate Eureka Server Configuration.
2. Set it's name as discovery server *spring.application.name=calculator.discovery.server*
3. Set port *server.port=8761*

### Client
1. Annotate main clas with *@EnableEurekaClient* It turns on discovery and let autoconfiguration find the euroka classes if they are available.
2. Set client name *spring.application.name=calculator.sum.service*
3. Set port *server.port=8082*
4. Set *serviceUrl* for Eureka server
```properties
eureka.client.serviceUrl.defaultZone=${EUREKA_URI:http://localhost:8761/eureka}
```
### Consumer
1. Annotate main class with *@EnableFeignClients*
2. Set name *spring.application.name=calculator*
3. Set port *server.port=8081*
4. Set *serviceUrl* for Eureka Server 
```properties
eureka.client.serviceUrl.defaultZone=${EUREKA}
```
5. Create a Service and annotate with *@FeignClient* and pass *name of client* as parameter *@FeignClient("calculator.sub.service)"*
6. Autowire service *@Autowired* private SumService sumService
7. Create a method RequestMapping method and call client's method using service.
