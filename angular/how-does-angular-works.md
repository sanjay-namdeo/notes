## How does Angular work?

### Step 1 - angular.json
Every Angular app has *angular.json* file, which contain all the configurations of the app. While building app, the builder looks at this file to find the entry point of the application.
```javascript
"build" {
  "builder": "@angular-devkit/build-angular:browser",
  "options": {
      "outputPath": "dist/angular-starter",
      "index": "src/index.html",
      *"main": "src/main.ts"*,
      "aot": false
  }
}
```

### Step 2 - main.ts
*main.ts* file creates a browser environment for the application to run, along with this it calls a function named *bootstrapModule*, which bootstraps the application.
```javascript
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
*platformBrowserDynamic.bootstrapModule(AppModule)*
```

### Step 3 - AppModule
*AppModule* is declaraed in the file app.module.ts. This module contains declarations of all the components.
```javascript
import { BrowserModule } from ''@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';

@NgModule({
  declaration: [AppComponent],
  imports: [BrowserModule],
  providers: [],
  entryComponents: [],
  *bootstrap: [AppComponent]*
})

export class AppModule;
```

### Step 4 - AppComponent
As you can see in the above AppModule, *AppComponent* is getting bootstrapped. This is defined in app.component.ts file. The file interacts with webpage and serves data to it. It contains:
1. *selector* used for accessing the component 'app-root'
2. *template*/*templateURL* contains HTML of the component
3. *styleUrls* contains component specific stylesheets
```javascript
import { Component } from '@angular/core';

@Component ({
  selector: *'app-root'*,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Angular';
}
```

### Step 5 - index.html
Angular calls index.html file. This file calls the root component 'app-root', which is defined in app.component.ts.
```html
<body>
    <app-root></app-root>
</body>
```
