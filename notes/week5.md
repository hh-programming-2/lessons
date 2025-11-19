# Week 5

https://github.com/hh-programming-2/interfaces-and-inheritance-Kaltsoon

## Week 4 recap

- `Product` class
  - `String.formatted` method
- `Vehicle` class
  - `constructor` and `super` call
  - `toString` and call super class (`Product`) `toString` method
- `WebShop` class
  - `isVehicle` method vs. `isProduct` method
- `Country` class
  - `compareTo` method
- `MarkdownExport` interface and implementing `Pizza` class
- `Main` class (dependency injection)

## Week 5

- Streams allow us to process collections of data (like lists, sets, etc.)
- Streams rely heavily on _functional programming_, using functions instead of objects in object-oriented programming
- There are purely functional languages, such as Haskell, which don't have objects at all, but most languages are "hybrid", having both OP ja functional aspects
- Streams are a good example on declarative programming: instead of providing the computer exact step-by-step instructions on _how_ to achieve the solution, we instead describe _what_ we want to achieve => for example, SQL is very declarative `SELECT firstname FROM students WHERE studentnumber = '123'`
- Example: `ImpretiveDeclarative.java`
- On top being declarative, streams rely heavily on functional programming, which focuses on use of functions
- Java supports definitions of simple functions with lambda expressions
- Example: `FunctionalCalculator.java`
- Example: `OptionalExamples.java`
- Optional objects are commonly used in methods that either return some object or null
- Optional communicates the possibility of a null (or "empty") value and provides methods for handling this case
- Streams are used to process sequence of objects
- Stream starts with an _input_ which is any kind of object sequence, e.g. a list
- We can define specific _operations_ that each object in the stream goes through
- Most common operations are map (replace each object in the stream) and filter (choose which objects are kept in the stream using a condition)
- Finally, _terminal operation_ creates a stream output. These operations are also called "collectors", they collect the stream into e.g. a list or a single average value or maximum value of the stream
- Steams provide many useful methods for processing collections of data, for example filtering and mapping (transforming each value of the collection)
- Example: `BasicFunctionalExamples.java`
- Records and `Person.java` example
- Example: `StreamExamples.java`
