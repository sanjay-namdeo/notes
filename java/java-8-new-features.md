# New Feature in Java 8

## Lambda expressions
Lambda expressions are nameless functions given as constant values, and written exactly in the place where it’s needed, typically as a parameter to some other function.

The most important feature of Lambda Expressions is that they `execute in the context of their appearance`. So, a similar lambda expression can be executed differently in some other context (i.e. logic will be the same but results will be different based on different parameters passed to function).

- Enable to treat functionality as a method argument, or code as data.
- A function that can be created without belonging to any class.
- A lambda expression can be passed around as if it was an object and executed on demand.

## Interface Default and Static Methods
Before Java 8, interfaces could have only public abstract methods. It was not possible to add new functionality to the existing interface without forcing all implementing classes to create an implementation of the new methods, nor it was possible to create interface methods with an implementation.

Starting with Java 8, interfaces can have static and default methods that, despite being declared in an interface, have a defined behavior.

#### Static Method
Consider the following method of the interface (let's call this interface Vehicle):
```java
static String producer() {
    return "N&F Vehicles";
}
```
The static producer() method is available only through and inside of an interface. It can't be overridden by an implementing class.

To call it outside the interface the standard approach for static method call should be used:
```java
String producer = Vehicle.producer();
```
#### Default Method
Default methods are declared using the new default keyword. These are accessible through the instance of the implementing class and can be overridden.

Let's add a default method to our Vehicle interface, which will also make a call to the static method of this interface:
```java
default String getOverview() {
    return "ATV made by " + producer();
}
```
Assume that this interface is implemented by the class VehicleImpl. For executing the default method an instance of this class should be created:
```java
Vehicle vehicle = new VehicleImpl();
String overview = vehicle.getOverview();
```

## Functional Interfaces
@FunctionalInterface annotation has been added in Java 8.

> Any interface with a SAM(Single Abstract Method) is a functional interface, and its implementation may be treated as lambda expressions. 

It's recommended that all functional interfaces have an informative @FunctionalInterface annotation. This clearly communicates the purpose of the interface, and also allows a compiler to generate an error if the annotated interface does not satisfy the conditions.

Note that Java 8's default methods are not abstract and do not count; a functional interface may still have multiple default methods. We can observe this by looking at the Function's documentation.

## Stream API
One of the major new features in Java 8 is the introduction of the stream functionality – `java.util.stream` – which contains classes for processing sequences of elements.

The central API class is the Stream<T>. The following section will demonstrate how streams can be created using the existing data-provider sources.

#### Stream Creation
Streams can be created from different element sources e.g. collection or array with the help of stream() and of() methods:
```java
String[] arr = new String[]{"a", "b", "c"};
Stream<String> stream = Arrays.stream(arr);
stream = Stream.of("a", "b", "c");
```
A stream() default method is added to the Collection interface and allows creating a Stream<T> using any collection as an element source:
```java
Stream<String> stream = list.stream();
```
  
#### Multi-threading With Streams
Stream API also simplifies multithreading by providing the parallelStream() method that runs operations over stream's elements in parallel mode.

The code below allows to run method doWork() in parallel for every element of the stream:
```java
list.parallelStream().forEach(element -> doWork(element));
```

### Stream Operations
#### Iterating
```java
boolean isExist = list.stream().anyMatch(element -> element.contains("a"));
```
#### Filtering
The filter() method allows us to pick a stream of elements that satisfy a predicate.

For example, consider the following list:
```java
ArrayList<String> list = new ArrayList<>();
list.add("One");
list.add("OneAndOnly");
list.add("Derek");
list.add("Change");
list.add("factory");
list.add("justBefore");
list.add("Italy");
list.add("Italy");
list.add("Thursday");
list.add("");
list.add("");
```
The following code creates a Stream<String> of the List<String>, finds all elements of this stream which contain char “d”, and creates a new stream containing only the filtered elements:
```java
Stream<String> stream = list.stream().filter(element -> element.contains("d"));
```
#### Mapping
To convert elements of a Stream by applying a special function to them and to collect these new elements into a Stream, we can use the map() method:
```java
List<String> uris = new ArrayList<>();
uris.add("C:\\My.txt");
Stream<Path> stream = uris.stream().map(uri -> Paths.get(uri));
```
So, the code above converts Stream<String> to the Stream<Path> by applying a specific lambda expression to every element of the initial Stream.

If you have a stream where every element contains its own sequence of elements and you want to create a stream of these inner elements, you should use the flatMap() method:
```java
List<Detail> details = new ArrayList<>();
details.add(new Detail());
Stream<String> stream = details.stream().flatMap(detail -> detail.getParts().stream());
```
In this example, we have a list of elements of type Detail. The Detail class contains a field PARTS, which is a List<String>. With the help of the flatMap() method, every element from field PARTS will be extracted and added to the new resulting stream. After that, the initial Stream<Detail> will be lost.
  
#### Matching
Stream API gives a handy set of instruments to validate elements of a sequence according to some predicate. To do this, one of the following methods can be used: anyMatch(), allMatch(), noneMatch(). Their names are self-explanatory. Those are terminal operations that return a boolean:
```java
boolean isValid = list.stream().anyMatch(element -> element.contains("h")); // true
boolean isValidOne = list.stream().allMatch(element -> element.contains("h")); // false
boolean isValidTwo = list.stream().noneMatch(element -> element.contains("h")); // false
```
For empty streams, the allMatch() method with any given predicate will return true:
```java
Stream.empty().allMatch(Objects::nonNull); // true
```
This is a sensible default, as we can't find any element that doesn't satisfy the predicate.

Similarly, the anyMatch() method always returns false for empty streams:
```java
Stream.empty().anyMatch(Objects::nonNull); // false
```
Again, this is reasonable, as we can't find an element satisfying this condition.
#### Reduction
Stream API allows reducing a sequence of elements to some value according to a specified function with the help of the reduce() method of the type Stream. This method takes two parameters: first – start value, second – an accumulator function.

Imagine that you have a List<Integer> and you want to have a sum of all these elements and some initial Integer (in this example 23). So, you can run the following code and result will be 26 (23 + 1 + 1 + 1).
```java
List<Integer> integers = Arrays.asList(1, 1, 1);
Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);
```
#### Collecting
The reduction can also be provided by the collect() method of type Stream. This operation is very handy in case of converting a stream to a Collection or a Map and representing a stream in the form of a single string. There is a utility class Collectors which provide a solution for almost all typical collecting operations. For some, not trivial tasks, a custom Collector can be created.
```java
List<String> resultList 
  = list.stream().map(element -> element.toUpperCase()).collect(Collectors.toList());
```
This code uses the terminal collect() operation to reduce a Stream<String> to the List<String>.
