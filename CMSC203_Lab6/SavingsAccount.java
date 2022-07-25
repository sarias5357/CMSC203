/**
 * This class simulates a savings account
 * @author Steven A
 */
public class SavingsAccount extends BankAccount {
	private double rate = .025; // Store annual interest rate
	private int savingsNumber = 0; // Store savings number 
	private String accountNumber; // Store account number
	
	/**
	 * This constructor sets the name and dollar amount for a person's savings account
	 * @param name Name of owner
	 * @param amount Initial balance
	 */
	public SavingsAccount(String name, double amount) {
		super(name, amount);
		
		// Set account number with correct identifier 
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
		// Increment number of savings accounts
		savingsNumber++;
	}
	
	/**
	 * Copy constructor
	 * @param oldAccount SavingsAccount object
	 * @param amount Initial amount
	 */
	public SavingsAccount(SavingsAccount oldAccount, double amount) {
		super(oldAccount, amount); // Call superclass's copy constructor
		savingsNumber++;
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	/**
	 * This method adds one month worth of interest on balance to the account
	 */
	public void postInterest() {
		// Deposit a MONTH's worth of interest
		super.deposit( (rate / 12) * super.getBalance() ); 
	}
	@Override
	/**
	 * Return account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
}
