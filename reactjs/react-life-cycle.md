## React Lifecycle
###Mounting
1. **constructor** called before anything else. Set initial state and bind methods.
2. **getDerivedStateFromProps** Called just before component is rendered.
/Parameters: props and state/ /Returns: new state/
3. **render** It is the only required method in the class component. It returns JSX.
4. **componentDidMount** Called just after component is rendered. Mostly used for network requests.

###Updating
1. **getDerivedStateFromProps** Called again when a component is being re-rendered.
2. **shouldComponentUpdate** Called just before a component is re-rendered. Returns true by default. If returned false, then component will not be updated.
3. **render** To re-render the component. Returns JSX.
4. **getSnapshotBeforeUpdate** Called just before the newly rendered HTML gets committed to the DOM. It stores the previous state of the component so that React has an idea of what parts of the DOM needs to be updated.
5. **componentDidUpdate** Called after the component is re-rendered.

###Unmount
1. **componentWillUnmount** Called before component gets destroyed. For clean up statements.