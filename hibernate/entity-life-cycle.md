## Hibernate Entity Life Cycle
Managed Entity is a representation of a database table row
This is managed by the current session and **every change made on it will be tracked and propagated to the database automatically**

### Transient State
A transient state is the initial state of an entity. At this stage an entity is an object that has no representation in the persistent store

### Persistent State
As soon as entity object is associated to a session, it becomes Persistent object. Any of these methods can bring to this stage:
1. `session.save`
2. `session.update`
3. `session.lock`
4. `session.saveOrUpdate`
5. `session.persist`

### Detached State
A detached entity is just an ordinary entity POJO whose identity value corresponds to a database row. The difference from a managed entity is that it's not tracked any more by any persistence context.

An entity is in a deleted (removed) state if Session.delete(entity) has been called, and the Session has marked the entity for deletion. The DELETE command itself might be issued at the end of the unit of work.

#### Reference [baeldung](https://www.baeldung.com/hibernate-entity-lifecycle)
