package main.java.nswalke4.smallbpayroll.util;

import org.json.JSONObject;

/**
 * This class contains all of the necessary information for an Employee object
 * based off of the payroll application database.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.06
 */
public class Employee {

	// Class Variables
	private final String employeeId;
	private final String firstName;
	private final String lastName;
	private final String phoneNum;

	// Constructor
	/**
	 * Constructs an Employee object from the given information (includes the phone
	 * number).
	 * 
	 * @param pEmployeeId - the id of the Employee object
	 * @param pFirstName  - the first name of the Employee object
	 * @param pLastName   - the last name of the Employee object
	 * @param pPhoneNum   - the phone number of the Employee object (can be null)
	 */
	public Employee(String pEmployeeId, String pFirstName, String pLastName, String pPhoneNum) {
		this.employeeId = pEmployeeId;
		this.firstName = pFirstName;
		this.lastName = pLastName;
		this.phoneNum = pPhoneNum;
	}

	// Getters
	/**
	 * Get's the id of the Employee object.
	 * 
	 * @return the employeeId of the Employee object
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * Get's the first name of the Employee object.
	 * 
	 * @return the firstName of the Employee object
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Get's the last name of the Employee object.
	 * 
	 * @return the lastName of the Employee object
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Get's the phone number of the Employee object.
	 * 
	 * @return the phoneNum of the Employee object
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	
	// Class Methods
	/**
	 * Takes the given Employee object and turn's it into a JSONObject.
	 * 
	 * @return - a JSONObject representation of the Employee object
	 */
	public JSONObject makeIntoJSONObject() {
		JSONObject result = new JSONObject();
		result.put("EmployeeID", this.getEmployeeId());
		result.put("FirstName", this.getFirstName());
		result.put("LastName", this.getLastName());
		result.put("PhoneNum", this.getPhoneNum());
		return result;
	}
}