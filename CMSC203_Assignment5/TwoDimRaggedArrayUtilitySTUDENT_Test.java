

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = {
			{2804.04, 1087.62, 2569.32, 3018.42},
			{2042.55, 1097.72, 4553.71, 4452.87, 1008.65},
			{2332.38, 4051.34},
			{2712.96, 1580.34, 4733.1}
	};
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetTotal() throws FileNotFoundException {
		inputFile = new File("C:\\Users\\leone\\eclipse-workspace\\Assignments\\src\\xT1.txt");
		double[][] test1 = TwoDimRaggedArrayUtility.readFile(inputFile);
		assertEquals(57477.06, TwoDimRaggedArrayUtility.getTotal(test1), 0.1);
		
		inputFile = new File("C:\\Users\\leone\\eclipse-workspace\\Assignments\\src\\xT2.txt");
		double[][] test2 = TwoDimRaggedArrayUtility.readFile(inputFile);
		assertEquals(46586.7, TwoDimRaggedArrayUtility.getTotal(test2), 0.1);
		
		assertEquals(38045.02, TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT), 0.1);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetAverage() throws FileNotFoundException {
		inputFile = new File("C:\\Users\\leone\\eclipse-workspace\\Assignments\\src\\xT1.txt");
		double[][] test1 = TwoDimRaggedArrayUtility.readFile(inputFile);
		assertEquals(3025.10842105, TwoDimRaggedArrayUtility.getAverage(test1), .01);
		
		inputFile = new File("C:\\Users\\leone\\eclipse-workspace\\Assignments\\src\\xT2.txt");
		double[][] test2 = TwoDimRaggedArrayUtility.readFile(inputFile);
		assertEquals(2588.15,TwoDimRaggedArrayUtility.getAverage(test2), .01);
		
		assertEquals(2717.50142857, TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT), .01);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetRowTotal() throws FileNotFoundException {
		inputFile = new File("C:\\Users\\leone\\eclipse-workspace\\Assignments\\src\\xT1.txt");
		double[][] test1 = TwoDimRaggedArrayUtility.readFile(inputFile);
		
		assertEquals(18013.24, TwoDimRaggedArrayUtility.getRowTotal(test1, 0), 0.1);
		assertEquals(21098.53, TwoDimRaggedArrayUtility.getRowTotal(test1, 1), 0.1);
		assertEquals(7560.98, TwoDimRaggedArrayUtility.getRowTotal(test1, 2), 0.1);
		assertEquals(10804.31, TwoDimRaggedArrayUtility.getRowTotal(test1, 3), 0.1);
		
		inputFile = new File("C:\\Users\\leone\\eclipse-workspace\\Assignments\\src\\xT2.txt");
		double[][] test2 = TwoDimRaggedArrayUtility.readFile(inputFile);
		
		assertEquals(6063.11, TwoDimRaggedArrayUtility.getRowTotal(test2, 0), 0.1);
		assertEquals(8224.22, TwoDimRaggedArrayUtility.getRowTotal(test2, 1), 0.1);
		assertEquals(7322.47, TwoDimRaggedArrayUtility.getRowTotal(test2, 2), 0.1);
		assertEquals(10508.72, TwoDimRaggedArrayUtility.getRowTotal(test2, 3), 0.1);
		assertEquals(14468.18, TwoDimRaggedArrayUtility.getRowTotal(test2, 4), 0.1);

		
		assertEquals(9479.4, TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 0), 0.1);
		assertEquals(13155.5, TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 1), 0.1);
		assertEquals(6383.72, TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 2), 0.1);
		assertEquals(9026.4, TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 3), 0.1);
		
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetColumnTotal() throws FileNotFoundException {
		inputFile = new File("C:\\Users\\leone\\eclipse-workspace\\Assignments\\src\\xT1.txt");
		double[][] test1 = TwoDimRaggedArrayUtility.readFile(inputFile);
		
		assertEquals(9321.66, TwoDimRaggedArrayUtility.getColumnTotal(test1, 0), 0.1);
		assertEquals(10253.08, TwoDimRaggedArrayUtility.getColumnTotal(test1, 1), 0.1);
		assertEquals(13178.24, TwoDimRaggedArrayUtility.getColumnTotal(test1, 2), 0.1);
		assertEquals(10042.36, TwoDimRaggedArrayUtility.getColumnTotal(test1, 3), 0.1);
		assertEquals(6044.91, TwoDimRaggedArrayUtility.getColumnTotal(test1, 4), 0.1);
		assertEquals(8636.81, TwoDimRaggedArrayUtility.getColumnTotal(test1, 5), 0.1);
		
		
		inputFile = new File("C:\\Users\\leone\\eclipse-workspace\\Assignments\\src\\xT2.txt");
		double[][] test2 = TwoDimRaggedArrayUtility.readFile(inputFile);
		
		assertEquals(14609.27, TwoDimRaggedArrayUtility.getColumnTotal(test2, 0), 0.1);
		assertEquals(15057.4, TwoDimRaggedArrayUtility.getColumnTotal(test2, 1), 0.1);
		assertEquals(6704.83, TwoDimRaggedArrayUtility.getColumnTotal(test2, 2), 0.1);
		assertEquals(7096.13, TwoDimRaggedArrayUtility.getColumnTotal(test2, 3), 0.1);
		assertEquals(3119.07, TwoDimRaggedArrayUtility.getColumnTotal(test2, 4), 0.1);
		
		assertEquals(9891.93, TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 0), 0.1);
		assertEquals(7817.02, TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 1), 0.1);
		assertEquals(11856.13, TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 2), 0.1);
		assertEquals(7471.29, TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 3), 0.1);
		assertEquals(1008.65, TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 4), 0.1);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetHighestInArray() throws FileNotFoundException {
		inputFile = new File("C:\\Users\\leone\\eclipse-workspace\\Assignments\\src\\xT1.txt");
		double[][] test1 = TwoDimRaggedArrayUtility.readFile(inputFile);
		assertEquals(4973.81, TwoDimRaggedArrayUtility.getHighestInArray(test1), 0);
		
		
		inputFile = new File("C:\\Users\\leone\\eclipse-workspace\\Assignments\\src\\xT2.txt");
		double[][] test2 = TwoDimRaggedArrayUtility.readFile(inputFile);
		assertEquals(3767.73, TwoDimRaggedArrayUtility.getHighestInArray(test2), 0);
		
		
		assertEquals(4733.1, TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT), 0);	
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void testWriteToFile() throws FileNotFoundException {
		double[][] array= {
				{2804.04, 1087.62, 2569.32, 3018.42},
				{2042.55, 1097.72, 4553.71, 4452.87, 1008.65},
				{2332.38, 4051.34},
				{2712.96, 1580.34, 4733.1}
		};
		
		outputFile = new File("t1.txt");
		TwoDimRaggedArrayUtility.writeToFile(array, outputFile);
		
		inputFile = new File("t1.txt");
		double[][] arr = TwoDimRaggedArrayUtility.readFile(inputFile);
		String str = "";
		

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				str += arr[i][j] + " ";
			}
			str += "\n";
		}
		
		String eg = "2804.04 1087.62 2569.32 3018.42 \n2042.55 1097.72 4553.71 4452.87 1008.65 \n"
				+ "2332.38 4051.34 \n2712.96 1580.34 4733.1 \n";
		assertTrue(eg.equalsIgnoreCase(str));
		
		
	}

}
