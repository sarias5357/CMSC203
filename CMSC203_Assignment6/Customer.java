/**
 * This class represents a customer
 * @author Steven A.
 */
public class Customer {
	// Store customer info
	private String name;
	private int age;

	/**
	 * This constructor sets the customer's info
	 * @param name Customer name
	 * @param age Customer age
	 */
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	/**
	 * Copy constructor
	 * @param c Customer object
	 */
	public Customer(Customer c) {
		// Set instance variables to the other object's instance
		// variables
		this.name = c.name;
		this.age = c.age;
	}
	
	/**
	 * toString
	 */
	public String toString() {
		return "Customer: " + name + "\t\tAge: " + age;
	}
	
	/**
	 * Set customer's name
	 * @param name Customer name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get customer's name
	 * @return Customer's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set customer's age
	 * @param age Customer age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Get customer's age
	 * @return Customer age
	 */
	public int getAge() {
		return age;
	}
}
