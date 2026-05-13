# Week 7

## Week 6 recap

https://github.com/hh-programming-2/sql-databases-Kaltsoon-1

- `AlbumDAO` class `getAlbumsByArtist` method: filtering in database vs filtering in the application (e.g. using streams):
  - Bandwith, memory usage, filtering performance

## Week 7

- During week 2 we learned about the Map data structure and we had an example comparing the execution time of contains check in Map and ArrayList
  - `lesson2/LotsOfData.java`
- The example demonstrated that the contains check is much faster for Map
- So, the performance related to solving the same problem might vary a lot between different implementations
- Performance can be measured by calculating the execution time of e.g. a method
- Execution time usually goes up when the "input" changes, for example the amount of items on the list or the map
- In different solutions the execution time can go up must faster than with others
- We usually want to come up with a solution where the execution time doesn't grow rapidly when the input size grows
  - Constant time
  - Linear time
  - Exponential time
- Comparison: https://chatgpt.com/share/69fb0e53-2858-8327-adad-0e54139a0eff
- We use the "big O" notation do describe upper bound of an algorithm's running time in terms of the input size (n)
- It tells you how the performance of an algorithm scales as the size of the input grows.
- `constains` vs. `containsKey`: https://gist.github.com/Kaltsoon/b7346bcf4556e39d3c697059a7a3e09e
  - For example List's `contains` method time complexity is O(n) (linear). In worst case we have to go through each item on the list
  - HashMap's `containsKey` method time complexity is O(1) (constant). We just need to perform two constant time operations, whic are hash code generation and getting item in array index
- Examples: AlgorithmTimeComplexity.java
  - What does each algorithm do? What is the time complexity of the algorithms?
- Example: MaximumDifferenceAlgorithm.java
  - Provide two implementations for the problem and compare the execution time.

## Bubble sort

- So far we have sorted lists, but has anyone actually implemented a method that performs sorting on a list or array?
- Next, well have a look at one example of a sorting algorithm
- Algorithm is a step-by-step procedure or used to solve a problem
- Algorithms aren't programming language specific solutions, but much more higher level
- Usually algorithms are described as high level "pseudo code", e.g. https://en.wikipedia.org/wiki/Bubble_sort#Implementation
- Bubble sort is one famous such algorithm for sorting an array
- Other sorting algorithms are e.g. merge sort and quick sort. These two are more performant than Bubble sort, but a bit more complicated
  - https://en.wikipedia.org/wiki/Sorting_algorithm
  - https://chatgpt.com/share/6a041c4f-3574-832f-b211-8d8e1c13d71c
- So there's usually more than one way to solve a problem, some solutions might be much more performant than others
- It is also quite common that some solutions have "trade-offs", e.g. sacrificing storage space to gain execution speed
- Example: `BubbleSort.java`
  - Visualization: https://www.hackerearth.com/practice/algorithms/sorting/bubble-sort/visualize/

## Wordplay exercise

https://github.com/ohjelmointi2/wordplay-exercise

- Let's have a look the Wordplay exercise which demontstrates ways to measure code perfomance and some an exercise to practice implementing a performant solution to a problem
- In the first part we have a performance comparison between ArrayList's and LinkedList's operations
- In the second part we have a problem where we need to implement a performant solution. The key in the second part is to use a data structure, which provides perfomant operations for what we need to solve the problem
