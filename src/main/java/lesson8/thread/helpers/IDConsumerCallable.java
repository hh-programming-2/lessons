package lesson8.thread.helpers;

import java.util.concurrent.Callable;

public class IDConsumerCallable implements Callable<Integer> {
    private int counter = 10;

    public IDConsumerCallable(int counter) {
        this.counter = counter;
    }

    @Override
    public Integer call() throws Exception {
    	IDGeneratorSync idg = IDGeneratorSync.getIDGenerator();
        System.out.println("Callable starting: "+Thread.currentThread().getName());
        int id = 0;

        for (int i = 0; i < counter; i++) {
            // Increase id thread safely. Because nextID method is synchronized no two threads can call it at the same time
            id = idg.nextID();
            //System.out.println("\t" + this.toString() + " " + id);
        }

        System.out.println("Thread: " + this.toString() + " id result: " + id);
        return id;
    }
}
