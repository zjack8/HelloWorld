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

			Runnable tickTask = animal::tick;

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