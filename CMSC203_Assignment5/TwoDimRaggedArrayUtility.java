/**
 * Performs operations with an NxN 2D array
 * (N is a number from 0-10)
 * @author Steven Arias
 */
import java.util.Scanner;
import java.io.*;

public class TwoDimRaggedArrayUtility { 
	
	/**
	 * Takes a file, reads it, and returns the contents as an array
	 * @param file File object
	 * @return Array of doubles
	 * @throws FileNotFoundException
	 */ 
	
	static double[][] readFile(File file) throws FileNotFoundException {
		int rows = 0; // Initialize number of rows
		
		// Get the number of rows by checking how many lines there are
		Scanner scan = new Scanner(file);
		while (scan.hasNextLine()) {
			rows++;
			scan.nextLine();
		}
		scan.close(); // Close scanner
		
		// Open scanner and create a 2D array with specified rows
		scan = new Scanner(file);
		double[][] arr = new double[rows][];

		// Iterate through each row
		for (int i = 0; i < arr.length; i++) {
			// Split the next line into tokens and create array for values
			String str = scan.nextLine();
			String[] tok = str.split(" ");
			arr[i] = new double[tok.length];
			
			// Convert to double and store into array
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = Double.parseDouble(tok[j]);
			}
		}
		
		// Close scanner and return array
		scan.close();
		return arr;
	}
	
	/**
	 * Writes the 2D array into the file
	 * @param data 2D ragged array
	 * @param outputFile File to write to
	 * @throws FileNotFoundException if outputFile not valid
	 */
	
	static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		// Open file to write
		PrintWriter pw = new PrintWriter(outputFile);
		
		// Iterate through 2D array
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				pw.write(data[i][j] + " "); // Write contents to file
			}
			pw.write("\n"); // Next line
		}
		
		// Close file
		pw.close();
	}
	
	/**
	 * Returns the total of all the elements
	 * @param data 2D array
	 * @return Sum of all elements
	 */
	
	static double getTotal(double[][] data) {
		double sum = 0; // Initialize sum to 0
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				sum += data[i][j]; // Add each element to sum
			}
		}
		
		// Return sum
		return sum;
	}
	
	/**
	 * Returns the average of the elements
	 * @param data 2D array
	 * @return Average of the elements
	 */
	
	static double getAverage(double[][] data) {
		// Initialize sum and element count to 0
		double sum = 0;
		int count = 0;
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				// Add contents and update the amount of elements there are
				sum += data[i][j];
				count++;
			}
		}
		
		// Return average
		return sum / count;
	}
	
	/**
	 * Returns the total of a selected row
	 * @param data 2D array
	 * @param row Selected row indexx
	 * @return Total of the row
	 */
	
	static double getRowTotal(double[][] data, int row) {
		double sum = 0;
	
		// Iterate through array and add each element at the specified
		// row to the sum
		for (int i = 0; i < data[row].length; i++) {
			sum += data[row][i];
		}
		
		return sum;
	}
	
	/**
	 * Returns the total of the specified column
	 * @param data 2D array
	 * @param col Specified column
	 * @return Total of the column
	 */
	
	static double getColumnTotal(double[][] data, int col) {
		double sum = 0;
		
		// Add elements of the column to sum
		for (int i = 0; i < data.length; i++) {
			// If there is no value for that column, continue
			try {
				sum += data[i][col];
			}
			catch (Exception e) {
				continue;
			}
		}
		
		return sum;
	}
	
	/**
	 * Returns the largest element of a row
	 * @param data 2D array
	 * @param row Row index
	 * @return Largest element in that row
	 */
	
	static double getHighestInRow(double[][] data, int row) {
		// Initialize largest element to first element in that row
		double max = data[row][0];
		
		// Iterate through the rest of the row
		for (int i = 1; i < data[row].length; i++) {
			// If another element is larger, make that one the max
			if (data[row][i] > max)
				max = data[row][i];
		}
		
		// Return largest element
		return max;
	}
	
	/**
	 * Returns the largest element in a row's index
	 * @param data 2D array
	 * @param row Row index
	 * @return Largest element's index for that row
	 */
	
	static int getHighestInRowIndex(double[][] data, int row) {
		double max = data[row][0];
		int index = 0; // Keep track of index for the largest element
		
		for (int i = 1; i < data[row].length; i++) {
			// When a larger element is found, store element and index
			if (data[row][i] > max) {
				max = data[row][i];
				index = i;
			}
		}
		
		// Return index
		return index;
	}
	
	/**
	 * Returns the smallest element of a row
	 * @param data 2D array
	 * @param row Row index
	 * @return Smallest element in that row
	 */
	
	static double getLowestInRow(double[][] data, int row) {
		// Initialize smallest value to the first value in that row
		double min = data[row][0];
		
		// Iterate through row
		for (int i = 1; i < data[row].length; i++) {
			// If a smaller value is found, make that the min
			if (data[row][i] < min)
				min = data[row][i];
		}
		
		// Return minimum value
		return min;
	}
	
	/**
	 * Returns the smallest element in a row's index
	 * @param data 2D array
	 * @param row Row index
	 * @return Smallest element's index for that row
	 */
	
	static int getLowestInRowIndex(double[][] data, int row) {
		double min = data[row][0];
		int index = 0; // Keep track of index of the smallest element
		
		for (int i = 1; i < data[row].length; i++) {
			// Find minimum and store index
			if (data[row][i] < min) {
				min = data[row][i];
				index = i;
			}
		}
		
		// Return index of smallest element
		return index;
	}
	
	/**
	 * Return highest value in a specified column
	 * @param data 2D array
	 * @param col Specified column
	 * @return Highest value in that column
	 */
	
	static double getHighestInColumn(double[][] data, int col) {
		// Initialize max to the value at the column of the first row
		double max = data[0][col];
		
		// Iterate through each row
		for (int i = 1; i < data.length; i++) {
			// If a larger element is found at that column, 
			// make it the max. If there is no column there, continue
			
			try {
				if (data[i][col] > max)
					max = data[i][col];
			}
			catch (Exception e) {
				continue;
			}
		}
		
		// Return largest value
		return max;
	}
	
	/**
	 * Return highest value in a column's index
	 * @param data 2D array
	 * @param col Specified column
	 * @return Highest value's index at that column
	 */
	
	static int getHighestInColumnIndex(double[][] data, int col) {
		double max = data[0][col];
		int index = 0; // Keep track of largest element's index
		
		for (int i = 1; i < data.length; i++) {
			// If there is no column there, continue
			try {
				if (data[i][col] > max) {
					max = data[i][col];
					index = i; // Store highest element's index
				}
			}
			catch (Exception e) {
				continue;
			}
		}
		
		// Return index
		return index;
	}
	
	/**
	 * Return smallest value in a specified column
	 * @param data 2D array
	 * @param col Specified column
	 * @return Smallest value in that column
	 */
	
	static double getLowestInColumn(double[][] data, int col) {
		// Initialize smallest value to that column in the first row
		double min = data[0][col];
		
		for (int i = 1; i < data.length; i++) {
			// If a smaller element is found at that column, 
			// make it the min. If there is no column there, continue
			
			try {
				if (data[i][col] < min)
					min = data[i][col];
			}
			catch (Exception e) {
				continue;
			}
		}
		
		// Return smallest value
		return min;
	}
	
	/**
	 * Return lowest value in a column's index
	 * @param data 2D array
	 * @param col Specified column
	 * @return lowest value's index at that column
	 */
	
	static int getLowestInColumnIndex(double[][]data, int col) {
		double min = data[0][col];
		int index = 0; // Keep track of lowest value's index
		
		for (int i = 1; i < data.length; i++) {
			// If there is no column there, continue
			try {
				if (data[i][col] < min) {
					min = data[i][col];
					index = i; // Store smallest element's index
				}
			}
			catch (Exception e) {
				continue;
			}
		}
		
		// Return index
		return index;
	}
	
	/**
	 * Returns the largest value in the array
	 * @param data 2D array
	 * @return Largest value
	 */
	
	static double getHighestInArray(double[][] data) {
		// Initialize largest value to the first element
		double max = data[0][0];
		
		// Iterate through array
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				// If a larger value is found, make it the max
				if (data[i][j] > max) 
					max = data[i][j];
			}
		}
		
		// Return largest value
		return max;
	}
	
	/**
	 * Returns the lowest value in the array
	 * @param data 2D array
	 * @return Lowest value
	 */
	
	static double getLowestInArray(double[][] data) {
		// Initialize lowest value to the first element
		double min = data[0][0];
		
		// Iterate through array
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				// If a smaller value is found, make it the min
				if (data[i][j] < min) 
					min = data[i][j];
			}
		}
		
		// Return the lowest value
		return min;
	}
}
