package lesson8.thread;

import java.util.Random;
import java.util.concurrent.ExecutionException;

import lesson8.thread.helpers.IDGenerator;

/**
 * Example of unsafe threading where multiple threads may potentially modify the
 * same memory area, leading to unexpected results.
 * 
 * The correct way is to use code block locking with the synchronized keyword,
 * which is done in the commented parts of this example using the
 * IDGeneratorSync class.
 */
public class IDConsumerNonSyncExample implements Runnable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         * If we set the numberOfGeneratedIds as e.g. 50 instead of 5, the final ID
         * won't be correct every time. Meaning, we don't get e.g. 100 as final ID every
         * time we run the program.
         */
        int numberOfGeneratedIds = 5;
        boolean useDelay = false;

        IDConsumerNonSyncExample idc1 = new IDConsumerNonSyncExample(numberOfGeneratedIds, useDelay);
        IDConsumerNonSyncExample idc2 = new IDConsumerNonSyncExample(numberOfGeneratedIds, useDelay);

        Thread t1 = new Thread(idc1);
        Thread t2 = new Thread(idc2);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }

        IDGenerator idg = IDGenerator.getIDGenerator();
        // IDGeneratorSync idg = IDGeneratorSync.getIDGenerator();

        // The next id should be 2 * numberOfGeneratedIds every time we run the program
        int id = idg.getLastId();
        System.out.println("Final ID is: " + id);
        System.out.println("Final ID should be: " + 2 * numberOfGeneratedIds);
    }

    private int numberOfGeneratedIds; // How many times generate a new ID
    private boolean useDelay; // Should we simulate delay in the execution?

    public IDConsumerNonSyncExample(int numberOfGeneratedIds, boolean useDelay) {
        this.numberOfGeneratedIds = numberOfGeneratedIds;
        this.useDelay = useDelay;
    }

    @Override
    public void run() {
        Random rnd = new Random();
        IDGenerator idg = IDGenerator.getIDGenerator();
        /**
         * The correct implementation should only allow generating the ID one thread at
         * a time. This can be done using the syncronized keyword in the method, which
         * is used in the nextID method of the IDGeneratorSync class
         */

        // IDGeneratorSync idg = IDGeneratorSync.getIDGenerator();
        int id = 0;
        for (int i = 0; i < numberOfGeneratedIds; i++) {
            id = idg.nextID();
            if (useDelay) {
                try {
                    Thread.sleep(rnd.nextInt(50));
                } catch (InterruptedException e) {
                    // Just do nothing...
                }
            }
        }
    }
}
