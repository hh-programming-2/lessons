# Week 4

## Week 3 recap

- `PriceFormatter` class: potential bugs and corresponding tests
- `dayOfYear` method:
  - Potential issues of leap year and number of days in each month
  - Bugs potentially lie in the min and max values, e.g. first and last date of year
  - The last date of year varies in leap years (365 on "normal" years and 366 on leap years)
  - The number of days in February varies in leap years (28 days on "normal" years and 29 in leap years)
- 

## Week 4

### Inheritance basics

- With interfaces we define common methods that the classes implementing the interface have.
- Example: shapes Rectangle, Circle, Square. If we consider these shapes as classes, they each have an area and different way of calculating it
- So each of the shapes could implement the same interface `Shape`, which defines an `calculateArea` method
- Each class that implementes the `Shape` interface define how the `calculateArea` method is implemented

### Interface examples

- Example `ShapeInterface`: simple usage of interfaces
  - `Shape` interface's methods don't define the implementation itself, just the method names, parameters and return types
  - Implementation of the methods is done by the classes which implement the interface
- Example `SimpleListExample` vs. `GenericsListExample`: usage of `Comparable` interface
  - The `Comparable` interface provides the methods for equality checks (`equals`), comparasion for sorting `compareTo` and hash code definition to use object as map key (`hashCode`)
  - Let's consider example where we want to implement a `countOccurences` which returns a map containing how many times a certain item occurs in a list (key item, value number of occurences)
  - Simple example `SimpleListExample` only supports list of integers
  - Example `CenericsListExample` supports any type of list containing objects of class which implements the `Comparable` interface
  - We implement methods `equals`, `hashCode` and `compareTo` in a `Student` class in order to:
    - Be able to check if if two students are equal (based on student number)
    - Be able to use a `Student` object a key in map
    - Be able to sort students based on the student number
  - In this example `countOccurences` is a "generic method" and accepts any type for `T`. Here `T` is sort of an type parameter
  - `List<Integer>` is a nother example of generic class (list can store any kind of types)
- Example `ObjectCalculator` vs `ImperativeCalculator`: using interfaces to simplify code
- Example `AirplaneConfig`: usage of dependency inject with interfaces

### Inheritance basics

- Interfaces define which kind of methods the implementing classes have (method names, parameters and return types), but they don't define the implementation
- With inheritance we can inherit attributes and methods from another classes
- Sub classes that inherit a class receives super class attributes and method's along with their implementations
- Sub classes can then override the super class method to provide a different implementation for a specific method

### Inheritance examples

- Example: `VehicleInheritance`
