import java.util.Scanner; // Import statement

/**
 * Class: CMSC203-47501
 * Instructor: Dr. Grinberg
 * Assignment: Assignment 2
 * This program generates a random number and performs methods to see if the user can guess what
 * the number is
 * Due Date: 07/03/2022
 * Platform: Eclipse
 * 
 * I, Steven Arias, have not copied code from a student or any source. I have not given my 
 * code to any student.
 */
public class RandomNumberGuesser {
	public static void main(String[] args) {
		int randNum = RNG.rand(); // Generate a random number from 1 to 100
		
		// Initial low guess (0) and high guess (100). These numbers serve as a min/max
		// Next guess is initially a placeholder (0). Will eventually be the user's guess
		int lowGuess = 0, highGuess = 100, nextGuess = 0; 
		
		int invalidGuesses = 0; // Number of invalid guesses
		Scanner scan = new Scanner(System.in); // Create a Scanner object
		
		// Print header and call methods
		System.out.println("Random Number Guesser\n");
		initialQuestion(scan);
		guess(randNum, nextGuess, lowGuess, highGuess, scan, invalidGuesses);
	}
	
	/**
	 * This method prompts the user to make their initial guess
	 * @param scan Scanner object
	 */
	
	public static void initialQuestion(Scanner scan) {
		System.out.print("Enter your first guess: ");
	}
	
	/**
	 * This method allows the user to make a guess. The integer is compared with the
	 * computer-generated number to determine whether the guess is correct or not.
	 * @param randNum Computer-generated number
	 * @param nextGuess User guess
	 * @param lowGuess Minimum guess
	 * @param highGuess Maximum guess
	 * @param scan Scanner object
	 * @param invalidGuesses Number of invalid guesses made in the round
	 */
	
	public static void guess(int randNum, int nextGuess, int lowGuess, int highGuess, Scanner scan, int invalidGuesses) {
		boolean valid; // Determine if the user's guess is valid
		String str; // Hold a String object
		
		// Get the user's guess
		nextGuess = scan.nextInt();
		
		// Input validation: no guesses outside of the boundaries-- lowGuess to highGuess
		do {
			// Determine validity of input
			valid = RNG.inputValidation(nextGuess, lowGuess, highGuess);
			if (!valid) {
				nextGuess = scan.nextInt();
				invalidGuesses++; // Increase if input is invalid
			}
		} while (valid == false);
		
		// Display the number of VALID guesses by subtracting the amount of invalid guesses by the total count
		System.out.println("Number of guesses is " + (RNG.getCount() - invalidGuesses));
		
		// If guessed correctly
		if (nextGuess == randNum) {
			// Display winning statement
			System.out.println("\nCongratulations, you guessed correctly!");
			scan.nextLine(); // Newline
			
			// Prompt if user wants to play again.
			// Input validation: no answer other than "yes" or "no" (ignoring case sensitivity)
			do {
				System.out.print("Try again? (Type 'yes' or 'no'): ");
				str = scan.nextLine();
			} while (!str.equalsIgnoreCase("yes") && !str.equalsIgnoreCase("no"));
			
			// If user does not want to play, call printOutro method
			if (str.equalsIgnoreCase("no"))
				printOutro(scan);
			// If user wants to play
			else {
				randNum = RNG.rand(); // Create new random number
				RNG.resetCount(); // Reset the count
				initialQuestion(scan); // Prompt user to make initial guess
				guess(randNum, nextGuess, 0, 100, scan, 0); // Call guess method with new values
			}
		}
		// If guessed incorrectly
		else 
			// Call method
			processGuess(randNum, nextGuess, lowGuess, highGuess, scan, invalidGuesses);
	}
	
	/**
	 * In case of an incorrect guess, this method explains how the user guess is wrong and prompts
	 * them for a new guess
	 * @param randNum Computer-generated number
	 * @param nextGuess User guess
	 * @param lowGuess Minimum guess
	 * @param highGuess Maximum guess
	 * @param scan Scanner object
	 * @param invalidGuesses Number of invalid guesses made in the round
	**/

	public static void processGuess(int randNum, int nextGuess, int lowGuess, int highGuess, Scanner scan, int invalidGuesses) {
		// If the guess was too low
		if (nextGuess < randNum) {
			lowGuess = nextGuess; // Set the new low bound to the user's guess
			System.out.println("Your guess is too low");
			
			// Prompt user for a new guess and call the guess() method again with the new lowGuess value
			System.out.print("\nEnter your next guess between "
					+ lowGuess + " and " + highGuess + ": ");
			guess(randNum, nextGuess, lowGuess, highGuess, scan, invalidGuesses);
		}
		// If the guess was too high
		else {
			highGuess = nextGuess; // Set the new high bound to the user's guess
			System.out.println("Your guess is too high");
			
			// Prompt the user for a new guess and call the guess() method again with the new highGuess value
			System.out.print("\nEnter your next guess between "
					+ lowGuess + " and " + highGuess + ": ");
			guess(randNum, nextGuess, lowGuess, highGuess, scan, invalidGuesses);
		}
	}
	
	/**
	 * This method prints a goodbye statement and terminates the program
	 * @param scan Scanner object
	 */
	
	public static void printOutro(Scanner scan) {
		System.out.println("Thanks for playing!");
		System.out.println("\n\nSteven Arias"); 
		
		// Close Scanner and terminate program
		scan.close();
		System.exit(0);
	}
}
