For better understanding, I would like you to create an Angular application by running the following inside the command terminal:
```bash
ng new angularApp
```
The above command will create an angular application in the directory.
Next, let's move on to understand Components, Modules, and Services.

### Components
In Angular, components are the basic building blocks, which control a part of the UI for any application.
A component is defined using the @Component decorator. Every component consists of three parts, the template which loads the view for the component, a stylesheet which defines the look and feel for the component, and a class that contains the business logic for the component.
For creating a component, inside the command terminal, navigate to the directory of the application created, and run the following command:
```bash
ng generate component test
ng g c test
```


One can see the generated component inside src/app/test folder. The component will be defined inside test.component.ts and this is how it looks:
```javascript
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {

  constructor() {}

  ngOnInit() {
  }
}
```
  
As we can see in the above image, our component is defined with @Component decorator.

### Modules
A module is a place where we can group components, directives, services, and pipes. Module decides whether the components, directives, etc. can be used by other modules, by exporting or hiding these elements. Every module is defined with a @NgModule decorator.
By default, modules are of two types:
1. Root Module
2. Feature Module
Every application can have only one root module whereas, it can have one or more feature modules.
A root module imports BrowserModule, whereas a feature module imports CommonModule.
In the application that we created before, one can see that the root module is defined inside app.module.ts and this is how it looks:
    
We can see in the above image that the component we created earlier is already imported in the declarations array.

To create a feature module, run the following command:
```bash
ng g m test-module
```

The module is created inside the src/app/test-module/test-module.module.ts file:
```javascript
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class TestModuleModule { }
```  
  
As one can see, CommonModule is imported since this is a feature module.

### Services
Services are objects which get instantiated only once during the lifetime of an application. The main objective of a service is to share data, functions with different components of an Angular application.
A service is defined using an @Injectable decorator. A function defined inside a service can be invoked from any component or directive.

To create a service, run the following command:
```bash
ng g s test-service
```

The service will be created inside src/app/test-service.service.ts:
```javascript
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TestServiceService {
  constructor() { }
}
```
  
Any method/function defined inside the TestServiceService class can be directly used inside any component by just importing the service.
