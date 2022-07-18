

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany co;
	@Before
	public void setUp() throws Exception {
		//student create a management company
		 co = new ManagementCompany("T1", "14556", 5);
		//student add three properties, with plots, to mgmt co
		co.addProperty("Test 1", "Lanham", 1500, "Ashley L", 1, 1, 1, 1);
		co.addProperty("Test 2", "Riverdale", 1400, "Junior V", 3, 5, 2, 2);
		co.addProperty("Test 3", "Wheaton", 2000, "Bryan A", 6, 4, 1, 1);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null 
		co = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//fail("STUDENT test not implemented yet");
		//student should add property with 4 args & default plot (0,0,1,1)
		co.addProperty("Test 4" , "Kent Island", 1500, "Steven A" , 0, 0, 1, 1);
		//student should add property with 8 args
		co.addProperty("Test 5", "Laurel", 2200, "Jose G", 2, 2, 2, 2);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		co.addProperty("Full", "Ocean City", 3000, "Rich G", 6, 8, 2, 2);
	}
 
	@Test
	public void testMaxRentProp() {
		//fail("STUDENT test not implemented yet");
		//student should test if maxRentProp contains the maximum rent of properties
		double max = 2200;
		assertTrue(co.maxRentProp() == 2200);
	}

	@Test
	public void testTotalRent() {
		//fail("STUDENT test not implemented yet");
		//student should test if totalRent returns the total rent of properties
		double total = co.totalRent();
		assertEquals(8600, total, 0.01);
	}

 }
