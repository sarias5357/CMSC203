/**
 * This class simulates a checking account
 * @author Steven A
 */
public class CheckingAccount extends BankAccount {
	private static final double FEE = .15; // Store check clearing fee
	
	/**
	 * This constructor sets the name and dollar amount for a person's savings account
	 * @param name Name of owner
	 * @param amount Initial balance
	 */
	public CheckingAccount(String name, double amount) {
		super(name, amount);
		
		// Set account number with correct identifier
		super.setAccountNumber(super.getAccountNumber() + "-10");
	}
	
	/**
	 * This method withdraws money from the balance
	 */
	@Override
	public boolean withdraw(double amount) {
		double total = amount + FEE; // Include check clearing fee
		return super.withdraw(total); // Return superclass's method's return value
	}
}
