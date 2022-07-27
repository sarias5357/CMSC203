import java.util.ArrayList;

/**
 * Represents a shop
 * @author Steven A
 */
public class BevShop implements BevShopInterfce {
	// Store information on shop
	private int numOfAlcoholicDrink = 0;
	private final int MAX_ALCOHOL = 3;
	private ArrayList<Order> orders;
	private final int DRINKING_AGE = 21;
	private Order currentOrder;
	private int currentIndex = -1;
	
	/**
	 * This constructor sets alcoholic dirnks at 0 and makes a new
	 * arraylist of orders
	 */
	public BevShop() {
		numOfAlcoholicDrink = 0;
		orders = new ArrayList<>();
	}
	
	/**
	 * Determines whether a given time is valid or not
	 */
	public boolean validTime(int time) {
		if (time >= MIN_TIME && time <= MAX_TIME)
			return true;
		return false;
	}
	
	/**
	 * Determines whether customer is eligible for another alcoholic drink
	 */
	public boolean eligibleForMore() {
		int count = currentOrder.findNumOfBeveType(TYPE.ALCOHOL);
		
		// Cannot exceed more than 3 alcoholic drinks
		if (count >= 3)
			return false;
		return true;
	}
	
	/**
	 * Determines whether a given age is valid drinking age
	 */
	public boolean validAge(int age) {
		if (age <= 21)
			return false;
		return true;
	}
	
	/**
	 * Starts a new order
	 */
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		// Create a new current order
		currentOrder = new Order(time, day, customerName, customerAge);
		currentIndex++;
		
		// Reset alcoholic drinks
		numOfAlcoholicDrink = 0;
		// Add order to list
		orders.add(currentOrder);
	}
	
	/**
	 * Retrieve current order
	 * @return Current order
	 */
	public Order getCurrentOrder() {
		return currentOrder;
	}
	
	/**
	 * Add coffee order
	 */
	public void processCoffeeOrder(String bevName, SIZE size, boolean shot, boolean syrup) {
		orders.get(currentIndex).addNewBeverage(bevName, size, shot, syrup);
	}
	
	/**
	 * Add alcohol order
	 */
	public void processAlcoholOrder(String bevName, SIZE size) {
		orders.get(currentIndex).addNewBeverage(bevName, size);
		numOfAlcoholicDrink++;
	}
	
	/**
	 * Add smoothie order
	 */
	public void processSmoothieOrder(String bevName, SIZE size, int fruits, boolean p) {
		orders.get(currentIndex).addNewBeverage(bevName, size, fruits, p);
	}
	
	/**
	 * Find an order given the order number
	 */
	public int findOrder(int num) {
		int ind = 0;
		
		// Iterate through orders
		for (Order o : orders) {
			// If order number matches, return the index
			if (o.getOrderNo() == num)
				return ind;
			ind++;
		}
		
		// If not found: return -1
		return -1;
	}
	
	/**
	 * Return total order price given an index
	 */
	public double totalOrderPrice(int num) {
		int i = findOrder(num);
		
		return orders.get(i).calcOrderTotal();
	}
	
	/**
	 * Return total for all orders
	 */
	public double totalMonthlySale() {
		double total = 0;
		for (Order o: orders) {
			total += o.calcOrderTotal();
		}
		return total;
	}
	
	/**
	 * Sort orders
	 */
	public void sortOrders() {
		// Selection sort: iterate through each item
		for (int i = 0; i < orders.size(); i++) {
			// Store base minimum
			int min = i;
			
			// Iterate through the rest
			for (int j = i + 1; j < orders.size(); j++) {
				// If a smaller number is found, make the min the index of that number
				if (orders.get(j).getOrderNo() < orders.get(min).getOrderNo())
					min = j;
			}
			
			// Switch order
			Order temp = orders.get(min);
			orders.set(min, orders.get(i));
			orders.set(i, temp);
		}
	}
	
	/**
	 * Determines if fruit is maxed
	 * @param f Amount of fruit
	 * @return If fruit is maxed
	 */
	public boolean isMaxFruit(int f) {
		if (f > 5)
			return true;
		return false;
	}
	
	/**
	 * Returns the order at an index, i
	 */
	public Order getOrderAtIndex(int i) {
		return orders.get(i);
	}
	
	/**
	 * Returns the number of alcoholic drinks for the current order
	 * @return number of alcoholic drinks for the current order
	 */
	public int getNumOfAlcoholDrink() {
		return numOfAlcoholicDrink;
	}
	
	/**
	 * Returns the max amount of alcohol orders that can be made
	 * @return the max amount of alcohol orders that can be made
	 */
	public int getMaxOrderForAlcohol() {
		return MAX_ALCOHOL;
	}
	
	/**
	 * Returns the minimum drinking age
	 * @return minimum drinking age
	 */
	public int getMinAgeForAlcohol() {
		return DRINKING_AGE;
	}
	
	/**
	 * Returns the amount of orders made
	 * @return amount of orders made
	 */
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	
	/**
	 * toString
	 */
	public String toString() {
		String str = String.valueOf(totalMonthlySale());
		
		for (Order o: orders) {
			str += o.getOrderNo() + o.toString();
		}
		return str;
	}
}
