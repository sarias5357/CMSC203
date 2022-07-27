/**
 * This class simulates an Alcoholic product at Bradley shop
 * @author Steven A.
 */
public class Alcohol extends Beverage{
	// Store info on drink
	private boolean offeredOnTheWeekend;
	private final double WEEKEND_PRICE = .6;
	
	/**
	 * This constructor sets the name, type, size, and whether or not the drink
	 * is offered on the weekends
	 * @param name Drink name
	 * @param type Drink type
	 * @param size Drink size
	 * @param offer Whether or not it is offered on the weekends
	 */
	public Alcohol(String name, SIZE size, boolean offer) {
		super(name, TYPE.ALCOHOL, size);
		
		offeredOnTheWeekend = offer;
	}
	
	/**
	 * Calculate price
	 */
	public double calcPrice() {
		// Get base price
		double total = super.getBasePrice();
		
		// Increase price if size ups
		if (super.getSize() == SIZE.MEDIUM) 
			total += super.getSizeUpPrice();
		else if (super.getSize() == SIZE.LARGE) 
			total += (super.getSizeUpPrice() * 2);
		
		// Increase price if it is a weekend drink and return total
		if (offeredOnTheWeekend)
			total += WEEKEND_PRICE;
		return total;
	}
	
	/**
	 * This equals method compares the parameters with the instance variables
	 * @param name Drink name
	 * @param type Drink type
	 * @param size Drink size
	 * @param offer Whether or not it is offered on the weekends
	 * @return Whether or not the drinks are equal
	 */
	public boolean equals(String name, SIZE size, boolean offer) {
		boolean boo = super.equals(name, TYPE.ALCOHOL, size);
		
		if (offeredOnTheWeekend != offer)
			boo = false;
		
		return boo;
	}
	
	/**
	 * toString
	 */
	public String toString() {
		String str = super.toString();
		str += "Offered on the weekend? ";
		
		if (offeredOnTheWeekend)
			str += "Yes\n";
		else
			str += "No\n";
		
		str += String.format("Price: $%.2f\n", calcPrice());
		return str;
	}
	
	/**
	 * Return whether or not the drink is available on the weekend
	 * @return Whether or not the drink is available on the weekend
	 */
	public boolean offeredOnTheWeekend() {
		return offeredOnTheWeekend;
	}
	
	/**
	 * Set whether or not the drink is available on the weekend
	 * @param f Whether or not the drink is available on the weekend
	 */
	public void setWeekendAvailability(boolean f) {
		offeredOnTheWeekend = f;
	}
	
	/**
	 * Get additional weekend price
	 * @return Additional weekend drink price
	 */
	public double getWeekendPrice() {
		return WEEKEND_PRICE;
	}
}
