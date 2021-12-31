package nswalke4.smallbpayroll.util;

import org.json.JSONObject;

/**
 * This class represents an Hourly Employee object based off of the database schema for the payroll
 * application.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.04
 */
public class HourlyEmployee extends Employee {

	// Class Variables
	private final double rate;

	// Constructor
	/**
	 * Creates an Hourly Employee object from the given information.
	 * 
	 * @param pEmployeeId - the id of the Hourly Employee object
	 * @param pFirstName - the first name of the Hourly Employee object
	 * @param pLastName - the last name of the Hourly Employee object
	 * @param pPhoneNum - the phone number of the Hourly Employee object (can be null)
	 * @param pRate - the pay rate of the Hourly Employee object
	 */
	public HourlyEmployee(String pEmployeeId, String pFirstName, String pLastName, String pPhoneNum,
			double pRate) {
		super(pEmployeeId, pFirstName, pLastName, pPhoneNum);
		this.rate = pRate;
	}

	// Getter
	/**
	 * Get's the pay rate of the Hourly Employee object.
	 * 
	 * @return the rate of the Hourly Employee object
	 */
	public double getRate() {
		return rate;
	}

	// Class Methods
	/**
	 * Creates a JSONObject of the Hourly Employee object using the super class's method to create
	 * the basic object, and then appends the Hourly Employee's pay rate to the object before
	 * returning it.
	 * 
	 * @return - the JSONObject representation of an Hourly employee
	 */
	@Override
	public JSONObject makeIntoJSONObject() {
		JSONObject result = super.makeIntoJSONObject();
		result.put("HourlyRate", this.getRate());
		return result;
	}
}
