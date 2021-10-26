## Hoisting
Hoisting is JavaScript's default behavior of **moving all declarations to the top of the current scope** (to the top of the current script or the current function).

In JavaScript, a variable can be declared after it has been used. In other words; a variable can be used before it has been declared. 


#### Example 1
```javascript
x = 5; // Assign 5 to x
elem = document.getElementById("demo"); // Find an element
elem.innerHTML = x; // Display x in the element
var x; // Declare x
```

#### Example 2
```javascript
var x; // Declare x
x = 5; // Assign 5 to x
elem = document.getElementById("demo"); // Find an element
elem.innerHTML = x; // Display x in the element
```

*Example 1* gives the same result as *Example 2*:
