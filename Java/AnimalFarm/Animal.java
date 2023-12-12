package Java.AnimalFarm;

public class Animal {

	// Attributes
	private final String name;
	private int hunger;
	private int energy;

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
		setHunger(Math.max(0, getHunger() - 5));

		System.out.println(getName() + " is eating. Hunger: " + getHunger());
	}

	public synchronized void sleep() {
		setEnergy(Math.max(0, getEnergy() - 5));
		System.out.println(getName() + " is sleeping. Energy: " + getEnergy());
	}

	public synchronized void tick() {
		setHunger(getHunger() + 2);
		setEnergy(getEnergy() + 3);
		System.out.println(getName() + "'s Hunger: " + getHunger() + ", Energy: " + getEnergy());
	}

}