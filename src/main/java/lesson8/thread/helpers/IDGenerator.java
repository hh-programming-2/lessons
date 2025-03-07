package lesson8.thread.helpers;

public class IDGenerator {
    private static int id = 0;
    // This is a singleton. There can be only one instance of this class in the whole program
    private static final IDGenerator idg = new IDGenerator();

    private IDGenerator() {
    }

    public static IDGenerator getIDGenerator() {
        return idg;
    }

    /**
     * The ++ operation is non-atomic, requiring three operations:
     * 
     * 1. Read the current value of the variable.
     * 2. Increment the value.
     * 3. Write the new value back to the variable.
     */
    public int nextID() {
        return ++id;
    }

    public int getLastId() {
        return id;
    }
}
