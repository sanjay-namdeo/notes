## Java Shallow Copy vs Deep Copy
### Reference Copy
Creates a copy of a reference variable pointing to an object.

When a reference is copied, then both existing and copied variable starts pointing to the same object.
> An object copy creates a copy of object itself

### Object Copy
When an object is copied, a new copy is created and new variable points to the new object.
> Shallow Copy copies the main object, but doesn't copy the inner objects. The inner objects are shared between the original object and its copy.

### Example
A Person object has properties first name, last name and child object Address which contains Street and City. In case of Shallow Copy only firstname and lastname will be copied.

A change in Address of one person would be reflected in other person also.

> Deep copy is a fully independent copy of an object. Entire object structure is copied.

A change in Address object of one Person wouldn't be reflected in the other object.