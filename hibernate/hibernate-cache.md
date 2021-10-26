## Hibernate Cache
1. **First Level Cache**: Hibernate first level cache is associated with the Session object. Hibernate first level cache is enabled by default and there is no way to disable it. However hibernate provides methods through which we can delete selected objects from the cache or clear the cache completely.
> Any object cached in a session will not be visible to other sessions and when the session is closed, all the cached objects will also be lost.
3. **Second Level Cache**: Hibernate Second Level cache is disabled by default but we can enable it through configuration. Currently EHCache and Infinispan provides implementation for Hibernate Second level cache and we can use them. We will look into this in the next tutorial for hibernate caching.
4. **Query Cache**: Hibernate can also cache result set of a query. Hibernate Query Cache doesn’t cache the state of the actual entities in the cache; it caches only identifier values and results of value type. So it should always be used in conjunction with the second-level cache.

### Hibernate First Level Cache
1. Hibernate First Level cache is enabled by default, there are no configurations needed for this.
2. Hibernate first level cache is *session specific*, that’s why when we are getting the same data in same session there is no query fired whereas in other session query is fired to load the data.
> Once session is closed, first level cache is terminated as well.
3. Hibernate first level cache can have old values.
4. We can use session `evict()` method to remove a single object from the hibernate first level cache.
5. We can use session `clear()` method to clear the cache i.e delete all the objects from the cache.
6. We can use session `contains()` method to check if an object is present in the hibernate cache or not, if the object is found in cache, it returns true or else it returns false.
7. Since hibernate cache all the objects into session first level cache, while running bulk queries or batch updates it’s necessary to clear the cache at certain intervals to avoid memory issues.
> One session's cache is not visible to any other session. that's where we can use second level cache.

```java
package com.journaldev.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.journaldev.hibernate.model.Employee;
import com.journaldev.hibernate.util.HibernateUtil;

public class HibernateCacheExample {

    public static void main(String[] args) throws InterruptedException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        //Get employee with id=1
        Employee emp = (Employee) session.load(Employee.class, new Long(1));
        printData(emp, 1);

        //waiting for sometime to change the data in backend
        Thread.sleep(10000);

        //Fetch same data again, check logs that no query fired
        Employee emp1 = (Employee) session.load(Employee.class, new Long(1));
        printData(emp1, 2);

        //Create new session
        Session newSession = sessionFactory.openSession();
        //Get employee with id=1, notice the logs for query
        Employee emp2 = (Employee) newSession.load(Employee.class, new Long(1));
        printData(emp2, 3);

        //START: evict example to remove specific object from hibernate first level cache
        //Get employee with id=2, first time hence query in logs
        Employee emp3 = (Employee) session.load(Employee.class, new Long(2));
        printData(emp3, 4);

        //evict the employee object with id=1
        session.evict(emp);
        System.out.println("Session Contains Employee with id=1?" + session.contains(emp));

        //since object is removed from first level cache, you will see query in logs
        Employee emp4 = (Employee) session.load(Employee.class, new Long(1));
        printData(emp4, 5);

        //this object is still present, so you won't see query in logs
        Employee emp5 = (Employee) session.load(Employee.class, new Long(2));
        printData(emp5, 6);
        //END: evict example

        //START: clear example to remove everything from first level cache
        session.clear();
        Employee emp6 = (Employee) session.load(Employee.class, new Long(1));
        printData(emp6, 7);
        Employee emp7 = (Employee) session.load(Employee.class, new Long(2));
        printData(emp7, 8);

        System.out.println("Session Contains Employee with id=2?" + session.contains(emp7));

        tx.commit();
        sessionFactory.close();
    }

    private static void printData(Employee emp, int count) {
        System.out.println(count + ":: Name=" + emp.getName() + ", Zipcode=" + emp.getAddress().getZipcode());
    }

}
```

### Second Level Cache
Second-level cache is SessionFactory-scoped, meaning it is shared by all sessions created with the same session factory. 

When an entity instance is looked up by its id (either by application logic or by Hibernate internally, e.g. when it loads associations to that entity from other entities), and if second-level caching is enabled for that entity, the following happens:
1. If an instance is already present in the first-level cache, it is returned from there
2. If an instance is not found in the first-level cache, and the corresponding instance state is cached in the second-level cache, then the data is fetched from there and an instance is assembled and returned.
Otherwise, the necessary data are loaded from the database and an instance is assembled and returned

> Once the instance is stored in first-level cache, it is returned from there in all subsequent calls within the same session until the session is closed or the instance is manually evicted from the persistence context. Also, the loaded instance state is stored in L2 cache if it was not there already.
