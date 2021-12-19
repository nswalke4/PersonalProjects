package main.java.nswalke4.smallbpayroll.util;

import java.util.HashMap;

/**
 * This class contains all of the necessary information for an Employee object
 * based off of the payroll application database.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.02
 */
public class Employee {

	// Class Variables
	private final String employeeId;
	private final String firstName;
	private final String lastName;
	private final String phoneNum;
	private HashMap<String, Timecard> timecards;

	// Constructors
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
		this.timecards = new HashMap<String, Timecard>();
		this.updateTimecards();
	}

	/**
	 * Constructs an Employee object without a phone number.
	 * 
	 * @param pEmployeeId - the id of the Employee object
	 * @param pFirstName  - the first name of the Employee object
	 * @param pLastName   - the last name of the Employee object
	 */
	public Employee(String pEmployeeId, String pFirstName, String pLastName) {
		this(pEmployeeId, pFirstName, pLastName, null);
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

	/**
	 * Get's the hash map of all the timecards that are connected to the employee
	 * object using the pay period's id as the key and the timecard object as the
	 * value.
	 * 
	 * @return the HashMap of the timecards of the account object
	 */
	public HashMap<String, Timecard> getTimecards() {
		return timecards;
	}

	// Class Methods
	/**
	 * Collects all of the tuples attached to the Timecard table with the EmployeeID
	 * equal to the current employee's EmployeeID from the database, and then adds
	 * any tuple to the employees HashMap that is not already listed in it.
	 */
	public void updateTimecards() {
		// #TODO Database "Get Timecard with E.EmployeeID == T.EmployeeID"
	}
}