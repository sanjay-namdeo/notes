# Template Method Design Pattern

The template method pattern is a technique
that `defines the steps required for some action, implementing the boilerplate steps, and leaving the customizable steps as abstract`

Subclasses can then implement this abstract class and provide a concrete implementation for the missing steps.

## When to use

For example when executing a query on a database, the same series of steps must be completed:

1. Establish a connection
2. Execute query
3. Perform cleanup
4. Close the connection

### Example

We can create a template in the case of our database query:

```java
public abstract class DatabaseQuery {

    public void execute() {
        Connection connection = createConnection();
        executeQuery(connection);
        closeConnection(connection);
    }

    protected Connection createConnection() {
        // Connect to database...
    }

    protected void closeConnection(Connection connection) {
        // Close connection...
    }

    protected abstract void executeQuery(Connection connection);
}
```