/**
 * This class simulates a Coffee product at Bradley shop
 * @author Steven A.
 */
public class Coffee extends Beverage {
	// Store info on coffee
	private boolean containsExtraShot;
	private boolean containsExtraSyrup;
	private final double SHOT_PRICE = .5;
	private final double SYRUP_PRICE = .5;
	
	/**
	 * This constructor sets the name, type, size, and add-ons for the coffee
	 * @param name Coffee name
	 * @param type Coffee type
	 * @param size Coffee size
	 * @param shot Whether or not there is an extra shot
	 * @param syrup Whether or not there is extra syrup
	 */
	public Coffee(String name, SIZE size, boolean shot, boolean syrup) {
		super(name, TYPE.COFFEE, size);
		
		// If user wants add-ons, adjust containsExtraShot/Syrup to true
		// Else false
		if (shot)
			containsExtraShot = true;
		if (syrup)
			containsExtraSyrup = true;
			
	}
	
	@Override
	/**
	 * Calculate price
	 */
	public double calcPrice() {
		// Set base price
		double total = super.getBasePrice();
		
		// If size ups, increase price
		if (super.getSize() == SIZE.MEDIUM) 
			total += super.getSizeUpPrice();
		else if (super.getSize() == SIZE.LARGE) 
			total += (super.getSizeUpPrice() * 2);
		
		// If add-ons, increase price
		if (containsExtraShot)
			total += SHOT_PRICE;
		if (containsExtraSyrup)
			total += SYRUP_PRICE;
		return total; // Return final price
	}
	
	/**
	 * toString
	 */
	
	public String toString() {
		String str = super.toString();
		
		str += "Contains extra shot? ";
		if (containsExtraShot)
			str += "Yes\n";
		else
			str += "No\n";
		
		str += "Contains extra syrup? ";
		if (containsExtraSyrup)
			str += "Yes\n";
		else
			str += "No\n";
		
		str += String.format("Price: $%.2f\n", calcPrice());
		return str;
	}
	
	/**
	 * This equals method compares the parameters with the instance variables
	 * @param name Coffee name
	 * @param size Coffee size
	 * @param shot Whether or not there is an extra shot
	 * @param syrup Whether or not there is extra syrup
	 * @return Whether or not the beverages are equal
	 */
	public boolean equals(String name, SIZE size, boolean shot, boolean syrup) {
		boolean boo = super.equals(name, TYPE.COFFEE, size);
		
		if (shot != containsExtraShot || syrup != containsExtraSyrup)
			boo = false;
		
		return boo;
	}
	
	/**
	 * Return whether or not there is an extra shot
	 * @return Whether or not there is an extra shot
	 */
	public boolean getExtraShot() {
		return containsExtraShot;
	}
	
	/**
	 * Return whether or not there is extra syrup
	 * @return Whether or not there is extra syrup
	 */
	public boolean getExtraSyrup() {
		return containsExtraSyrup;
	}
	
	/**
	 * Set whether or not there is an extra shot
	 * @param f Whether or not there is an extra shot
	 */
	public void addExtraShot(boolean f) {
		containsExtraShot = f;
	}
	
	/**
	 * Set whether or not there is extra syrup
	 * @param f Whether or not there is extra syrup
	 */
	public void addExtraSyrup(boolean f) {
		containsExtraSyrup = f;
	}
	
	/**
	 * Return price for additional shot
	 * @return Price for additional shot
	 */
	public double getShotPrice() {
		return SHOT_PRICE;
	}
	
	/**
	 * Return price for added syrup
	 * @return Price for added syrup
	 */
	public double getSyrupPrice() {
		return SYRUP_PRICE;
	}
}
