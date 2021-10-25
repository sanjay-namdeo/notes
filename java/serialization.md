## Serialization
> Process of converting an object into a stream of bytes that can be transferred over network or stored in files

1. All subtypes of a serializable class are themselves serializable.
2. Serialization interface has no methods or fields; and serves only to identify the semantics of being serializable.
3. **static** and **transient** fields are not serialized.
4. To allow subtypes of non-serializable classes to be serialized, /the subtype may assume responsibility for saving and restoring the state of the supertype's public, protected, and (if accessible) package fields/. The subtype my assume this responsibility only if the class it extends has an accessible no-arg constructor to initialize the class's state. It is an error to declare a class Serializable if this is not the case. The error will be detected at the runtime.
4. While traversing a graph, an object may be encountered that does not support the Serializable interface, in this case the *NotSerializableException* will be thrown.
5. It is strongly recommended that all serializable classes explicitly declare serialVersionUID values. If not provided, then runtime will calculate a default serialVersionUID. This computation is highly sensitive to class details that may vary depending on compiler implementations, and can thus result in unexpected *InvalidClassExceptions* during deserialization. Therefore, to guarantee a consistent serialVersionUID value across different java compiler implementations, it is strongly advised to explicit serialVersionUID declaration using /private/ modifier.
6. Classes can implement writeObject, readObject and readObjectNoData methods to customize serialization and deserialization process.
7. **writeObject** method is responsible for writing the state of the object for its particular class so that the corresponding readObject method can restore it. The default mechanism for saving the Object's fields can be invoked by call out.defaultWriteObject. State is saved by writing the individual fields to the ObjectOutputStream using writeObject method.
8. **readObject** method is responsible for reading from the stream and restoring the class fields. It may call in.defaultReadObject to invoke the default mechanism for restoring the object's non-static and non-transient fields.

## Externalization
Externalization server the purpose of **custom Serialization, where we can decide what to store in stream**. It extends Serialization.
1. Unlike Serializable interface which will serialize the variables in object with just by implementing interface, here we have to **explicitly mention what fields or variable you want to serialize**.
> Serializable is a market interface, whereas Externalizable interface contains two methods writeExternal() and readExternal()

```java
class Car implements Externalizable {
   int age;
   String name;
   public Car() {}

   Car(String n, int a) {
      this.name = n;
      this.age = a;
   }

   @Override
   public void writeExternal(ObjectOutput ou) {
      out.writeObject(name);
      out.writeObject(age);
   }

   @Override
   public void readExternal(ObjectInput in) {
      name = (String)in.readObject();
      age = in.readInt();
   } 
}
```