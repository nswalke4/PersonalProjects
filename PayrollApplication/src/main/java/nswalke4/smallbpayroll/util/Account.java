package main.java.nswalke4.smallbpayroll.util;

import java.util.HashMap;

/**
 * This class contains the Account object that is used in the database for the
 * Payroll application.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.02
 */
public class Account {

	// Class Variables
	private final int id;
	private final String name;
	private final String email;
	private final PayPeriod.PayPeriodType periodType;
	private final PayPeriod.PeriodStartDay startDay;
	private HashMap<String, Employee> employees;
	private HashMap<String, PayPeriod> payPeriods;

	// Constructor
	/**
	 * Create's an Account object based off of the given information.
	 * 
	 * @param pId         - the id of the account object
	 * @param pName       - the name of the account object
	 * @param pEmail      - the email of the account object
	 * @param pPeriodType - the pay period type of the account object
	 * @param pStartDay   - the start day of the pay period of the account object
	 */
	public Account(int pId, String pName, String pEmail, PayPeriod.PayPeriodType pPeriodType,
			PayPeriod.PeriodStartDay pStartDay) {
		this.id = pId;
		this.name = pName;
		this.email = pEmail;
		this.periodType = pPeriodType;
		this.startDay = pStartDay;
		this.employees = new HashMap<String, Employee>();
		this.updateEmployees();
		this.payPeriods = new HashMap<String, PayPeriod>();
		this.updatePayPeriods();
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

	/**
	 * Get's the hash map of all employees that are connected to the account object
	 * using the employee's id as the key and the employee object as the value.
	 * 
	 * @return the HashMap of the employees of the account object
	 */
	public HashMap<String, Employee> getEmployees() {
		return employees;
	}

	/**
	 * Get's the hash map of all the pay periods that are connected to the account
	 * object using the pay period's id as the key and the PayPeriod object as the
	 * value.
	 * 
	 * @return the HashMap of the pay periods of the account object
	 */
	public HashMap<String, PayPeriod> getPayPeriods() {
		return payPeriods;
	}

	// Class Methods
	/**
	 * Generates an employee ID number using the account ID and the number of
	 * employees that the account has, up to 9999 employees. Style:
	 * "[AccountID]-E-[# of Employees, with leading zeros to make 4 digits]"
	 * 
	 * @return - the generated EmployeeID string
	 */
	public String generateEmployeeID() {
		String empId = String.valueOf(this.id);
		empId += "-E-";
		int empNum = 1;
		if (!employees.isEmpty()) {
			empNum += employees.size();
		}
		if (empNum < 10) {
			empId += "000";
		} else if (empNum < 100) {
			empId += "00";
		} else if (empNum < 1000) {
			empId += "0";
		} else {
		}
		empId += String.valueOf(empNum);
		return empId;
	}

	/**
	 * Generates a pay period ID number using the account ID and the number of pay
	 * periods that the account has, up to 9999 pay periods. Style:
	 * "[AccountID]-P-[# of PayPeriods, with leading zeros to make 4 digits]"
	 * 
	 * @return - the generated PayPeriodID string
	 */
	public String generatePayPeriodID() {
		String ppId = String.valueOf(this.id);
		ppId += "-P-";
		int ppNum = 1;
		if (!payPeriods.isEmpty()) {
			ppNum += payPeriods.size();
		}
		if (ppNum < 10) {
			ppId += "000";
		} else if (ppNum < 100) {
			ppId += "00";
		} else if (ppNum < 1000) {
			ppId += "0";
		} else {
		}
		ppId += String.valueOf(ppNum);
		return ppId;
	}

	/**
	 * Collects all of the tuples attached to the Employee table with the AccountID
	 * equal to the current account's AccountID from the database, and then adds any
	 * tuple to the employees HashMap that is not already listed in it.
	 */
	public void updateEmployees() {
		// #TODO Database "Get Employees with A.AccountID == E.AccountID"
	}

	/**
	 * Collects all of the tuples attached to the PayPeriod table with the AccountID
	 * equal to the current account's AccountID from the database, and then adds any
	 * tuple to the payPeriods HashMap that is not already listed in it.
	 */
	public void updatePayPeriods() {
		// #TODO Database "Get PayPeriods with A.AccountID == P.AccountID"
	}
}