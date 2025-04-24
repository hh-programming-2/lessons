# Week 6

## Week 5 recap

- `IntegerStreams`:
  - `numbersBetween`: creating a stream
  - Different ways of collecting an `IntegerStream`
- `OptionalValues`:
  - Collectors that return an Optional object with possibly empty value
- `MappingStreams`:
  - Using the `map` method to replace each item in a stream based on a lambda function
- `FilteringStreams`
  - Using the `filter` method to omit certain values from a stream based on lambda function
- `PersonStreams`:
  - `Person` record
  - `person.name()` vs. `person.getName()`: record's generated methods
- `PizzaStreams`:
  - `getPizzasWithAnyOfToppings`: using helper method in the stream
  - `sortPizzasByPrice`: using the `sorted` method to sort a stream 

## Week 6

- So far in the studies we have learned how to perform individual database queries to SQL databases
- This week we learn how to implement programs which communicate with the database and have business logic around the data we fetch or create through the program
- Almost every application, e.g. web or mobile application communicate with some database through the application's code
- While we develop applications which communicate with a database, we commonly hide the details related to implementation of the communication into a class
- These classes that hide implementation details of e.g. database communication or other logic are called "abstractions"
- `Lesson6.java` example:
  - If we have a look at the code, the `PersonDAO` class provides operations for communicating with the database
  - We don't know what e.g. `addPerson` method does exactly, because the `PersonDAO` class does a good job hiding the details, we aren't interested in
  - E.g. with the `addPerson` method we are only interested that we can add a `Person` object to database somehow, we don't need to know the details => "ignorance is bliss"
  - `PersonDAO` is an example of data access object design pattern (DAO). Other example of design pattern was the "dependency injection" pattern we covered with interfaces and inheritance
  - The goal of data access object pattern is to separate the low-level data accessing logic from high-level business logic (example `Lesson6.java`)
- `PersonDAO.java` overall stuff:
  - In this example, we have code which communicates with an SQLite database
  - SQLite is a simple SQL database, which stores all data on single file on the computer where the program is executed on
  - It is a good choice of a databases for a single user applications, but not for multi user applications
  - In order to connect an SQLite database from a Java application, we need a driver program for it
  - The driver program implements the operations we need to communicate with the database, e.g. send database queries and receive the data
  - Java doesn't provide a builtin driver for SQLite, but instead we need to install it as an external dependency
  - Using external dependencies in Java applications is very common
  - These dependencies are installed and managed by Gradle
  - All we need to know is define our dependencies in the `build.gradle` file. Then, we can access the dependencies in the code
  - Usually we have a separate DAO class for each table in the database. The DAO class is responsible for operations related to that specific table
- `PersonDAO.java` code examples:
  - Before starting to send database queries to a database we need to establish a database connection. Database servers can be located in e.g. different country and the connection is like the "pipe" between our computer and the database server
  - Making sure that database tables are created
  - Examples of database queries
