# Week 4

## Week 3 recap

https://github.com/hh-programming-2/junit-Kaltsoon-1

- `PriceFormatter` class: potential bugs and corresponding tests
- `dayOfYear` method:
  - Potential issues of leap year and number of days in each month
  - Bugs potentially lie in the min and max values, e.g. first and last date of year
  - The last date of year varies in leap years (365 on "normal" years and 366 on leap years)
  - The number of days in February varies in leap years (28 days on "normal" years and 29 in leap years)
- Example implementation of `dayOfYear` using the `YearMonth` method

## Week 4

### Interface basics

- With interfaces we define common methods that the classes implementing the interface have.
- Example: shapes Rectangle, Circle, Square. If we consider these shapes as classes, they each have an area and different way of calculating it
- So each of the shapes could implement the same interface `Shape`, which defines an `calculateArea` method
- Each class that implementes the `Shape` interface define how the `calculateArea` method is implemented

### Interface examples

- Example `ShapeInterface`: simple usage of interfaces
  - `Shape` interface's methods don't define the implementation itself, just the method names, parameters and return types
  - Implementation of the methods is done by the classes which implement the interface
  - Interfaces provide reusability to the code: we can implement methods that operate on objects implementing an interface (e.g. `totalPerimeter(Shape a, Shape b)`) so it can use objects from many classes
- Java has many ready-made interfaces, such as `List`, which is implement by e.g. `ArrayList` and `LinkedList`
- The `Comparable` interface is one of Java's ready-made interfaces. It provides comparison using the `compareTo` method. This is useful for e.g. sorting, which is based on comparing the orde of items on a list
- If we want to be able to sort objects of our own class in a meaningful way, the class needs to implement the `Comparable` interface  
- `SortingStudents` example

### Inheritance basics

- Interfaces define which kind of methods the implementing classes have (method names, parameters and return types), but they don't define the implementation
- With inheritance we can inherit attributes and methods from another classes
- Sub classes that inherit a class receives super class attributes and method's along with their implementations
- Sub classes can then override the super class method to provide a different implementation for a specific method
- The benefit of inheritance is avoiding duplicate code and promoting reusability

### Inheritance examples

- Example: `VehicleInheritance`

### Generics

- Generics example, `SimpleListExample` vs. `GenericsListExample`:  
  - Let's consider example where we want to implement a `countOccurences` which returns a map containing how many times a certain item occurs in a list (key item, value number of occurences)
  - Simple example `SimpleListExample` only supports list of integers
  - Example `CenericsListExample` supports any type of list
  - We implement methods `equals`, `hashCode` in a `Student` class in order to:
    - Be able to check if if two students are equal (based on student number)
    - Be able to use a `Student` object a key in map
  - In this example `countOccurences` is a "generic method" and accepts any type for `T`. Here `T` is sort of an type parameter
- The benefit of generic methods is reusability

### Dependency injection

- In programming we have design patterns which are reusable solutions to a common problem
- Dependency injection is one design pattern which purpose to promote loose coupling between components and to make code more maintainable, testable, and flexible
- Loose coupling means that components interact through clear, minimal interfaces and don’t know too much about each other
- Example `AirplaneConfig`: usage of dependency injection with interfaces

### Clean code using interfaces

- Using objects and interfaces to refactor code
- Example `ObjectCalculator` vs `ImperativeCalculator`: using interfaces to simplify code
