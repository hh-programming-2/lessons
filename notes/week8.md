# Week 8

## Week 7 recap

- `Sorting` class:
  - `sortPostsByPublishedDate` method:
    - In this method, we needed to implement a sort algorithm ourselves to do the sorting
    - Possible algorithms:
      - Bubble sort: O(n^2) worst case
      - Quick sort: O(n^2) worst case (e.g. already sorted array and pivot as first elemenet), but O(n * log(n)) average
      - Merge sort: O(n * log(n)) worst case
    - Model solution uses the Quick sort algorithm:
      - Quick sort is an example of recursive approach where the method is calling itself to solve the problem
      - In quick sort we choose a pivot item from the list and split the original list into two new lists: left list contains items less than pivot and right list contains items greater than pivot
      - We perform this recursively for left and right list until we reach list size of one
      - Then we combine the sorted left and right lists

## Week 8

### Recursion

- Recursion is a programming technique where method or function is calling itself to solve a problem
- Quick sort is an example of recursive approach
- Other classic example is the Fibonacci sequence, where the next value in the sequence is calculated based on the sum of two previous values in the sequence: https://en.wikipedia.org/wiki/Fibonacci_sequence
- Recursive methods can be dangerous, because they might cause infinite call loops, similar as while loops
- That is why it is important for a recursive method to define a "base case" in which the method returns a value, similarly as a while condition or a break condition inside the while loop
- `calculateFactorial` method:
  - Factorial is a sequence where the next value is calculated by multiplying the previous value with the next sequence number: `factorial(5) = 1 * 2 * 3 * 4 * 5`
  - Factorial of 0 is 1, which we can use a base case for the recursion
  - https://recursion.vercel.app/
  
    ```py
    def fn(n):
      if (n == 0):
        return 1
      else: 
        return n * fn(n - 1)
    ```

- `printBackwards` method:
  - In this recursive method we print the given string backwards
  - The recursion method prints the last character and calls itself with a string without that last character
  - The base case, where the string length 1, we break the recursion and print the only character in the string
- It is always possible possible to implement the same method without recursive solution. In some cases the recursive solution might be more readable, but e.g. `printBackwards` solution would probably be more readable with a simple for loop going from the end of the string to the beginning

### Concurrency and threads

- The operations, e.g. arithmetic operations are performed on the computer's central processing unit (CPU)
- CPU's commonly have multiple cores, e.g. my laptop's CPU has 10 cores
- Each program's operation is performed in one of the core's of the CPU
- By default the whole program is executed on a single core, meaning that the operations executed sequential, one after another
- For example if we need to call two methods A and B, where execution time of A is 2 seconds and execution time of B is 3 seconds, the total execution time is 5 seconds
- It is however also possible to execute operations in different cores in parrallel, so that methods A and B are executed concurrently. In this case the total execution time would only be 3 seconds
- This kind of parallel computation in different cores is implemented using threads
- `BackgroundTaskExample` class:
  - A Java program is always executed in main thread
  - The main thread can spawn multiple child threads, which can perform any kind of computation
  - We can define the child thread's operation using a lambda function like in `backgroundTask`
  - A `Thread` object can be created using the lambda function and started by calling its `start` method
  - Starting the child thread doesn't block the main thread
  - The main thread continuous immediately after calling the `start` method, no matter how time consuming the child thread's computation is
  - To block the main thread and wait for the thread to finnish, we need to call the `join` method
- `RunnableInterfaceThread` example:
  - Instead of a lambda expression, the thread task can be object of a class which inherits the `Runnable` interface

### Thread safety

- When multiple threads operate on the same data, there can be consistency issues
- Classic example is multiple threads performing "increase" operations on shared variable
- Increase operation consist of two operations: reading the value and write a new value
- That is, increase operation is not an atomic operation, meaning that it is not performed a single indivisible operation
- Other thread can e.g. increase the value between our thread's read and writing operations
- In database management system these kind of concurency problems are solved with transaction mechanism
- In thread programming it is implemented using thread safe operations
- In the next thread examples we have two different implementations for a simple ID generator
- Both generate the ID the same way: reading the current value and increase it by one
- They are also both "singletons", meaning that the whole program will share the same instance of the class
- Non thread safe `IDGenerator` vs. thread safe `IDGeneratorSync`
- `ThreadSafetyExample` example:
  - In this example we have to threads generating a large amount of IDs. The desired behavior is that the same ID is never generated twice, because duplicate IDs cause a problem in the system
  - With `IDGenerator` implementation it is possible that other thread writes a new value between read and write operations of the another thread. In this case the same ID will be generated twice
  - So the `nextID` method of the `IDGenerator`  class _is not thread safe_  where as the same method with the `synchronized` keyword in the `IDGeneratorSync` is
