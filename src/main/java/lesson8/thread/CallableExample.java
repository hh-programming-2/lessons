package lesson8.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lesson8.thread.helpers.IDConsumerCallable;
import lesson8.thread.helpers.IDGenerator;
import lesson8.thread.helpers.IDGeneratorSync;

/**
 * Example of ExecutorService and Callable, where a thread returns a value.
 */
public class CallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int threadCount = 5;
        
        List<Callable<Integer>> threads = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            threads.add(new IDConsumerCallable(10));
        }
        
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        // The invokeAll method returns a list of "futures", which are promises of a return value at some point in the future
        List<Future<Integer>> futures = executor.invokeAll(threads);
        		
        int resultId = 0;

        for (Future<Integer> future : futures) {
            // Future returns only once the thread execution is completed and blocks the main thread until then
            resultId = future.get();
            System.out.println("ID after the thread execution: " + resultId);
        }

        // All threads have completed, close the executor
        executor.shutdown();
        
        // Check the end result of the singleton IDGenerator, which have been altered by all the threads
        IDGeneratorSync idGenerator = IDGeneratorSync.getIDGenerator();
        int finalId = idGenerator.getLastId();
        System.out.println("Final ID: " + finalId);
    }
}
