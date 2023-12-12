package Java.AnimalFarm;

import java.util.concurrent.*;
import Java.AnimalFarm.animals.Animal;

public class AnimalFarm {

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        Animal lion = new Animal("Lion");
        Animal elephant = new Animal("Elephant");

        Runnable eatTask = () -> {
            lion.eat();
            elephant.eat();
        };

        Runnable sleepTask = () -> {
            lion.sleep();
            elephant.sleep();
        };

        Runnable tickTask = () -> {
            lion.tick();
            elephant.tick();
        };

        // Schedule tasks to run every second
        scheduler.scheduleAtFixedRate(eatTask, 0, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(sleepTask, 0, 1, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(tickTask, 0, 1, TimeUnit.SECONDS);

        // Run the simulation for 3 minutes
        try {
            scheduler.awaitTermination(3 * 60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scheduler.shutdown();
    }
}