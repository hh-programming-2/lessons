package lesson8.thread;

import java.util.concurrent.*;

import lesson8.thread.helpers.IDGenerator;

/**
 * This example demonstrates the usage of the Runnable interface and custom
 * class objects as thread tasks.
 */
public class RunnableInterfaceThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Example 1: A singleton class (IDGenerator). Isn't exactly related to threads
        IDGenerator idg = IDGenerator.getIDGenerator();
        int id = idg.nextID();
        System.out.println("ID: " + id);

        // Example 2: Initialization of threads and printing their names
        // Runnable object represents the operation performed in the thread
        Runnable run = () -> System.out.println("Thread started: " + Thread.currentThread().getName());
        System.out.println("Main thread: " + Thread.currentThread().getName());

        Thread t = new Thread(run);
        t.start();

        for (int i = 0; i < 5; i++) {
            new Thread(run).start();
        }

        // Example 3: DemoThread class implementing the Runnable interface
        // We can use a lambda function or a class implementing the Runnable interface
        // while initializing a Thread object
        Thread t3 = new Thread(new DemoThread());
        t3.start();

        // Example 4: Delay in main thread and checking the status of a thread
        while (t3.isAlive()) {
            try {
                System.out.println("Main thread is sleeping zzz...");
                Thread.sleep(100); // Main thread waits 100 milliseconds
            } catch (InterruptedException e) {
            }
        }

        System.out.println("Main thread: Thread 3 has been completed");
    }
}

class DemoThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(200); // Child thread waits
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Class and thread method: " + Thread.currentThread().getName());
    }
}
