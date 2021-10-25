## Virtual DOM

It is a programming concept where an ideal, or /"virtual"/, *representation of a UI is kept in memory and synced with the "real" DOM by a library such as ReactDOM*. This process is called /reconciliation/

When state changes in a component, it firstly runs a *diffing* algorithm, which identifies what has changed in the virtual DOM. The second step is *reconciliation*, where it updates the DOM with the result of diff.

React uses *two virtual DOMs* to render the user interface. One of them is used to *store the current state of the objects* and the other to *store the previous state of the objects*. Whenever the virtual DOM gets updated, react *compares the two virtual DOMs* and gets to know about which virtual DOM objects were updated. After knowing which objects were updated, react renders only those objects inside the real DOM instead of rendering the complete real DOM. This way, with the use of virtual DOM, react solves the problem of inefficient updating.

## DOM

HTML DOM is always tree-structured. The *DOM trees are huge nowadays* because of large apps. Since we are more and more pushed towards dynamic web apps, we need to modify the DOM tree instantly and a lot. And this is real performance and development pain.

```javascript
document.getElementById('#root')
document.querySelector('#the-one')
document.querySelector('p')
```
