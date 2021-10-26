## AOT vs JIT
Every Angular application consists of components and templates which the browser cannot understand. Therefore, all the Angular applications need to be compiled first before running inside the browser.

Angular provides two types of compilation:

1. In **JIT(Just-in-Time) compilation** the application compiles inside the browser during runtime.
2. In **AOT(Ahead-of-Time) compilation** the application compiles during the build time.

### The advantages of using AOT compilation are:
1. Since the application compiles before running inside the browser, the browser loads the executable code and renders the application immediately, which leads to faster rendering.

2. In AOT compilation, the compiler sends the external HTML and CSS files along with the application, eliminating separate AJAX requests for those source files, which leads to fewer ajax requests.

3. Developers can detect and handle errors during the building phase, which helps in minimizing errors.

4. The AOT compiler adds HTML and templates into the JS files before they run inside the browser. Due to this, there are no extra HTML files to be read, which provide better security to the application.

### By default, angular builds and serves the application using JIT compiler:
```bash
ng build
ng serve
```

### For using AOT compiler following changes should be made:
```bash
ng build --aot
ng serve --aot
```
