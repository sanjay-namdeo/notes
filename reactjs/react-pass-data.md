## React pass data between components
### Parent to Child Component
Parents can pass data to a child component using props.

**In functional component**
```javascript
function message(props) {
  return <div>{props.message}</div>;
}
```
**In Class component**
```javascript
return <div>{this.props.message}</div>;
```

### Child to Parent Component
It's a bit tricky, follow the below steps:
1. Create a callback in the parent component which takes in the data needed as a parameter.
2. Pass the callback as a prop to the child component.
3. Send data from the child component using the callback.

**Create callback and pass as props**
```javascript
function ParentComponent(props) {
  let [counter, setCounter] = useState(0);

  let callback = valueFromChild => setCounter(valueFromChild);

  return <ChildComponent callBackFunc={callback} counterValue={counter} />
}
```

**Pass data from child to parent component**
```javascript
function ChildComponent(props) {
  let childCounterValue = props.counterValuel

  return (
    <div>
      <button onClick={() => props.callbackFun(++childCounterValue)}>
         Increment Counter
      </button>
    </div>
  );
}
```