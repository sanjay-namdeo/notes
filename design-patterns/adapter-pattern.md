# Adapter Pattern
Acts as a `connector between two incompatible interfaces that otherwise cannot be connected directly`

> An Adapter wraps an existing class with a new interface so that it becomes compatible with the client’s interface.

The main motive behind using this pattern is to convert an existing interface into another interface that the client expects. It's usually implemented once the application is designed.

### How to use
1. The client makes a request to the adapter by calling a method on it using the target interface.
2. The adapter translates that request on the adapter using the adapter interface.
3. Client receive the results of the call and is /unaware of adapter’s presence/.

### When to use
1. When an outside component provides captivating functionality that we'd like to reuse, but it's incompatible with our current application. A suitable Adapter can be developed to make them compatible with each other
2. When our application is not compatible with the interface that our client is expecting
3. When we want to reuse legacy code in our application without making any modification in the original code

### Example