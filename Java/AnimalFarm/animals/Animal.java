package Java.AnimalFarm.animals;

public class Animal {

	// Attributes
	private String name;
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

	public void setName(String name) {
		this.name = name;
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
		hunger = Math.max(0, hunger - 5);

		System.out.println(name + " is eating. Hunger: " + hunger);
	}

	public synchronized void sleep() {
		energy = Math.max(0, energy - 5);
		System.out.println(name + " is sleeping. Energy: " + energy);
	}

	public synchronized void tick() {
		hunger += 2;
		energy += 3;
		System.out.println(name + "'s Hunger: " + hunger + ", Energy: " + energy);
	}

}