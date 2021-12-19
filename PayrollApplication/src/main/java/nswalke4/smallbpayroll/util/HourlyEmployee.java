package main.java.nswalke4.smallbpayroll.util;

/**
 * This class represents an Hourly Employee object based off of the database
 * schema for the payroll application.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.02
 */
public class HourlyEmployee extends Employee {

	// Class Variables
	private final float rate;

	// Constructor
	/**
	 * Creates an Hourly Employee object from the given information.
	 * 
	 * @param pEmployeeId - the id of the Hourly Employee object
	 * @param pFirstName  - the first name of the Hourly Employee object
	 * @param pLastName   - the last name of the Hourly Employee object
	 * @param pPhoneNum   - the phone number of the Hourly Employee object (can be
	 *                    null)
	 * @param pRate       - the pay rate of the Hourly Employee object
	 */
	public HourlyEmployee(String pEmployeeId, String pFirstName, String pLastName, String pPhoneNum, float pRate) {
		super(pEmployeeId, pFirstName, pLastName, pPhoneNum);
		this.rate = pRate;
	}

	// Getter
	/**
	 * Get's the pay rate of the Hourly Employee object.
	 * 
	 * @return the rate of the Hourly Employee object
	 */
	public float getRate() {
		return rate;
	}
}