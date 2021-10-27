# Builder Design Pattern

When the complexity of creating object increases,
the `Builder pattern can separate out the instantiation process by using another object (a builder)` to construct the
object.

## How to design

```java
BankAccount newAccount=new BankAccount
        .BankAccountBuilder("Jon","22738022275")
        .withEmail("[email protected]")
        .wantNewsletter(true)
        .build();
```

## When to use

1. When the process involved in creating an object is extremely complex, with lots of mandatory and optional parameters
2. When an *increase in the number of constructor parameters* leads to a large list of constructors
3. When client expects different representations for the object that’s constructed

Example:
BankAccount which contains a builder as a static inner class:

```java
public class BankAccount {
    private String name;
    private String accountNumber;
    private String email;
    private boolean newsletter;

    public static class BankAccountBuilder {
    }
}
```

Note that all the access modifiers on the fields are declared private since we don’t want outer objects to access them
directly. The constructor is also private so that only the Builder assigned to this class can access it. All the
properties set in the constructor are extracted from the builder object which we supply as an argument. We’ve defined
BankAccountBuilder in a static inner class:

```java
public static class BankAccountBuilder {
    private String name;
    private String accountNumber;
    private String email;
    private boolean newsletter;

    public BankAccountBuilder(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public BankAccountBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public BankAccountBuilder wantNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
        return this;
    }

    public BankAccount build() {
        return new BankAccount(this);
    }
}
```

Notice we’ve declared the same set of fields that the outer class contains. Any mandatory fields are required as
arguments to the inner class’s constructor while the remaining optional fields can be specified using the setter
methods.

This implementation also supports the fluent design approach by having the setter methods return the builder object.
Finally, the build method calls the private constructor of the outer class and passes itself as the argument. The
returned BankAccount will be instantiated with the parameters set by the BankAccountBuilder.

Let’s see a quick example of the builder pattern in action:

```java
BankAccount newAccount=new BankAccount
        .BankAccountBuilder("Jon","22738022275")
        .withEmail("[email protected]")
        .wantNewsletter(true)
        .build();
```