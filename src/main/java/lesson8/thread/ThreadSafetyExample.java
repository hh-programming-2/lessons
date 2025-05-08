package lesson8.thread;

import java.util.Random;
import java.util.concurrent.ExecutionException;

import lesson8.thread.helpers.IDGenerator;
import lesson8.thread.helpers.IDGeneratorSync;

/**
 * Example of unsafe threading where multiple threads may potentially modify the
 * same memory area, leading to unexpected results. In this case multiple
 * threads generate an ID by using an increasing integer value. In a problematic
 * scenario the same ID is generated multiple times.
 * 
 * The correct way is to use code block locking with the synchronized keyword,
 * which is done in the commented parts of this example using the
 * IDGeneratorSync class.
 */
public class ThreadSafetyExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         * Count of generated IDs in both of the two threads is determined by the
         * numberOfGeneratedIds variables. We don't want the same ID to be generated
         * multiple times!
         */
        int numberOfGeneratedIds = 50;

        BackgroundTask taskA = new BackgroundTask(numberOfGeneratedIds);
        BackgroundTask taskB = new BackgroundTask(numberOfGeneratedIds);

        Thread t1 = new Thread(taskA);
        Thread t2 = new Thread(taskB);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        IDGenerator idg = IDGenerator.getIDGenerator();
        //IDGeneratorSync idg = IDGeneratorSync.getIDGenerator();

        // The next id should be 2 * numberOfGeneratedIds every time we run the program
        int id = idg.getLastId();
        System.out.println("Final ID is: " + id);
        System.out.println("Final ID should be: " + 2 * numberOfGeneratedIds);
    }
}

class BackgroundTask implements Runnable {
    private int numberOfGeneratedIds;

    public BackgroundTask(int numberOfGeneratedIds) {
        this.numberOfGeneratedIds = numberOfGeneratedIds;
    }

    @Override
    public void run() {
        IDGenerator idg = IDGenerator.getIDGenerator();
        
        /**
         * The correct implementation should only allow generating the ID one thread at
         * a time. This can be done using the syncronized keyword in the method, which
         * is used in the nextID method of the IDGeneratorSync class
         */

        //IDGeneratorSync idg = IDGeneratorSync.getIDGenerator();
        
        for (int i = 0; i < numberOfGeneratedIds; i++) {
            // Generate a new ID
            int id = idg.nextID();
            System.out.println(id);
            sleepRandomTime();
        }
    }

    private void sleepRandomTime() {
        Random randomGenerator = new Random();

        try {
            Thread.sleep(randomGenerator.nextInt(50));
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
