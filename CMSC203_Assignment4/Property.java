/**
 * This class represents a Property object
 */
public class Property {
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	/**
	 * Initialize to default
	 */
	public Property() {
		city = "";
		owner = "";
		propertyName = "";
		rentAmount = 0;
		plot = new Plot();
	}
	/**
	 * Copy constructor
	 * @param p Property object
	 */
	public Property(Property p) {
		this.city = p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		this.plot = new Plot(p.plot.getX(), p.plot.getY(), 
				p.plot.getWidth(), p.plot.getDepth());
	}
	/**
	 * Initialize with given values
	 * @param propertyName Property name
	 * @param city Property city
	 * @param rentAmount Property rent amount
	 * @param owner Property owner
	 */
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}
	/**
	 * Initialize with given values and plot
	 * @param propertyName Property name
	 * @param city Property city
	 * @param rentAmount Property rent amount
	 * @param owner Property owner
	 * @param x x for plot
	 * @param y y for plot
	 * @param width width for plot
	 * @param depth depth for plot
	 */
	public Property(String propertyName, String city, double rentAmount, String owner,
			int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		plot = new Plot();
		this.plot.setX(x);
		this.plot.setY(y);
		this.plot.setWidth(width);
		this.plot.setDepth(depth);
	}
	/**
	 * return city
	 * @return city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * return owner name
	 * @return owner 
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * return property name
	 * @return propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}
	/**
	 * return rent amount
	 * @return rentAmount
	 */
	public double getRentAmount() {
		return rentAmount;
	}
	/**
	 * return plot
	 * @return plot
	 */
	public Plot getPlot() {
		return new Plot(this.plot.getX(), this.plot.getY(),
				this.plot.getWidth(), this.plot.getDepth());
	}
	/**
	 * set plot to given values
	 * @param x x value
	 * @param y y value 
	 * @param width width value
	 * @param depth depth value
	 * @return Plot object
	 */
	public Plot setPlot(int x, int y, int width, int depth) {
		this.plot.setX(x);
		this.plot.setY(y);
		this.plot.setWidth(width);
		this.plot.setDepth(depth);
		
		return new Plot(this.plot.getX(), this.plot.getY(),
				this.plot.getWidth(), this.plot.getDepth());
	}
	/**
	 * set city 
	 * @param city 
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * set owner
	 * @param owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * set property name
	 * @param propertyName
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	/**
	 * set rent amount
	 * @param rentAmount
	 */
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	/**
	 * toString
	 */
	public String toString() {
		String s = String.format("Property name: %s\nLocated in"
				+ " %s\nBelonging to: %s\nRent Amount: %.1f ", 
				propertyName, city, owner, rentAmount);
		return s;
	}
}
