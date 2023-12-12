package Java.AnimalFarm;

public class Animal {

	// Attributes
	private final String name;
	private int hunger;
	private int energy;

	private static final Object eatingLock = new Object();
	private static final Object sleepingLock = new Object();

	// Constructor
	public Animal(String name) {
		this.name = name;
		this.hunger = 0;
		this.energy = 0;
	}

	// Getters and setters for the attributes
	public String getName() {
		return name;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	// Methods
	public synchronized void eat() {
		synchronized (eatingLock) {
			System.out.println(getName() + " is trying to eat.");

			try {
				// Eat
				Thread.sleep(2000);
				setHunger(Math.max(0, getHunger() - 5));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(getName() + " has finished eating.");
		}
	}

	public synchronized void sleep() {
		synchronized (sleepingLock) {
			System.out.println(getName() + " is trying to sleep.");

			try {
				// Sleep
				Thread.sleep(2000);
				setEnergy(Math.max(0, getEnergy() - 5));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(getName() + " has finished sleeping.");
		}
	}

	public synchronized void tick() {
		setHunger(getHunger() + 2);
		setEnergy(getEnergy() + 3);

		System.out.println(getName() + "'s Hunger: " + getHunger() + ", Energy: " + getEnergy());

		sleep();
		eat();
	}

}