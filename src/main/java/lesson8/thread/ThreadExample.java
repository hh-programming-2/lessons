package lesson8.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import lesson8.thread.helpers.IDConsumerCallable;
import lesson8.thread.helpers.IDGenerator;
import lesson8.thread.helpers.IDGeneratorSync;

/**
 * Perusesimerkkejä säikeisiin liittyen
 */
public class ThreadExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Esimerkki 1: Singleton-luokka (IDGenerator), ei liity suoraan Threadeihin.
        IDGenerator idg = IDGenerator.getIDGenerator();
        int id = idg.nextID();
        System.out.println("ID: " + id);

        // Esimerkki 2: Säikeiden luominen ja nimien tulostaminen
        Runnable run = () -> System.out.println("Säie käynnistetty: " + Thread.currentThread().getName());
        System.out.println("Pääsäie: " + Thread.currentThread().getName());
        Thread t = new Thread(run);
        t.start();
        for (int i = 0; i < 5; i++) {
            new Thread(run).start();
        }

        // Esimerkki 3: Runnable-rajapinnan toteuttava luokka
        Thread t3 = new Thread(new DemoThread());
        t3.start();

        // Esimerkki 4: Viive ja säikeiden tilan tarkistus
        while (t3.isAlive()) {
            try {
                System.out.println("Pääsäie nukkuu");
                Thread.sleep(100); //Pääsäie odottaa
            } catch (InterruptedException e) {
            }
        }

        System.out.println("Pääsäie: Säie 3 päättynyt");
    }
}

class DemoThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(200); // Sivusäie odottaa
        } catch (InterruptedException e) {
        }
        System.out.println("Luokka ja säiemetodi: " + Thread.currentThread().getName());
    }
}
