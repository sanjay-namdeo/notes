# Microservices Communication: Service to Service

Let's see the sequence of how one microservice calls another microservice using Eureka server.

## Registering the Service
Each microservice should be registered into the service registry with a unique name {service-id}, so it can be identified. Please note that it is an important step, as one of the main benefits of microservices is autoscaling; we can’t rely on the hostname/IP address, so a unique name is important in a distributed environment.

## Fetching the Registry
Before calling the downstream/dependent service, the caller service fetches the registry from Eureka server. The registry contains all the active services registered into the service registry.

## Finding the Downstream Service
Now, using the unique service Id, the caller service gets the instance of the downstream service.

## Resolving Underlying IP Address
Please note the service id act as a Key in service registry but network does not know about it network expects Hostname to call the desired Rest Endpoint on the dependent service like `localhost:8080/employee/{id}` so it is required to resolve the actual hostname of the dependent service Eureka API provides a method for that we just invoke that method to get the Ip address, For a distributed system it is the public IP of Load balancer.

## Call the Rest Endpoint
After resolving the IP address using Spring Resttemplate, we call the actual Rest endpoint and get the data.

## Example
For this example, we need three microservices projects:

1. Employee Search Service, for searching Employee information.
2. Eureka Server
3. Employee Dashboard Service: we will create this module and call the Employee Search service via Eureka server to get Employee information.

### Step 1:
Create a service called EmployeeSearchSearch.java where I insert some employeesusing static block and using Java 8 Stream. After that, I add two methods, findById and findAll, to display Employee information accordingly.
```java
@Service
public class EmployeeSearchService {

    private static Map < Long, Employee > EmployeeRepsitory = null;

    static {

        Stream < String > employeeStream = Stream.of("1,Shamik  Mitra,Java,Architect", "2,Samir  Mitra,C++,Manager",
            "3,Swastika  Mitra,AI,Sr.Architect");

        EmployeeRepsitory = employeeStream.map(employeeStr - > {
            String[] info = employeeStr.split(",");
            return createEmployee(new Long(info[0]), info[1], info[2], info[3]);
        }).collect(Collectors.toMap(Employee::getEmployeeId, emp - > emp));

    }

    private static Employee createEmployee(Long id, String name, String practiceArea, String designation) {
        Employee emp = new Employee();
        emp.setEmployeeId(id);
        emp.setName(name);
        emp.setPracticeArea(practiceArea);
        emp.setDesignation(designation);
        emp.setCompanyInfo("Alphabets");
        return emp;
    }

    public Employee findById(Long id) {
        return EmployeeRepsitory.get(id);
    }

    public Collection < Employee > findAll() {
        return EmployeeRepsitory.values();
    }

}
```
### Step 2: 
Now add a new controller called EmployeeSearchController; expose two endpoints by which other services can call findById and findAll methods. findById takes Employee Id and returns the Employee Domain Object.
```java
@RefreshScope
@RestController
public class EmployeeSearchController {

   @Autowired
   EmployeeSearchService employeeSearchService;

   @RequestMapping("/employee/find/{id}")
   public Employee findById(@PathVariable Long id){
      return employeeSearchService.findById(id);
   }

   @RequestMapping("/employee/findall")
   public Collection<Employee> findAll(){
      return employeeSearchService.findAll();
   }
}
```
Employee Domain Object
```java
public class Employee {
   private Long employeeId;
   private String name;
   private String practiceArea;
   private String designation;
   private String companyInfo;
   public Long getEmployeeId() {
      return employeeId;
   }
   public void setEmployeeId(Long employeeId) {
      this.employeeId = employeeId;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getPracticeArea() {
      return practiceArea;
   }
   public void setPracticeArea(String practiceArea) {
      this.practiceArea = practiceArea;
   }
   public String getDesignation() {
      return designation;
   }
   public void setDesignation(String designation) {
      this.designation = designation;
   }
   public String getCompanyInfo() {
      return companyInfo;
   }
   public void setCompanyInfo(String companyInfo) {
      this.companyInfo = companyInfo;
   }
   @Override
   public String toString() {
      return "Employee [employeeId=" + employeeId + ", name=" + name + ", practiceArea=" + practiceArea
              + ", designation=" + designation + ", companyInfo=" + companyInfo + "]";
   }
}
```
### Step 3: 
Create an EmployeeDashBoard application by downloading the template for this; I chose actuator, config client, web, Jersey, and EurekaClient modules.
Now put @EnableDiscoveryClient on top of the EmployeeDashBoardApplication class to treat this module as Eureka Client and add RestTemplate as a Spring Bean.
```java
@EnableDiscoveryClient
@SpringBootApplication
public class EmployeeDashBoardServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeDashBoardServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
```
Also, rename the application.properties to bootstrap properties and write the following properties:
```properties
spring.application.name=EmployeeDashBoard
spring.cloud.config.uri=http://localhost:9090
eureka.client.serviceUrl.defaultZone=http://localhost:9091/eureka
server.port=8081
security.basic.enable=false   
management.security.enabled=false
```
### Step 4
Now create a Controller called EmployeeInfoController and call the  Service Registry, then find the EmployeeSerchService by passing the service-id of the Employee Service (EmployeeService-> bootstrap.properties).

Now call the IpAddress method to resolve Ip address and call the dependent service using RestTemplate.
```java
@RefreshScope
@RestController
public class EmployeeInfoController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @Value("${service.employyesearch.serviceId}")
    private String employeeSearchServiceId;

    @RequestMapping("/dashboard/{myself}")
    public EmployeeInfo findme(@PathVariable Long myself) {
        Application application = eurekaClient.getApplication(employeeSearchServiceId);
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "employee/find/" + myself;
        System.out.println("URL" + url);
        EmployeeInfo emp = restTemplate.getForObject(url, EmployeeInfo.class);
        System.out.println("RESPONSE " + emp);
        return emp;
    }

    @RequestMapping("/dashboard/peers")
    public Collection < EmployeeInfo > findPeers() {
        Application application = eurekaClient.getApplication(employeeSearchServiceId);
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "employee/findall";
        System.out.println("URL" + url);
        Collection < EmployeeInfo > list = restTemplate.getForObject(url, Collection.class);
        System.out.println("RESPONSE " + list);
        return list;
    }
}
```
Then up the services in the following order:

Start config server.
Start Eureka Server.
Start Employee Search Service.
Start Employee DashBoard Service.
When all services are Up-- hit http://localhost:9091 in the browser and you will see all services are up and running.

Then hit the following URL: http://localhost:8081/dashboard/2

You will see the Following Output:

```json
{
    "employeeId": 1,
    "name": "Mark Steve",
    "practiceArea": "Microservice",
    "designation": "Senior Dev",
    "companyInfo": "Alphabets"
}
```
