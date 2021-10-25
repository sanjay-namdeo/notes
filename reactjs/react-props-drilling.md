## React props drilling
Sometimes there is a need to pass data from a component that is higher in the hierarchy to a component that is deeply nested.

To pass data between such components, we pass props from a source component, and keep passing the props to the next component in hierarchy till we reach the deeply nested component, it is called **props drilling**.

Disadvantages of using prop drilling is that the components should otherwise be not ware of data have access to the data.


### How to Avoid Prop Drilling Using Component Composition
Component Composition is when you compose different Components, usually simple, together to create more complex functionality. If you have ever written a React app, I bet that you have been composing components. Take for example:
```javascript
function Button(props){
return <button onClick={props.handleClick}>{props.text}</button>
}

const SignInButton = props => {
return <Button text="SignIn" onClickHandler={props.handleClick} />
}
```