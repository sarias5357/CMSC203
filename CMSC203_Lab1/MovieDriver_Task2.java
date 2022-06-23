import java.util.Scanner;

/**
 * Class: CMSC203-47501
 * Assignment: Lab 1
 * This program satisfies Task #2 of Lab 1. The program outputs movie information given by
 * user input. The user can keep entering information to their liking.
 *
 * Due Date: 07/03/2022
 */

public class MovieDriver_Task2 {
	
	public static void main(String[] args) {
		// Create Scanner and Movie objects
		Scanner scan = new Scanner(System.in);
		Movie movie = new Movie();
		
		// Create variables to store movie information and user input
		String title, rating;
		int ticketsSold;
		char ans;
		boolean response;
		
		// Loop while user wants to keep entering input (response == true)
		do { 
			// Get movie title and set it in the "title" field
			System.out.print("Enter a movie title: ");
			title = scan.nextLine();
			movie.setTitle(title);
		
			// Get movie rating and set it in the "rating" field
			System.out.print("Enter the rating: ");
			rating = scan.nextLine();
			movie.setRating(rating);
		
			// Get tickets sold and set it in the "sold tickets" field
			System.out.print("Enter the number of tickets sold at the theater: ");
			ticketsSold = scan.nextInt();
			movie.setSoldTickets(ticketsSold);
		
			// Print Movie information
			System.out.println(movie.toString());
			System.out.println();
			scan.nextLine();
			
			// Input validation: cannot enter anything else except 'y' or 'n'
			do {
				// Get user's response
				System.out.print("Do you want to enter another movie? (type 'y' or 'n'): ");
				ans = scan.nextLine().charAt(0);
			} while (Character.toLowerCase(ans) != 'y' && Character.toLowerCase(ans) != 'n');
			
			// If user typed 'y', set boolean variable to true. Otherwise, false
			if (ans == 'y') response = true;
			else response = false;
		} while (response);
		
		// Print closing statement, close Scanner, terminate program
		System.out.print("Goodbye!");
		scan.close();
		System.exit(0);
	}

}
