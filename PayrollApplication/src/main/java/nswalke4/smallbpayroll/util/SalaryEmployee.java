package main.java.nswalke4.smallbpayroll.util;

/**
 * This class represents the Salary Employee object based off of the database
 * schema for the payroll application.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.02
 */
public class SalaryEmployee extends Employee {

	// Class Variables
	private final float periodRate;

	// Constructor
	/**
	 * Creates an Salary Employee object from the given information.
	 * 
	 * @param pEmployeeId - the id of the Salary Employee object
	 * @param pFirstName  - the first name of the Salary Employee object
	 * @param pLastName   - the last name of the Salary Employee object
	 * @param pPhoneNum   - the phone number of the Salary Employee object (can be
	 *                    null)
	 * @param pPeriodRate - the rate of pay for a pay period of the Salary Employee
	 *                    object
	 */
	public SalaryEmployee(String pEmployeeId, String pFirstName, String pLastName, String pPhoneNum,
			float pPeriodRate) {
		super(pEmployeeId, pFirstName, pLastName, pPhoneNum);
		this.periodRate = pPeriodRate;
	}

	// Getter
	/**
	 * Get's the pay period rate of the Salary Employee object.
	 * 
	 * @return the periodRate of the Salary Employee object
	 */
	public float getPeriodRate() {
		return periodRate;
	}
}