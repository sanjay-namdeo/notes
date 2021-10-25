HOCs are not part of the React API. They are a *pattern* that emerges from React's compositional nature.

> A higher-order component is a function that takes a component and returns a new component

```javascript
const EnhancedComponent = higherOrderComponent(WrappedComponent);
```

1. Component transforms props into UI, HOC component transforms a component into another component.
2. HOCs are common in third-party React libraries, such as Redux's *connect*
3. HOC doesn't modify the input component, nor does it use inheritance to copy its behavior. Rather, a HOC composes the original component by wrapping it ina container component.

> A HOC is a pure function with zero side effects.