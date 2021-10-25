## Why favor composition over inheritance?
Inheritance should be only used when subclass ‘is a’ super class. Don’t use inheritance just to get code reuse. If there is no ‘is a’ relationship then use composition for code reuse.

> Inheritance: **is a** and Composition: **has a**

1. Overuse of implementation inheritance (uses the “extends” key word) **can break all the subclasses, if the super class is modified.** Do not use inheritance just to get polymorphism. If there is no ‘is a’ relationship and all you want is polymorphism then use interface inheritance with composition, which gives you code reuse. Interface inheritance is accomplished by implementing interfaces.
2. **Composition is more flexible as it is easily achieved at runtime while inheritance provides its features at compile time.** Don’t confuse inheritance with polymorphism. Polymorphism happens at runtime as it states that Java chooses which overridden method to run only at runtime.
3. **Composition offers better testability than Inheritance**. Composition is easier to test because inheritance tends to create very coupled classes that are more fragile (i.e. fragile parent class) and harder to test in isolation. The IoC containers like *Spring, make testing even easier through injecting* the composed objects via constructor or setter injection.