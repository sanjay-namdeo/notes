## get() vs load()

|load()|get()|
|---|---|
|Only use load() method if you are sure that the object exists.|If you are not sure that the object exist, then use one of get() methods.|
|load() method will throw an exception if the unique id is not found in the database|get() method will return null if the unique id is not found in the database|
|load() just returns a proxy by default and database won't be hit until the proxy is first invoked|get() will hit the database immediately|

### load()
```java
public void savePost(long authorId, String text) {
    Post p = new Post();
    p.setText(text);

    // No SELECT query here. 
    // Existence of Author is ensured by foreign key constraint on Post.
    p.setAuthor(s.load(Author.class, authorId));

    s.save(p);
}
```

### get()
if you are trying to load /get Empoyee object where empid=20. But assume record is not available in DB.
```java
Employee employee1 = session.load(Employee.class,20);  //Step-1
system.out.println(employee1.getEmployeeId();       //Step-2  --o/p=20
system.out.println(employee1.getEmployeeName();       //Step-3 -->O/P:ObjectNotFoundException
```
If you use load in step-1 hibernate wont fire any select query to fetch employee record from DB at this moment.At this pint hibernate gives a dummy object ( Proxy ). This dummy object doesnt contain anything. it is new Employee(20). you can verify this in step-2 it will print 20. but in step-3 we are trying to find employee information. so at this time hibernate fires a sql query to fetch Empoyee objct. If it is not found in DB.throws ObjectNotFoundException.
```java
Employee employee2 = session.get(Employee.class,20);  //Step-4
```
for `session.get()` hibernate fires a sql query to fetch the data from db. so in our case id=20 not exists in DB. so it will return null.
