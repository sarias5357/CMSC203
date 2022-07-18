/**
 * Represents a property management company
 */
public class ManagementCompany {
	private final int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;
	
	// Keep track of index
	public int ind = -1;
	
	/**
	 * Constructor
	 */
	public ManagementCompany() {
		plot = new Plot(0, 0, 10, 10);
		properties = new Property[MAX_PROPERTY];
	}
	/**
	 * Constructor
	 * @param name Company name
	 * @param taxID Tax ID
	 * @param mgmFee Fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(0, 0, 10, 10);
		properties = new Property[MAX_PROPERTY];
	}
	/**
	 * Constructor
	 * @param name Company name
	 * @param taxID tax id
	 * @param mgmFee fee
	 * @param x x for plot
	 * @param y y for plot
	 * @param width width for plot
	 * @param depth depth for plot
	 */
	public ManagementCompany(String name, String taxID, double mgmFee,
			int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
	}
	/**
	 * Copy constructor
	 * @param otherCompany ManagementCompany object
	 */
	public ManagementCompany(ManagementCompany otherCompany) {
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.name = otherCompany.name;
		properties = new Property[MAX_PROPERTY];
		for (int i = 0; i < MAX_PROPERTY; i++) {
			properties[i] = otherCompany.properties[i];
		}
		this.taxID = otherCompany.taxID;
		this.plot = new Plot(otherCompany.plot.getX(), otherCompany.plot.getY(),
				otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
	}
	/**
	 * Adds property to management
	 * @param property Property object
	 * @return index or error code
	 */
	public int addProperty(Property property) {
		// Create object and note index
		Property p = new Property(property);
		int ind = this.ind;
		
		// Go through cases and see if there is an error. If so, return respective error code
		if (ind + 1 >= MAX_PROPERTY)
			return -1;
		else if (!plot.encompasses(p.getPlot()))
			return -3;
		else if (ind >= 0) {
			for (int i = 0; i < properties.length; i++) {
				if (properties[i] == null) 
					continue;
				else if (properties[i].getPlot().overlaps(p.getPlot()))
					return -4;
			}
		}
		
		// No error: add property to array and update index
		properties[ind + 1] = p;
		this.ind = ind + 1;
		return ind + 1;		
	}
	/**
	 * Adds property to management
	 * @param name Property name
	 * @param city Property city
	 * @param rent Property rent
	 * @param owner Property owner
	 * @return Error code or index
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		Property p = new Property(name, city, rent, owner);
		int ind = this.ind;
		
		if (ind + 1 >= MAX_PROPERTY)
			return -1;
		else if (!plot.encompasses(p.getPlot()))
			return -3;
		else if (ind >= 0) {
			for (int i = 0; i < properties.length; i++) {
				if (properties[i] == null) 
					continue;
				else if (properties[i].getPlot().overlaps(p.getPlot()))
					return -4;
			}
		}
		
		properties[ind + 1] = p;
		this.ind = ind + 1;
		return ind + 1;	
	}
	/**
	 * Add property to management 
	 * @param name Property name
	 * @param city Property city
	 * @param rent Property rent
	 * @param owner Property owner
	 * @param x x for plot
	 * @param y y for plot
	 * @param width width for plot
	 * @param depth depth for plot
	 * @return error code or index
	 */
	public int addProperty(String name, String city, double rent, String owner,
			int x, int y, int width, int depth) {
		Property p = new Property(name, city, rent, owner, x, y, width, depth);
		int ind = this.ind;
		
		if (ind + 1 >= MAX_PROPERTY)
			return -1;
		else if (!plot.encompasses(p.getPlot()))
			return -3;
		else if (ind >= 0) {
			for (int i = 0; i < properties.length; i++) {
				if (properties[i] == null) 
					continue;
				if (properties[i].getPlot().overlaps(p.getPlot()))
					return -4;
			}
		}
		
		properties[ind + 1] = p;
		this.ind = ind + 1;
		return ind + 1;	
	}
	/**
	 * Display properties at given index
	 * @param i Given index
	 * @return Property information at index i
	 */
	public String displayPropertyAtIndex(int i) {
		return properties[i].toString();
	}
	/**
	 * Return MAX_PROPERTY
	 * @return max number of properties
	 */
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	/**
	 * return the highest rent
	 * @return max rent
	 */
	public double maxRentProp() {
		// Set max to 0
		Property max = new Property(properties[0]);
		
		// Iterate through each property and find which is the highest rent
		for (int i = 1; i < properties.length; i++) {
			if (properties[i] == null) continue;
			if (properties[i].getRentAmount() > max.getRentAmount()) {
				max = new Property(properties[i]);
			}
		}

		return max.getRentAmount();
	}
	/**
	 * Get the index of the rent with the highest property
	 * @return Index 
	 */
	public int maxRentPropertyIndex() {
		Property max = new Property(properties[0]);
		int ind = 0;
		
		for (int i = 1; i < properties.length; i++) {
			if (properties[i].getRentAmount() > max.getRentAmount()) {
				max = new Property(properties[i]);
				ind = i;
			}
		}
	
		return ind;
	}
	/**
	 * Return plot
	 * @return this plot
	 */
	public Plot getPlot() {
		return plot;
	}
	/**
	 * Return management co. name
	 * @return Name
	 */
	public String getName() {
		return name;
	}
	/**
	 * toString
	 */
	public String toString() {
		String str = "List of Properties for " 
				+ name + ", " + taxID + ": \n______________________________\n";
		for (Property p : properties) {
			if (p == null)
				continue;
			str += p.toString() + "\n";
		}
		str += "______________________________\n";
		str += "Total Management Fee: " + (mgmFeePer * (totalRent()) / 100);
		return str;
	}
	public double totalRent() {
		double total = 0;
		for (Property p : properties) {
			if (p == null) 
				continue;
			total += p.getRentAmount();
		}
		return total;
	}
}
