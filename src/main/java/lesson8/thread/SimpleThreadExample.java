package lesson8.thread;

/**
 * This example demonstrate typical usage of threads.
 * We execute a time consuming task in the background without blocking the main thread.
 */
public class SimpleThreadExample {
    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());

        // Initialize a Runnable oject, which represents the background task
        Runnable backgroundTask = () -> {
            System.out.println("Background task started: " + Thread.currentThread().getName());
            // Simulate some time consuming operations, e.g. heavy computation or fetching data from multiple locations
            // This computation takes around 10 seconds to complete
            executeTimeConsumingTask();
            System.out.println("Background task executed: " + Thread.currentThread().getName());
        };
        
        // Initialize a new thread for the background task
        Thread backgroundThread = new Thread(backgroundTask);

        Long startTime = System.currentTimeMillis();

        // Start the background thread
        backgroundThread.start();

        // The main thread does some computation
        // This computation takes around 5 seconds to complete
        for (int i = 0; i < 5; i++) {
            System.out.println("The main thread progress: " + i * 20 + "%");
            try {
                // Simulate a time consuming operation in the main thread
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("The main thread is done working");

        // Let's wait for the background thread to finnish before finnishing the whole program
        try {
            backgroundThread.join();
            System.out.println("The background thread is done working");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The program is done in " + (System.currentTimeMillis() - startTime) / 1000 + " seconds");
    }

    private static void executeTimeConsumingTask() {
    	 for (int i = 0; i < 20; i++) {
             System.out.println("The background thread progress: " + i * 5 + "%");
             try {
                // Simulate a time consuming operation in the background thread
                Thread.sleep(500);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }
}
