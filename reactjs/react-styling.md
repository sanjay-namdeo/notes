## React Style
### CSS Modules
1. CSS Modules let you use the same CSS class name in different files without worrying about naming clashes.
2. CSS Modules allow scoping of CSS by automatically creating a unique classname of the format
   [filename]\_[classname]\_\_[hash]

#### Example
Button.module.css
```css
.error {
  background-color: red
}
```

another-stylesheet.css
```css
.error {
  color: red
}
```

Button.js
```javascript
import styles from './Button.module.css'; /Import CSS module/
import './another-stylesheet.css';

class Button extends Component {
  render() {
    return <button className={styles.error}>Error Button</button>;
  }
}
```

**Result**
This button has red background but not red text
```html
<button class="Button_error_ax7yz">Error Button</Button>
```

There will be no clashes from other .error class names.

### Inline Styling
We can directly style an element using inline style attributes.
```javascript
class RandomComponent extends React.Component {
  render() {
    return <div style={{ color: "Yellow" }}></div>
  }
}
```

### Using JavaScript Object
Set desired properties to JavaScript Object then the value of the object can set as inline style attribute.
```javascript
class RandomComponent extends React.Component {
  paragraphStyles = {
    color: 'Red'
  }
  render() {
   return <div style={this.paragraphStyles}>Hello World!</div>;
  }
}
```

### CSS StyleSheet
We can create a separate CSS file and write all the styles for the component inside that file. Then import this file inside the component:

```javascript
import '/RandomComponent.css';

class RandomComponent extends React.Component {
  render() {
    return <div className="heading">Hello World!</div>;
  }
}
```