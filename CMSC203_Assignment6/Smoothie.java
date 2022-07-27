/**
 * This class simulates a smoothie product at Bradley shop
 * @author Steven A.
 */
public class Smoothie extends Beverage {
	// Store smoothie info
	private int fruits;
	private boolean containsProteinPowder;
	private final double PROTEIN_PRICE = 1.5;
	private final double FRUIT_PRICE = .5;
	
	/**
	 * This constructor sets the name, type, size, and add-ons for the smoothie
	 * @param name Smoothie name
	 * @param size Smoothie size
	 * @param fruits Amount of fruits
	 * @param protein Whether or not there is protein in it
	 */
	public Smoothie(String name, SIZE size, int fruits, boolean protein) {
		super(name, TYPE.SMOOTHIE, size);
		
		this.fruits = fruits;
		containsProteinPowder = protein;
	}
	
	/**
	 * Calculate price
	 */
	public double calcPrice() {
		// Set base price
		double total = super.getBasePrice();
		
		// Increase price if there was a size up
		if (super.getSize() == SIZE.MEDIUM) 
			total += super.getSizeUpPrice();
		else if (super.getSize() == SIZE.LARGE) 
			total += (super.getSizeUpPrice() * 2);
		
		// Increase price if there is protein
		if (containsProteinPowder)
			total += PROTEIN_PRICE;
		
		// Factor fruits into total and return
		total += (fruits * FRUIT_PRICE);
		return total;
	}
	
	/**
	 * This equals method compares the parameters with the instance variables
	 * @param name Smoothie name
	 * @param size Smoothie size
	 * @param fruits Amount of fruits
	 * @param protein Whether or not there is protein in it
	 * @return Whether or not the beverages are equal
	 */
	public boolean equals(String name, SIZE size, int fruits, boolean protein) {
		boolean boo = super.equals(name, TYPE.SMOOTHIE, size);
		
		if (this.fruits != fruits || protein != containsProteinPowder)
			boo = false;
		
		return boo;
	}
	
	/**
	 * toString
	 */
	public String toString() {
		String str = super.toString();
		
		str += "Contains protein? ";
		if (containsProteinPowder)
			str += "Yes\n";
		else
			str += "No\n";
		
		str += "Number of fruits: " + fruits + "\n";
		
		str += String.format("Price: $%.2f\n", calcPrice());
		return str;
	}
	
	/**
	 * Return amount of fruit
	 * @return Amount of fruit
	 */
	public int getNumOfFruits() {
		return fruits;
	}
	
	/**
	 * Set amount of fruit
	 * @param f Amount of fruit
	 */
	public void setFruits(int f) {
		fruits = f;
	}
	
	/**
	 * Get whether or not it contains protein powder
	 * @return Whether or not it contains protein powder
	 */
	public boolean getAddProtein() {
		return containsProteinPowder;
	}
	
	/**
	 * Set whether or not it contains protein powder
	 * @param b Whether or not it contains protein powder
	 */
	public void setProteinPowder(boolean b) {
		containsProteinPowder = b;
	}
	
	/**
	 * Return the price for additional fruit
	 * @return Price for additional fruit
	 */
	
	public double getFruitPrice() {
		return FRUIT_PRICE;
	}
	
	/**
	 * Return the price for added protein
	 * @return Price for added protein
	 */
	
	public double getProteinPrice() {
		return PROTEIN_PRICE;
	}
}
