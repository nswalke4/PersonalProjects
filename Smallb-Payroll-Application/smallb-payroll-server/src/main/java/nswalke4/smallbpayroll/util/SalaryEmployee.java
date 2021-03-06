package nswalke4.smallbpayroll.util;

import org.json.JSONObject;

/**
 * This class represents the Salary Employee object based off of the database schema for the payroll
 * application.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.05
 */
public class SalaryEmployee extends Employee {

	// Class Variables
	private final double periodRate;

	// Constructor
	/**
	 * Creates an Salary Employee object from the given information.
	 * 
	 * @param pEmployeeId the id of the Salary Employee object
	 * @param pFirstName the first name of the Salary Employee object
	 * @param pLastName the last name of the Salary Employee object
	 * @param pPhoneNum the phone number of the Salary Employee object (can be null)
	 * @param pPeriodRate the rate of pay for a pay period of the Salary Employee object
	 */
	public SalaryEmployee(String pEmployeeId, String pFirstName, String pLastName, String pPhoneNum,
			double pPeriodRate) {
		super(pEmployeeId, pFirstName, pLastName, pPhoneNum);
		this.periodRate = pPeriodRate;
	}

	// Getter
	/**
	 * Get's the pay period rate of the Salary Employee object.
	 * 
	 * @return the periodRate of the Salary Employee object
	 */
	public double getPeriodRate() {
		return periodRate;
	}

	// Class Methods
	/**
	 * Creates a JSONObject of the Hourly Employee object using the super class's method to create
	 * the basic object, and then appends the Salary Employee's period pay rate to the object before
	 * returning it.
	 * 
	 * @return the JSONObject representation of an Salary employee
	 */
	@Override
	public JSONObject makeIntoJSONObject() {
		JSONObject result = super.makeIntoJSONObject();
		result.put("Type", "SALARY");
		result.put("PayPeriodRate", this.getPeriodRate());
		return result;
	}
}
