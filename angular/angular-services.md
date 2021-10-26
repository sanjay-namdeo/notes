## Services
Services are objects which get instantiated only once during the lifetime of an application. The main objective of a service is to share data, functions with different components of an Angular application.

A service is defined using a *@Injectable* decorator. A function defined inside a service can be invoked from any component or directive.
To create a service, run the following command:
```bash
ng g s test-service
```
