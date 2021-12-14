/**
 * This class contains the Account object that is used in the database for the Payroll application.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.01
 */
public class Account {

	// Class Variables
	private final int id;
	private final String name;
	private final String email;
	private final PayPeriod.PayPeriodType periodType;
	private final PayPeriod.PeriodStartDay startDay;

	// Constructor
	/**
	 * Create's an Account object based off of the given information.
	 * 
	 * @param pId - the id of the account object
	 * @param pName - the name of the account object
	 * @param pEmail - the email of the account object
	 * @param pPeriodType - the pay period type of the account object
	 * @param pStartDay - the start day of the pay period of the account object
	 */
	public Account(int pId, String pName, String pEmail, PayPeriod.PayPeriodType pPeriodType,
			PayPeriod.PeriodStartDay pStartDay) {
		this.id = pId;
		this.name = pName;
		this.email = pEmail;
		this.periodType = pPeriodType;
		this.startDay = pStartDay;
	}

	// Getters
	/**
	 * Get's the id of the account object.
	 * 
	 * @return the id of the account object
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get's the name of the account object.
	 * 
	 * @return the name of the account object
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get's the email of the account object.
	 * 
	 * @return the email of the account object
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Get's the pay period type of the account object.
	 * 
	 * @return the periodType of the account object
	 */
	public PayPeriod.PayPeriodType getPeriodType() {
		return periodType;
	}

	/**
	 * Get's the start day of the pay period of the account object.
	 * 
	 * @return the startDay of the account object
	 */
	public PayPeriod.PeriodStartDay getStartDay() {
		return startDay;
	}
}