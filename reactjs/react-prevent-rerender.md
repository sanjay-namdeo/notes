##How to prevent re-renders in React?
Re-rendering of a component and it’s child components occur when props or state of the component has been changed.
Re-rendering components that are not updated, affects the performance of an application.

> To prevent the re-rendering of child component, we use the *shouldComponentUpdate( )* method and check if props are changed then return true to re-render, other false to prevent re-render.