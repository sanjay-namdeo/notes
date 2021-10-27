## How Is Spring Security Implemented In a Spring Boot Application?

### Authentication
1. Implement an `authentication filter` to issue JWT to users sending credentials,
2. Implement an `authorization filter` to validate requests containing JWT,
3. Create a custom implementation of UserDetailsService to help Spring Security loading user-specific data in the framework,
4. Extend the `WebSecurityConfigurerAdapter` class to customize the security framework to our needs.

### Authorization
To add Spring Security, following steps are required:
1. Add dependency `spring-boot-starter-security`
2. Implement `WebSecurityConfigurerAdapter`
3. Override `configure` method

Minimal configuration is needed for implementation. All you need to do is add the  in the pom.xml file. You will also need to create a Spring config class that will override the required method while extending the WebSecurityConfigurerAdapter to achieve security in the application. Here is some example code:
```java
package com.gkatzioura.security.securityendpoints.config; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; 
@Configuration 
public class SecurityConfig extends WebSecurityConfigurerAdapter {     
        @Override     
        protected void configure(HttpSecurity http) {         
                http.authorizeRequests()             
                .antMatchers("/welcome").permitAll()             
                .anyRequest().authenticated()             
                .and()             
                .formLogin()             
                .permitAll()             
                .and()             
                .logout()             
                .permitAll();     
        } 
}
```
