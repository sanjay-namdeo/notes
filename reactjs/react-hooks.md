In React class components, the *render* method itself shouldn't cause side effects. It would be too early - we typically want to perform our effects after React has updated the DOM. This is why in React classes, we put side effects into the following methods

***componentDidMount*** is called just after component is rendered

***componentDidUpdate*** is called just after component is re-rendered

Date fetching, setting up a subscription, and manually changing the DOM in React components are all example of *side effects*

### Example using Classes
```javascript
class Example extends React.Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
  }

  componentDidMount() {
    document.title = `You have clicked ${this.state.count} times`;
  }

  componentDidUpdate() {
    document.title = `You have clicked ${this.state.count} times`;
  }

  render() {
    return (
      <div>
        <p>You have clicked {this.state.count} times</p>;
        <button onClick={() => this.setState({count: this.state.count + 1})}>
           Click Me
        </button>
      </div>
    );
  }
}
```

Note how *we have to duplicate the code between these two lifecycle methods in class*

This is because in May cases we want to perform the same side effect regardless of whether the component just mounted, or if it has been updated. Conceptually, we want it to happen after every render - but React class components don't have a method like this. 

### Example using Hooks
Let's consider the following
```javascript
function Example() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    document.title = `You have clicked ${count} times`;
  });

  return (
    <div>
      <p>You have clicked {count} times </p>
      <button onClick={() => setCount(count+1)}>
         Click Me
      </button>
    </div>
  );
}
```

*By using useEffect Hook*, you tell React that you component needs to do something after render. React will remember the function passed(we'll refer to it as out "effect"), and call it later after performing the DOM updates.

>You can think of useEffect Hook as a combination of componentDidMount, componentDidUpdate and componentWillMount.

*Does useEffect run after every render?* Yes! By default, it runs both after the first render and after every update. Instead of thinking in terms of "mounting" and "updating", you might find it easier to think that effects happen "*after render*".
