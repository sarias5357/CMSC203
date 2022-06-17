/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Description: This class simulates a WiFi diagnosis by taking user input and taking further action depending
 * on what the user says
 * Due: 6/19/2022
 * Platform/compiler: Eclipse Compiler
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: ___Steven Arias_______
*/

import java.util.Scanner;

public class WiFiDiagnosis {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String input; // Store user input
		
		System.out.println("Starting WiFi diagnosis..."); // Intro statement
		
		// Try step of diagnosis
		System.out.println("1) Reboot your computer and try connecting to WiFi.");
		do {
			System.out.print("Did this work? (type yes or no) ");
			input = keyboard.nextLine();
		} while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")); /* Input validation: no response 
																				other than "yes" or "no" allowed */
		
		// If step was successful, print success statement and exit program
		if (input.equalsIgnoreCase("yes")) {
			System.out.println("Great! Rebooting your computer worked!");
			System.exit(0);
		}
		
		// Repeat with new steps
		System.out.println("\n2) Reboot your router and try to connect.");
		do {
			System.out.print("Did this work? (type yes or no) ");
			input = keyboard.nextLine();
		} while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
		
		if (input.equalsIgnoreCase("yes")) {
			System.out.println("Great! Rebooting your router worked!");
			System.exit(0);
		}
		
		System.out.println("\n3) Make sure that the cables connecting the router are firmly"
				+ " plugged in and power is getting to the router.");
		do {
			System.out.print("Did this work? (type yes or no) ");
			input = keyboard.nextLine();
		} while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
		
		if (input.equalsIgnoreCase("yes")) {
			System.out.println("Great! Checking your cables worked!");
			System.exit(0);
		}
		
		System.out.println("\n4) Move your computer closer to the router and try to connect.");
		do {
			System.out.print("Did this work? (type yes or no) ");
			input = keyboard.nextLine();
		} while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
		
		if (input.equalsIgnoreCase("yes")) {
			System.out.println("Great! Moving your computer closer to the router worked!");
			System.exit(0);
		}
		
		// If program has not been terminated yet, print last step and exit program
		System.out.print("\n5) Sorry, please try contacting your ISP for further support.");
		keyboard.close();
		System.exit(0);
	}
}
