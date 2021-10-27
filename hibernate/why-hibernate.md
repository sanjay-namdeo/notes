## Why Hibernate

Hibernate is Object Relation Mapping Tool, it implements JPA. Can be used JPA annotations OR with XML configuration

### Why Hibernate and why not JDBC

1. **Eliminates all boilerplate** code that comes with JDBC
2. It supports **HQL** which is Object-Oriented
3. Provides **transaction management**
4. Support **caching for better performance**
5. Throws HibernateException or JDBCException unchecked exception, so no need to declare exceptions in throws

### Interfaces in Hibernate

1. **SessionFactory** `org.hibernate.SessionFactory` It is used to get session object for database operation. One per
   database.
2. **Session** `org.hibernate.Session` Its factory for transaction, it's used for physical connecting to the database. It
   provides /CRUD/ operation.
3. **Transaction** `org.hibernate.Transaction` Specifies single/atomic unit of work

> One database can have only one SessionFactory. One SessionFactory may have many sessions. One session may have many transactions.

```java
public class Scratch {
    public void dbOps() {
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(null);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
```
