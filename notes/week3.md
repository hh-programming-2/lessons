# Week 3

## Week 2 recap

https://github.com/hh-programming-2/map-kaltsoon-1

- `MapBasics` class:
  - `getPopulation` method: `Map.of()` vs. `map.put()`
  - `largestValue`: first get map values, then problem is reduced to "maximum value of a list"
  - `sumOfValues`: iterating the values
  - `combineMaps`: other solution by iterating the keys and putting each key and value to the map
- `MapExperts` class:
  - `countLetters` method
  - `reverseMap` method
  - `createMapFromList` method
- `PostalCodesMain` class:
  - Our data contains a map of postal code => city
  - First, we need to identify is user's input is a postal code or not. We can use a regular expression for this (\d = digit {5} = 5 times)
  - _Usage of helper methods will simplify the solution_
  - If the input is a postal code, we simply check for the city from the map
  - Otherwise, we need to find keys (postal codes) that map to provided value (city)
  - Go through key value pairs of the map and if the value matches the city, add the key (postal code) to a result list
  
## Week 3

- Testing is a process where we verify that our program works in the desired way based on different inputs
- We can perform this testing manually, typing the inputs for the program and seeing that it provides the desired output
- When our programgs become larger and more complicated, performing testing manually becomes too time consuming
- This is why whe implement programs that perform the testing for parts of our program, e.g. methods.
- While we writing programs that test our methods, we usually expect them to return certain value based on the parameters we provide
- Example: `parseYesOrNo` method from warm up
  - `parseYesOrNo("yes") == true`
  - `parseYesOrNo("YeS") == true`
  - `parseYesOrNo("no") == false`
  - `parseYesOrNo("anything but yes") == false`
- There are different levels of testing, but during this course we will focus on unit testing
- In unit testing we commonly test individual methods or classes in isolation to ensure they work as expected
- "Units" are these smallest pieces (e.g. methods) that the whole program consists of
- So far our exercise solutions have been tested with automated unit tests
- During this we week will learn how to implement similar unit tests ourselves using the jUnit tool
- `Calculator` examples:
  - `Calculator` class
  - To test a class we create a test class and name it based on the class under testing, e.g. `CalculatorTest`
  - To test a class, we first create an instance of it in a `setUp` method. This method is executed before each test method because of `@BeforeEach` annotation before the method definition
  - We can also perform actions after execution of each test method in a `tearDown` method which has the `@AfterEach` annotation
  - The test methods annotated with the `@Test` annotation test different scenarios of e.g. a method
  - Different scenarios are commonly calling the method with different parameters and expecting certain return value
  - The name of a test method starts with "test" followed by something that describes the scenario, e.g. `testAdditionWithNegative`
  - Go through each test method
  - Tests are supposed to spot programming mistakes => `division` method has a mistake
  - Check test output for `substract` method => fix the problem
  - Implement `factorial` method with tests (`testFactorialWhenZeroThenReturnsOne`, `testFactorialWhenOneThenReturnsOne`, `testFactorialWhenLargerThanOneThenReturnsCorrect`, `testFactorialWhenNegativeThenReturnsOne`)
