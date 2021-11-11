# Implement Security in Spring Boot

With a Spring Boot Application, you can fallback to Spring Security. Include the Spring Security Boot Starter :
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
    <version>2.1.6.RELEASE</version>
</dependency>
```
You can go with HTTP basic or form login.
To update the username or password , override the following properties in application properties file :
```properties
Spring.security.user.name = username1
Spring.security.user.password = password1
```
To enable method level security, you can use @EnableGlobalMethodSecurity.

To disable default Security configuration in-built, you need to exclude Security Auto Configuration class as follows :
```java
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringBootApplication1 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication1.class, args);
    }
}
```
This can be also achieved by adding following to properties file :
```properties
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration
```
@ConfigurationTo Override default Security you can implement WebSecurityConfigurerAdapter class , 

for example :
```java
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
        auth
          .inMemoryAuthentication()
          .withUser("username")
            .password("password1")
            .roles("GUEST")
            .and()
          .withUser("admin")
            .password("admin")
            .roles("GUEST", "ADMIN");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        HTTP
          .authorizeRequests()
          .anyRequest()
          .authenticated()
          .and()
          .httpBasic();
    }
}
```
`@EnableWebSecurity` is optional if the default security configuration is disabled.

Oauth2 is commonly used for authorization. To integrated OAuth2:

Add a starter for Oauth2
1. Use `@EnableAuthrizationServer`
2. Use` @EnableResourceServer` in an application where resource located 
3. On Client Side, use either of  `@EnableOAuth2Sso` or `@EnableOAuth2Client`.
