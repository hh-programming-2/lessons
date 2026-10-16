# Introduction to the map data structure

## Data structures

- A data structure is a way of organizing and storing data in a program so that it can be accessed and processed efficiently
- Different data structures provide different ways to store, access, add, and remove data. That is why, the data strucure should be chosen based on the problem we are trying to solve
- An array stores a fixed number of elements of the same type. Its elements are accessed using an index
- An `ArrayList` is a resizable collection that can grow or shrink as elements are added or removed
- Choosing the right data structure can make a program easier to write and more efficient

## Map

- The map data strucutre stores data as key-value pairs, where each key is associated with a value
- Each key must be unique, but multiple keys can have the same value
- Values can be accessed using their corresponding keys instead of indexes
- In Java, `HashMap` is a common implementation of map
- For example, a map could associate country names with their capitals: `"Finland" → "Helsinki"`
- Maps are useful when we need to look up values using unique identifiers, typically with efficient access

$$
\begin{array}{rcl}
\text{"Finland"} & \longrightarrow & \text{"Helsinki"} \\
\text{"Sweden"} & \longrightarrow & \text{"Stockholm"} \\
\text{"France"} & \longrightarrow & \text{"Paris"} \\
\text{"Japan"} & \longrightarrow & \text{"Tokyo"}
\end{array}
$$

## HashMap

$$
\underbrace{\texttt{Map<}\overbrace{\texttt{String}}^{\text{key type}}\texttt{, }
\overbrace{\texttt{String}}^{\text{value type}}\texttt{>}}_{\text{data type}}
\quad
\underbrace{\texttt{capitals}}_{\text{variable name}}
\quad = \quad
\underbrace{\texttt{new HashMap<>();}}_{\text{create HashMap}}
$$

- A `HashMap` is initialized by defining the type of its key and value
- As with `ArrayList`, these types must be non-primitive types, e.g. `Integer`, `String` or `Double`
- The `put()` method adds a key-value pair to a map. If the key already exists, its value is replaced
- The `get()` method retrieves the value associated with a given key. If it is called with a key that does not exist in the map, it returns `null`

```java
Map<String, String> capitals = new HashMap<>();

capitals.put("Finland", "Helsinki");
capitals.put("Sweden", "Stockholm");

String capital = capitals.get("Finland"); // "Helsinki"
```

## Underlying implementation of HashMap

- A `HashMap` uses an array internally to store key-value pairs
- When `put("Finland", "Helsinki")` is called, the `HashMap` calculates a hash code from the key using its `hashCode` method
- The hash code is used to determine the array index where the key-value pair should be stored
- The `hashCode` method should distribute keys as evenly as possible across the storage array to minimize collisions, where multiple key-value pairs map to the same index
- Similar process is used to retrieve key's value when `get("Finland")` is called

$$
\underbrace{\text{"Finland"}}_{\text{key}}
\longrightarrow
\underbrace{\text{hashCode()}}_{\text{hash code}}
\longrightarrow
\underbrace{\text{array index}}_{\text{storage location}}
$$

| Index | Key-value pairs |
|---|---|
| 0 | `"France" → "Paris"` |
| 1 | `null` |
| 2 | `"Finland" → "Helsinki"` |
| 3 | `"Sweden" → "Stockholm"` |
| 4 | `"Japan" → "Tokio"` |
