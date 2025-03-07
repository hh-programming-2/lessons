package lesson8.thread.helpers;

public class IDGeneratorSync {
    private static int id = 0;
    private static final IDGeneratorSync idg = new IDGeneratorSync();

    private IDGeneratorSync() { }

    public static IDGeneratorSync getIDGenerator() {
        return idg;
    }

    // The synchorinized keyword provides thread safety by ensuring that only one thread at a time can execute the method
    public synchronized int nextID() {
        return ++id;
    }

    public int getLastId() {
        return id;
    }
}
