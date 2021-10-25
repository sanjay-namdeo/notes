## Difference between an Interface and an Abstract Class

|Difference in|Interface|Abstract Class|
|---|---|---|
|**Type of methods**|Interface can have only abstract. From Java 8, it can have default and static methods also.|Abstract class can have abstract and non-abstract methods.|
|**Final Variables**|Variables declared in a Java interface are by default final.|An abstract class may contain non-final variables.|
|**Type of variables**|Interface has only static and final variables.|Abstract class can have final, non-final, static and non-static variables.|
|**Implementation**|Interface can’t provide the implementation of abstract class.|Abstract class can provide the implementation of interface.|
|**Inheritance vs Abstraction**|A Java interface can be implemented using keyword “implements”|abstract class can be extended using keyword “extends”.|
|**Multiple implementation**|An interface can extend another Java interface only|an abstract class can extend another Java class and implement multiple Java interfaces.|
|**Accessibility of Data Members**|Members of a Java interface are public by default.|A Java abstract class can have class members like private,, protected, etc.|