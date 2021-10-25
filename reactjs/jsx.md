## JSX
JSX is a syntax extension to JavaScript and comes with the full power of JavaScript. JSX produces React "elements". You can embed any JavaScript expression in JSX by wrapping it in curly braces. After compilation, JSX expression become regular JavaScript objects.  Reat doesn't require JSX, it is the recommended way of describing out UI in React app.

#### JSX Code
```javascript
const element = (
    <h1 className="greeting">
        Hello World!
    </h1>
);
```

### Equivalent of the above using React.createElement
```javascript
const element = React.createElement(
   'h1',
   {"className": "greeting"},
   'Hello, world!'
)
```