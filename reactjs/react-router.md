## React Router

1. Install **react-router-dom**

```javascript
npm
install
react - router - dom
```

2. **Import BrowserRouter, Route, and Switch** from /react-router-dom/ package

```javascript
import React, {Component} from 'react';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
```

3. **Render App component between BrowserRouter**

```javascript
ReactDOM.render(
    <BrowserRouter>
        <App/>
    </BrowserRouter>,
    document.getElementById('root')
);
```

4. Inside App component add **/Switch/** element. This ensures that only one component is rendered at a time. Then add
   Routes. Error component is loaded when the user types a wrong URL.

```javascript
function App() {
    return (
        <div>
            <Switch>
                <Route path="/" component={Home} exact/>
                <Route path="/about" component={About}/>
                <Route path="/shop" component={Shop}/>
                <Route component={Error}/>
            </Switch>
        </div>
    );
}
```

5. Add Link for each Component in the app and use /to="URL"/ to link them.

```javascript
function NavBar() {
    return (
        <div>
            <Link to="/">Home</Link>
            <Link to="/about">About Us</Link>
            <Link to="/shop">Show Now</Link>
        </div>
    );
}
```

Now the site has clickable links that can navigate you around your single-page app!