import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Sanjay");
        Employee e2 = new Employee(1, "Sanjay");

        System.out.println(e1 == e2);
        System.out.println(e1.equals(e2));

        Map<Employee, String> empMap = new HashMap<>();
        empMap.put(e1, "1");
        empMap.put(e2, "2");

        System.out.println(empMap.size());
    }
}

class Employee {
    long id;
    String name;

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Employee emp = (Employee) obj;
        if (this.id == emp.id && this.name.equals(emp.name)) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int primeNumber = 31;
        int result = 1;
        result = primeNumber + result * (name != null ? name.hashCode() : 0);
        return result;
    }
}