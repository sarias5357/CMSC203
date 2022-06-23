import java.util.Scanner;

/**
 * Class: CMSC203-47501
 * Assignment: Lab 1
 * This program satisfies Task #1 of Lab 1. The program outputs movie information given by user input. 
 *
 * Due Date: 07/03/2022
 */

public class MovieDriver_Task1 {

	public static void main(String[] args) {
		// Create Scanner and Movie objects
		Scanner scan = new Scanner(System.in);
		Movie movie = new Movie();
		
		// Create variables to store movie information
		String title, rating;
		int ticketsSold;
		
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
		
		// Print Movie information and closing statement
		System.out.println(movie.toString());
		System.out.println("\nGoodbye!");
		
		// Close scanner and terminate program
		scan.close();
		System.exit(0);
	}

}
