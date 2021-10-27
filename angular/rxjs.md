## Rxjs
Following is the list of some most important features of RxJS that are used to handle the concept of RxJS or reactive programming:

### Observer
The Observer is an object with next(), error(), and complete() methods, which are called when we have to interact with the observable, i.e., the source interacts for an example button click, Http request, etc.

### Observable
In RxJS, an observable function is used to create an observer and attaches it to the source where values are expected. For example, clicks, mouse events from a DOM element or a Http request, etc.

### Subscription
The role of subscription comes in the scene when the observable is created. To execute the observable, we need to subscribe to it. It can also be used to cancel the execution.

### Operators
Operators are a very important part of RxJS. An operator is a pure function that takes observable input and emits the result in the output form. Input and output both are observable.

### Subject
A subject is observable that can multicast, i.e., talk to many observers. Suppose we have a button with an event listener. The function attached to the event using `addlistener` is called every time the user clicks on the button. Similar functionality goes for the subject too.

### Schedulers
A scheduler controls the execution of when the subscription has to start and be notified.
