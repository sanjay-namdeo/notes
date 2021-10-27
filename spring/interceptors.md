# Spring Interceptor 
Spring interceptors has the *ability to pre-handle and post-handle the web requests*. Each interceptor class should implement the *HandlerInterceptor* interface.

`HandleInterceptor` interface contains three main methods:

1. `preHandle()` perform operations before sending the request to the controller. This method should return true to return the response to the client.
2. `postHandle()` perform operations before sending the response to the client.
3. `afterCompletion()` perform operations after completing the request and response.

## How to use
1. Implement `InterceptorHandler` and override the required methods.
2. Create a config class which implements `WebMvcConfigurer`.
3. Override `addInterceptor` which gives access to `InterceptorRegistry`.
4. Inject out interceptor in this class and add to registry.

## Example
Let's create MyInterceptor and configure it using AppInterceptorConfig

### AppInterceptor
```java
@Component
public class AppInterceptor implements HandlerInterceptor {
    @Overrise
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
         System.out.println("preHandle");
         return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("afterCompletion");
    }
}
```

### AppInterceptorConfig.java
```java
@Configuration
public class AppInterceptorConfig implements WebMvcConfigurer {
    private AppInterceptor appInterceptor;

   public AppInterceptorConfig(AppInterceptor appInterceptor) {
       this.appInterceptor = appInterceptor; 
   }

   @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(appInterceptor);
    }
}
```
