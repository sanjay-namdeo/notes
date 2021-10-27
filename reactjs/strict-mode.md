## React Strict Mode
Tools for highlighting potential problems in application. Like /Fragment/, /StrictMode/ does not render any visible UI. It activates additional checks and warnings for its descendants.

> Strict mode checks are run in development mode only; they do not impact the production build

1. **identifying unsafe lifecycles** Certain lifecycle methods are unsafe to use in asynchronous react applications. With the use of third-party libraries, it becomes difficult to ensure that certain lifecycle methods are not used. When strict mode is enabled, React compiles a list of all class component using the unsafe lifecycles, and log a warning message with information about these components.

```bash
Warning: unsafe lifecycle methods were found within a strict-mode: true
     in div (created by MyApp)
     in MyApp

componentWillMount: Please update the following components to use ComponentDidMount instead
```

2. **Warning  about legacy string ref API usage**

3. **Warning about deprecated findDOMNode usage**
   React used to support findDOMNode to search tree for a DOM node given a class instance. Normally you don't need this because you can /attach a ref directly to a DOM node/