## Immutable Class

Once an object of an immutable class is created, it cannot be modified.

> All Wrapper classes are immutable like String, Integer, Byte, Short, Boolean

Following are the requirements to create an immutable class

1. The **class must be declared as final** so that child classes can't be created
2. **Data member must be private** so that direct access is not possible
3. **Data member must be final** so that we can't change the value of the after it is created
4. **Parameterized constructor should initialize all fields performing a deep copy** so that data members cannot be
   modified with object reference
5. **Deep copy of objects should be performed in getter method** to return a copy rattan than returning the actual
   object reference
6. **No setters** so that there is no option to change the value fields

```java
import java.util.HashMap;
import java.util.Map;

// Final class
final class Student {

    // Private members
    private final String name;
    private final int regNo;
    private final Map<String, String> metadata;

    // Parameterized constructor
    public Student(String name, int regNo,
                   Map<String, String> metadata) {
        // This keyword refers to current instance itself
        this.name = name;
        this.regNo = regNo;

        // Creating Map object with reference to HashMap
        // Declaring object of string type
        Map<String, String> tempMap = new HashMap<>();

        // Iterating using for-each loop for deep copy
        for (Map.Entry<String, String> entry :
                metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }

        this.metadata = tempMap;
    }

    // Only public getter and no setter
    public String getName() {
        return name;
    }

    // Only public getter and no setter
    public int getRegNo() {
        return regNo;
    }

    // Deep copy in getter of objects in getter
    public Map<String, String> getMetadata() {

        // Creating Map with HashMap reference
        Map<String, String> tempMap = new HashMap<>();

        for (Map.Entry<String, String> entry :
                this.metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}
```