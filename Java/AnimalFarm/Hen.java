package Java.AnimalFarm;

public class Hen extends Animal {

	public Hen(String name) {
		super(name);
	}

	// Methods

	public synchronized void sleep() {
		setEnergy(Math.max(0, getEnergy() - 5));
		System.out.println(getName() + " is sleeping. Energy: " + getEnergy());
	}

}