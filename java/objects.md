## Different ways to create a Java object -
 
1. Using **new keyword** - Constructor call involved
```java
Employee emp1 = new Employee();
```
2. Using **class's newInstance** method - Constructor call involved
```java
Employee emp2 = Employee.class.newInstance();
```

3. Using **Constructor's class newInstance** method - Constructor call involved
```java
Constructor<Employee> employeeConstructor = Employee.class.getConstructor();
Employee emp3 = employeeConstructor.newInstance();
```
4. Using **clone()** method - Constructor call NOT involved
```java
Employee emp4 = (Employee) emp3.clone();
```

5. Using **Deserialization** - Constructor call NOT involved
```java
ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.obj"));
outputStream.writeObject(emp1);

ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data.obj"));
Employee emp5 = (Employee) objectInputStream.readObject();
```
