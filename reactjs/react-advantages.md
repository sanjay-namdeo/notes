## Advantages of React

### Virtual DOM improves efficiency
It is a programming concept where an ideal, or *"virtual"*, **representation of a UI is kept in memory and synced with the "real" DOM by a library such as ReactDOM**. This process is called /reconciliation/, where it updates the DOM with the result of diff.

When state changes in a component, it firstly runs a **diffing** algorithm, which identifies what has changed in the virtual DOM. The second step is **reconciliation**  and gets to know about which virtual DOM objects were updated. After knowing which objects were updated, react renders only those objects inside the real DOM instead of rendering the complete real DOM. This way, with the use of virtual DOM, react solves the problem of inefficient updating.

React uses**two virtual DOMs**to render the user interface. One of them is used to **store the current state of the objects** and the other to **store the previous state of the objects**. Whenever the virtual DOM gets updated, react **compares the two virtual DOMs**

### Gentle Learning Curve
It has a gentle learning curve compared to frameworks like Angular. Anyone with little knowledge of javascript can start building web applications using React.

### Reusable Components
React uses component-based architecture for developing applications. Components are independent and reusable bits of code. These **components can be shared across various applications having similar functionality**. The re-use of components increases the pace of development.

### Huge ecosystem of libraries
React provides freedom to choose the tools, libraries, and architecture for developing an application based on your requirements. For example
1. **Redux** library can be used for state management
2. **Enzyme** for testing

### SEO Friendly (Search Engine Optimization)
React allows developers to develop engaging user interfaces they can be easily navigated in various search engines. It allows server-side rendering, which boosts the SEO of an app.