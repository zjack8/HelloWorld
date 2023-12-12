package Java.AnimalFarm.animals;

public class Animal {
	// Common attributes
	private String name;
	private int age;
	private int weight;

	// Constructor
	public Animal(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	// Getters and setters for the attributes
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void eat(int food) {

		this.weight += food;

		System.out.println(name + " is eating.");
	}

	public void sleep() {
		System.out.println(name + " is sleeping.");
	}

	public void makeSound() {
		System.out.println(name + " is making a sound.");
	}

}