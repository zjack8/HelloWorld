package Java.AnimalFarm;

public class Pig extends Animal {

	public Pig(String name) {
		super(name);
	}

	// Methods
	public synchronized void eat() {
		setHunger(Math.max(0, getHunger() - 5));
		System.out.println(getName() + " is eating. Hunger: " + getHunger());
	}

	public synchronized void sleep() {
		setEnergy(Math.max(0, getEnergy() - 5));
		System.out.println(getName() + " is sleeping. Energy: " + getEnergy());
	}

}