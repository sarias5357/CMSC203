import java.util.ArrayList;
import java.util.Random;

/**
 * Represents an order
 * @author Steven A.
 *
 */
public class Order implements OrderInterface, Comparable {
	// Information of order
	private int orderNumber;
	private int orderTime;
	private DAY orderDay;
	private Customer customer;
	private ArrayList<Beverage> list;
	private int totalItems;
	
	/**
	 * Set order info
	 * @param num Order number
	 * @param time Time of order
	 * @param day Day of order
	 * @param name Name of customer
	 * @param age Age of customer
	 */
	public Order(int time, DAY day, String name, int age) {
		orderNumber = getRand();
		orderTime = time;
		orderDay = day;
		customer = new Customer(name, age);
		
		totalItems = 0;
		list = new ArrayList<Beverage>();
	}
	
	public Order(int time, DAY day, Customer c) {
		orderNumber = getRand();
		orderTime = time;
		orderDay = day;
		customer = new Customer(c.getName(), c.getAge());
		
		totalItems = 0;
		list = new ArrayList<Beverage>();
	}
	
	/**
	 * Get a random number within 10000 and 90000
	 * @return Random number within 10000 and 90000
	 */
	public int getRand() {
		Random rand = new Random();
		
		return rand.nextInt(90000 - 10000) + 10000;
	}
	
	/**
	 * isWeekend
	 */
	public boolean isWeekend() {
		// If the day is a saturday or sunday, return true. else false
		if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY)
			return true;
		return false;
	}
	
	/**
	 * getBeverage
	 */
	public Beverage getBeverage(int itemNo) {
		// Return the Beverage at the index
		return list.get(itemNo);
	}
	
	/**
	 * add coffee
	 */
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		list.add(new Coffee(bevName, size, extraShot, extraSyrup));
		totalItems++;
	}
	
	/**
	 * add alcohol
	 */
	public void addNewBeverage(String bevName, SIZE size) {
		list.add(new Alcohol(bevName, size, isWeekend()));
		totalItems++;
	}
	
	/**
	 * add smoothie
	 */
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
		list.add(new Smoothie(bevName, size, numOfFruits, addProtein));
		totalItems++;
	}
	
	/**
	 * toString
	 */
	public String toString() {
		String str = "Order #" + orderNumber + "\t" + orderTime + ""
				+ "\t" + orderDay + "\nCustomer: " + customer.getName() +
				"\tAge: " + customer.getAge();
		for (Beverage j : list) {
			str += j.toString();
		}
		
		str += calcOrderTotal();
		return str;
	}
	
	/**
	 * calculate total
	 */
	public double calcOrderTotal() {
		double total = 0;
		
		// Iterate through beverages and add prices together
		for (Beverage j : list) {
			total += j.calcPrice();
		}
		
		// Return total
		return total;
	}
	
	/**
	 * Find number of beverage types
	 */
	public int findNumOfBeveType(TYPE type) {
		int count = 0;
		
		// Iterate through beverages and increment count 
		// variable when the drink type matches
		for (Beverage j : list) {
			if (j.getType() == type)
				count++;
		}
		
		// Return count
		return count;
	}
	
	/**
	 * Return order number
	 * @return Order number
	 */
	public int getOrderNo() {
		return orderNumber;
	}
	
	/**
	 * Compare to another Order object
	 */
	public int compareTo(Object o) {
		Order order = (Order) o; 
		
		if (orderNumber == order.getOrderNo())
			return 0;
		else if (orderNumber < order.getOrderNo())
			return -1;
		else
			return 1;
	}
	
	/**
	 * Return order time
	 * @return Order time
	 */
	public int getOrderTime() {
		return orderTime;
	}
	
	/**
	 * Set order time
	 * @param time Order time
	 */
	public void setOrderTime(int time) {
		orderTime = time;
	}
	
	/**
	 * Return order day
	 * @return Order day
	 */
	public DAY getOrderDay() {
		return orderDay;
	}
	
	/**
	 * Set order day
	 * @param day Order day
	 */
	public void setDay(DAY day) {
		orderDay = day;
	}
	
	/**
	 * Return customer
	 * @return Customer object
	 */
	public Customer getCustomer() {
		return new Customer(customer.getName(), customer.getAge());
	}
	
	/**
	 * Set customer
	 * @param name Customer name
	 * @param age Customer age
	 */
	public void setCustomer(String name, int age) {
		customer = new Customer(name, age);
	}
	
	/**
	 * Return list
	 * @return
	 */
	public ArrayList<Beverage> getList() {
		return new ArrayList<Beverage>(list);
	}
	
	/**
	 * Return total items
	 * @return Total items
	 */
	public int getTotalItems() {
		return totalItems;
	}
}
