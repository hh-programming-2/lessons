# Introduction to streams

## What is a stream?

- A **stream** is a sequence of values that can be processed one value at a time
- In Java, a stream is not a data structure that stores values. It processes values from a source, such as a list
- Streams are useful when we want to describe a sequence of operations on a collection
- A stream does not usually change the original collection. Instead, the operations produce a new result
- Stream operations can be written in a **declarative** style: we describe **what should happen** rather than every step needed to make it happen. Similar declarative style is in e.g. SQL queries
- For example, suppose that `grades` list contains students' grades. We can select passing grades with a stream:

```java
List<Integer> grades = List.of(3, 0, 5, 4, 0);

// Streams are declarative, describing what should happen with the stream elements in each step
List<Integer> passingGrades = grades.stream()
        // grade > 0 describes the condition for keeping elements on a stream
        .filter(grade -> grade > 0)
        // Collect the stream elements to a list
        .toList();
```

```sql
-- Style of SQL queries is similarly declarative, describing the desired outcome
SELECT grade
FROM CourseGrade
WHERE grade > 0;
```

## Lambdas and streams

```java
filter(grade -> grade > 0)
```

- A **lambda expression** is a short way to represent a function
- Stream operations receive lambdas to describe what to do with each element
- In `grade -> grade > 0`, `grade` is the input and `grade > 0` is the result
- The lambda is applied to each element in the stream
- Common stream operations, such as `filter` and `map`, receive one lambda and apply it to the stream elements
- Lambdas in streams promote **functional programming** style, using functions to implement program logic

## Anatomy of a stream

A stream pipeline usually has three parts:

1. A **source** initializes the stream, for example a list
2. **Intermediate operations** process the stream, for example `filter`. The pipeline can consist of **multiple intermediate operations** applied in the specified order
3. A **terminal operation** finishes the pipeline, for example `toList`

```java
List<Integer> grades = List.of(3, 0, 5, 4, 0);

// grades list is the stream source, turned into a stream using the stream() method
List<Integer> passingGrades = grades.stream()
        // filter is a intermediate operation   
        .filter(grade -> grade > 0)
        // toList is the terminal operation returning the stream elements as a list
        .toList();                            
```

## Filtering stream elements

```java
filter(name -> name.length() < 4)
```

$$
\underbrace{\texttt{name}}_{\text{Element on stream}}
\quad\longrightarrow\quad
\underbrace{\texttt{name.length() < 4}}_{\text{Condition for keeping an element}}
$$

- The `filter` operation **keeps the elements** for which its lambda returns `true`. Elements for which the lambda returns `false` are removed from the stream

```java
List<String> names = List.of("Ada", "James", "Grace", "Ben");

List<String> shortNames = names.stream()
        // Only keep names which are less than 4 characters long on the stream
        .filter(name -> name.length() < 4)
        .toList();
```

```mermaid
flowchart TB
    A["['Ada', 'James', 'Grace', 'Ben']"] --> B["filter(name -> name.length() < 4)"]
    B --> C["['Ada', 'Ben']"]
```

## Mapping (transforming) stream elements

```java
map(points -> points / 20)
```

$$
\underbrace{\texttt{points}}_{\text{Element on stream}}
\quad\longrightarrow\quad
\underbrace{\texttt{points / 20}}_{\text{How to transform an element}}
$$

- The `map` operation **transforms every element** by applying its lambda. Unlike `filter`, `map` does not remove elements: one input element produces one output element

```java
List<Integer> examPoints = List.of(50, 70, 90, 100, 80);

List<Integer> grades = examPoints.stream()
        // Transform exam points to a grade by dividing by 20, e.g. 100 => 5
        .map(points -> points / 20)
        .toList();
```

```mermaid
flowchart TB
    A["[50, 70, 90, 100, 80]"] --> B["map(points -> points / 20)"]
    B --> C["[2, 3, 4, 5, 4]"]
```
