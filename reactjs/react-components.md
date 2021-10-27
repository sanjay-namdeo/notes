## React Components
Before hooks, functional components were called stateless components and were behind class components on feature basis. After introduction of Hooks, functional components are equivalent to class components.

### Declaration
1. `Functional components` are simple JavaScript functions and therefore can be declared using **arrow function** OR **function** keyword:
```javascript
function example(props) {
  return <div>Hello World!</div>;
}

const example = (props) => <div>Hello World!</div>;  
```

2. `Class components` on the other hand, are declared using the ES6 class:
```javascript
class Example extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    return <div>Hello World!</div>;
  }
}
```

### Handling Props
Let's render the following component with props and analyse how functional and class components handle props:
```javascript
<StudentInfo name="Sanjay" rollNumber="23" />
```

1. `Functional Component` pretty straight forward. Any prop provided as an argument to a functional component, can be directly used inside HTML elements.
```javascript
function studentInfo(props) {
  return (
    <div>
      <h1>{props.name}</h1>
      <h2>{props.rollNumber}</h2>
    </div>
  );
}
```

2. `Class Components`
```javascript
class StudentInfo extends React.Component {
  constructor(props) {
    super(props);
  }

  render() {
    <div className="main">
      <h1>{this.props.name}</h1>
      <h2>{this.props.rollNumber}</h2> 
    </div>
  }
}
```

### Handling State
1. `Functional Component` use Hooks to handle state with **useState** hook to set state of a variable inside the component.
   _ **useState** hook returns an array of two items, the first item contains the current state and the second item is a function used to update the state.
   _ It takes a parameter which sets the initial state.

```javascript
function example(props) {
  let [count, setCount] = useState(0);

  const increaseCount = () => {
    setCount(++count);
  }

  return <div>Count is: {count}</div>;
} 
```

2. `Class Component`
```javascript
class Example extends React.Component {
  constructor(props) {
    super(props);
    this.state = {count: 0};
  }

  addCount() {
    this.setState({count: this.state.count + 1});
  }

  render() {
    return <div>Count: {this.state.count}</div>;
  }
}
```

> Handling Lifecycle
Functional components use useEffect for managing life cycle events.