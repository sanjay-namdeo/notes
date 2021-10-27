## React Performance

### Use the Production Build

By default, React includes many helpful warnings. These warnings are very useful in development. However, they make
React larger and slower, so you should make sure to use the production version when you deploy the app.

**React Developer Tools** for Chrome browser plugin shows a dark green background when site uses production build,
otherwise yellow icon.

To create production build, run the following command:

```bash
npm run build
```

### Avoid Reconciliation

Even though React only updates the changed DOM nodes, re-rendering still takes some time. In many cases it's not a
problem, but if the slowdown is noticeable, you can speed all of this up by overriding the lifecycle function **
shouldComponentUpdate** which is triggered just before a component is re-rendered. By default, it returns /true/, leaving
React to perform the update:

```javascript
shouldComponentUpdate(nextProps, nextState) {
    return true;
}
```

If you know some situations your component doesn't need to update, you can return /false/.

In most cases, instead of writing `shouldComponentUpdate()` by hand, you can inherit `React.PureComponent`. It is
equivalent to implementing `shouldComponentUpdate()` with a shallow comparison of current and previous props and state.

### React Effect Hook - Optimize performance by skipping effects

In some cases, cleaning up or applying the effect after every render might create a performance problem. In class
components, we can solve this by writing an extra comparison with prevPros or preState inside componentDidUpdate:

```javascript
componentDidUpdate(prevProps, prevState) {
    if (document.count != this.state.count) {
        document.title = 'You have clicked ${this.state.count} times';
    }
}
```

This requirement is common enough that it is build into the `useEffect` Hook API. You can tell React to skip applying an
effect if certain values haven't changed between re-renders. To do so, pass an array as an option second argument to
useEffect:

```javascript
useEffect(() => {
    document.title = 'You have clicked ${count} times';
}, [count]);
```

In the example above, we pass [count] as second argument. What does this mean? If the `count` is 5 and then our
component re-renders with `count` still equal to 5, React will compare [5] from the previous render and [5] from the
next render. Because all items in the array are the same (5 === 5), React would skip the effect. That's the
optimization.