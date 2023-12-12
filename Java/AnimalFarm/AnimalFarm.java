package Java.AnimalFarm;

import java.util.ArrayList;
import java.util.concurrent.*;

public class AnimalFarm {

	public static void main(String[] args) {
		
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

		ArrayList<Animal> animals = new ArrayList<>();

		Animal dog = new Dog("Dog");
		Animal pig = new Pig("Pig");

		animals.add(dog);
		animals.add(pig);

		for (Animal animal: animals) {

			Runnable eatTask = animal::eat;

			Runnable sleepTask = animal::sleep;

			Runnable tickTask = animal::tick;

			// Schedule tasks to run every second
			scheduler.scheduleAtFixedRate(eatTask, 0, 1, TimeUnit.SECONDS);
			scheduler.scheduleAtFixedRate(sleepTask, 0, 1, TimeUnit.SECONDS);
			scheduler.scheduleAtFixedRate(tickTask, 0, 1, TimeUnit.SECONDS);

		}

		// Run the simulation for 3 minutes
		try {
			scheduler.awaitTermination(3 * 60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		scheduler.shutdown();
	}
}