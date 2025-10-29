# Week 2

## Week 1 recap

- "Warm up" model solution
- `StringBasics ` class:
  - `center` method
  - `centerMultiLine` method
- `CollectionsBasics` class:
  - `maximum` method (`for` loop solution)
  - `sum` method
  - `multiply` method
  - `getLengths` method
  - `indicesOf` method
- `ObjectExercise` class
  - `getNames` method
  - `getOldest` method
  - `generateNamesString` method

## Week 2

- During this week we will learn more about data structures, and we will cover a new data structre, Map
- Data structure is a specific way to store data to support specific operations in optimized ways
- What data structures do we know so far? (array, array list, linked list)
  - Array list data structure is to store many items in a specific order
  - Operations: get item in index (array, array list), add item, remove item in index
- Map is a data structure which stores data as key-value pairs
- A key is usually a string or integer value, but technically it could be anything, even an object
- A value related to the key can be anything, e.g. string, integer, or object
- Mapping string name to integer age "Kalle" => 32, "Pekka" => 21, "Elina" => 34
- HashMap is perhaps the most common type of map in Java
- Under the hood, HashMap stores the data into an array
- The hash function defines an index to an underlying array where the value is stored  (draw: key => hash function => value)
- A common use-case for map is to e.g. map some unique identifier to the corresponding object (e.g. student number to a student object)
- The purpose of map data strucutre is to provide optimized way to add and retrieve a value based on a specific key
- Week 2 examples in Visual Studio Code
- Week 2 examples
- "LotsOfData" example: demonstrates the difference between using the HashMap and ArrayList data structures
- Some operations (e.g. checking if the data structure contains a value) is much more faster with HashMap => the purpose of HashMap is to support a fast way to:
  1. Add value based on key
  2. Get value based on key
  3. Check if key exists in the hash map
- The fast "lookups" makes hash map perfect data structure if we want to e.g. quickly retrieve some object based on an unique identifier (e.g. student based on student number)
- Exercises: one exercise set in GitHub Classroom, "Map exercises"
