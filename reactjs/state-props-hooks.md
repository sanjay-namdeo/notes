### State

is a data structure that starts with a default value when a Component mounts. It may be mutated across time, mostly as a
result of user events. It is **mutable**.

States are not available in functional component, but we can use **React Hooks** to add state to a functional component.

### Props

(short for properties) are a Component's configuration. Props are how components talk to each other. They are received
from above component and **immutable** as far as the Component receiving them is concerned.

### Hooks

1. Let us "hook" **state and lifecycle features into a functional components**. Hooks don't work inside classes.
   Introduced in **16.8 version**
2. The **Effect Hook**, /useEffect/, adds the ability to perform side effects from a functional component. It serves the
   same purpose as /componentDidMount/, /componentDidUpdate/ and /componentWillUnmount/ in React classes/ but unified
   into a single API.

```javascript
import React, {useState, useEffect} from 'react';

function Example() {
    const [count, setCount] = useState(0);

    useEffect(() => {
        document.title = `You clicked ${count} times`;
    });

    return (
        <div>
            <p>You have clicked {count} times</p>
            <button onClick={() => setCount(count + 1)}>click Me</button>
        </div>
    );
}
```

### Example

#### State for Class based component

```javascript
class Car extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            color: 'Black'
        }
    }

    changeColor() {
        this.setState({color: 'Red'});
    }

    render() {
        return <h1>{this.state.color}</h1>;
    }
}
```

#### Hooks for functional components

```javascript
function Car(props) {
    let [color, setColor] = useState('Red');
}
```