## ACID Properties
### Atomicity
All operations of a transactions take place at once or none of the operations take place i.e. transaction do-not occur partially. Each transaction is considered as one unit and either runs to completion or is not executed at all.

### Consistency
A transaction once completed, must take database from one consistent state into another consistent state. It refers to correctness of data.

For example:
before T occurs 500 + 200 = 700
after T occurs    400 + 300 = 700

### Isolation
Multiple transactions can occur concurrently without leading to inconsistency of database state. Changes occurring in one transaction should not be visible to other transactions until the transaction has been committed.

### Durability
Once a transaction has been committed, it will remain committed even in case of a system failure. It means that completed transactions are recorded in non-volatile memory.
