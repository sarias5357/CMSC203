/**
 * Simulates a plot
 */
public class Plot {
	private int x;
	private int y;
	private int width;
	private int depth;
	
	/**
	 * Initialize values: default
	 */
	public Plot() {
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	/**
	 * Copy constructor
	 * @param p Plot object
	 */
	public Plot(Plot p) {
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}
	/**
	 * Initalize values with given values
	 * @param x x for plot
	 * @param y y for plot
	 * @param width width for plot
	 * @param depth depth for plot
	 */
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	/**
	 * Check if plot overlaps another
	 * @param plot Plot object
	 * @return Whether or not the plot overlaps
	 */
	public boolean overlaps(Plot plot) {
		// Store corners
		int leftCorner1x = this.x;
		int leftCorner1y = this.y;
		int rightCorner1x = this.x + (this.width - 1);
		int rightCorner1y = this.y + (this.depth - 1);
		
		int leftCorner2x = plot.x;
		int leftCorner2y = plot.y;
		int rightCorner2x = plot.x + (plot.width - 1);
		int rightCorner2y = plot.y + (plot.depth - 1);
		
		// Compare corners with each other
		if (leftCorner1x >= leftCorner2x || leftCorner2x <= rightCorner1x)
			return true;
		if (leftCorner1y >= leftCorner2y || leftCorner2y <= rightCorner2y)
			return true;
		return false;
	}
	/**
	 * Check if this plot encompasses another
	 * @param plot Plot object
	 * @return Whether or not this plot encompasses another plot
	 */
	public boolean encompasses(Plot plot) {
		// Compare if plot is within range
		if (plot.x > 10 || plot.y > 10 || plot.x < 0 || plot.y < 0)
			return false;
		else if ((plot.x + (plot.width - 1) > 10) || (plot.y + (plot.depth - 1) > 10))
			return false;
		else
			return true;
	}
	/**
	 * set value of x
	 * @param x value of x to be set
	 */
	public void setX (int x) {
		this.x = x;
	}
	/**
	 * return x
	 * @return x
	 */
	public int getX() {
		return x;
	}
	/**
	 * set value of y
	 * @param y value of y to be set
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * return y
	 * @return y
	 */
	public int getY() {
		return y;
	}
	/**
	 * set value of width
	 * @param width value of width to be set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * return width
	 * @return width
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * set value of depth
	 * @param depth value of depth to be set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	/**
	 * return depth
	 * @return depth
	 */
	public int getDepth() {
		return depth;
	}
	/**
	 * toString
	 */
	public String toString() {
		return ("Upper left: (" + x + "," + y + "); Width: " +
				width + " Depth: " + depth);
	}
}
