/**
 * Calculates the holiday bonus for the district
 * @author Steven Arias
 *
 */
public class HolidayBonus {
	
	/**
	 * Calculates the holiday bonus for each store based on how much they
	 * sold in each category
	 * @param data 2D array
	 * @param high Bonus for store with highest amount sold
	 * @param low Bonus for store with lowest amount sold
	 * @param other Bonus for all other stores
	 * @return Array of bonus for each store
	 */
	
	static double[] calculateHolidayBonus(double[][] data, double high,
			double low, double other) {
		// Store highest and lowest stores in a category
		int hi, lo;
		
		// Create array for bonuses
		double[][] bonus = new double[data.length][];
		
		// Create 2D array for bonuses
		for (int i = 0; i < data.length; i++) {
			bonus[i] = new double[data[i].length];
		}
		
		// Iterate through array
		for (int i = 0, j = 0; i < bonus.length; i++, j++) {
			// Set highest store to the index of the store with most sales in a category (column)
			// Set lowest store to the index of the store with the least sales in a category (column)
			hi = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
			lo = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, i);
			
			// still in range
			if (i < bonus[j].length) {
				// Set bonuses
				bonus[hi][i] = high;
				bonus[lo][i] = low;
	
				// If the index is a high/low store, pass
				if (j == hi || j == lo) continue;
				else {
					// If it is another store, set bonus
					bonus[j][i] = other;
				}
			}
		}
		
		// Create 1D array for bonuses for each store
		double[] bonus2 = new double[data.length];
		
		// Iterate through 2D array
		for (int i = 0; i < bonus.length; i++) {
			for (int j = 0; j < bonus[i].length; j++) {
				// Add bonus for each store and store it
				bonus2[i] += bonus[i][j];
			}
		}
		
		// Return final bonus amounts
		return bonus2;
	}
	
	static double calculateTotalHolidayBonus(double[][] data, double high,
			double low, double other) {
		// Get bonuses
		double[][] bonus = new double[data.length][];
		int hi, lo;
		double total = 0;
		
		for (int i = 0; i < data.length; i++) {
			bonus[i] = new double[data[i].length];
		}
		for (int i = 0, j = 0; i < bonus.length; i++, j++) {
			hi = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
			lo = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, i);
			
			if (i < bonus[j].length) {
				bonus[hi][i] = high;
				bonus[lo][i] = low;
				
				if (j == hi || j == lo) continue;
				else {
					bonus[j][i] = other;
				}
			}
		}
		
		// Instead of storing, add all bonuses up to total
		for (int i = 0; i < bonus.length; i++) {
			for (int j = 0; j < bonus[i].length; j++) {
				total += bonus[i][j];
			}
		}
		
		// Return total
		return total;
	}
}
