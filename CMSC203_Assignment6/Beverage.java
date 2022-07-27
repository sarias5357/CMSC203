/**
 * This class is used as a superclass for other beverages
 * @author Steven A.
 */
public abstract class Beverage {
	// Store beverage info
	private String bevName;
	private TYPE bevType;
	private SIZE bevSize;
	private final double BASE_PRICE = 2.0;
	private final double SIZEUP_PRICE = 1.0;
	
	/**
	 * This constructor sets the beverage's name, type, and size
	 * @param name Beverage name
	 * @param type Beverage type
	 * @param size Beverage size
	 */
	public Beverage(String name, TYPE type, SIZE size) {
		bevName = name;
		bevSize = size;
		bevType = type;
	}
	
	/**
	 * This method will be used to return the price of a specific beverage
	 * @return Price of beverage
	 */
	public abstract double calcPrice();
	
	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return bevSize + " " + bevName + "\n"; 
	}
	
	/**
	 * This equals method compares each of the parameters with the instance
	 * variables
	 * @param name Beverage name
	 * @param type Beverage type
	 * @param size Beverage size
	 * @return Whether or not the beverages are equal
	 */
	
	public boolean equals(String name, TYPE type, SIZE size) {
		if (!bevName.equalsIgnoreCase(name))
			return false;
		if (type != (bevType))
			return false;
		if ( size !=(bevSize))
			return false;
		else 
			return true;
	}

	public boolean equals(Beverage b) {
		if (!b.getBevName().equalsIgnoreCase(bevName))
			return false;
		if (b.getType() != (bevType))
			return false;
		if (b.getSize() != bevSize)
			return false;
		return true;
	}
	
	/**
	 * Set beverage name
	 * @param name Beverage name
	 */
	
	public void setBevName(String name) {
		bevName = name;
	}
	
	/**
	 * Get beverage name
	 * @return Beverage name
	 */
	
	public String getBevName() {
		return bevName;
	}
	
	/**
	 * Set beverage type
	 * @param type Beverage type
	 */
	
	public void setBevType(TYPE type) {
		bevType = type;
	}
	
	/**
	 * Get beverage type
	 * @return Beverage type
	 */
	public TYPE getType() {
		return bevType;
	}
	
	/**
	 * Set beverage size 
	 * @param size Beverage size
	 */
	
	public void setBevSize(SIZE size) {
		bevSize = size;
	}
	
	/**
	 * Get beverage size
	 * @return Beverage size
	 */
	public SIZE getSize() {
		return bevSize;
	}
	
	/**
	 * Get base price
	 * @return Base price
	 */
	
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	/**
	 * Get the additional charge for sizing up one
	 * @return Additional charge for sizing up one
	 */
	public double getSizeUpPrice() {
		return SIZEUP_PRICE;
	}
	
}
