package nswalke4.smallbpayroll.util;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import nswalke4.smallbpayroll.util.database.DatabaseQueries;

/**
 * This class contains the Account object that is used in the database for the Payroll application.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.08
 */
public class Account {

	// Class Variables
	private final int id;
	private final String name;
	private final String email;
	private final String sub;
	private final PayPeriod.PayPeriodType periodType;
	private HashMap<String, Employee> employees;
	private HashMap<String, PayPeriod> payPeriods;

	// Constructor
	/**
	 * Create's an Account object based off of the given information.
	 * 
	 * @param pId - the id of the account object
	 * @param pName - the name of the account object
	 * @param pEmail - the email of the account object
	 * @param pPeriodType - the pay period type of the account object
	 */
	public Account(int pId, String pName, String pEmail, String pSub,
			PayPeriod.PayPeriodType pPeriodType) {
		this.id = pId;
		this.name = pName;
		this.email = pEmail;
		this.sub = pSub;
		this.periodType = pPeriodType;
		this.employees = new HashMap<String, Employee>();
		this.payPeriods = new HashMap<String, PayPeriod>();
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
	 * Get's the sub (which is the AWS Cognito id) of the account object.
	 * 
	 * @return the sub of the account object
	 */
	public String getSub() {
		return sub;
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
	 * Get's the hash map of all employees that are connected to the account object using the
	 * employee's id as the key and the employee object as the value.
	 * 
	 * @return the HashMap of the employees of the account object
	 */
	public HashMap<String, Employee> getEmployees() {
		this.updateEmployees();
		return employees;
	}

	/**
	 * Get's the hash map of all the pay periods that are connected to the account object using the
	 * pay period's id as the key and the PayPeriod object as the value.
	 * 
	 * @return the HashMap of the pay periods of the account object
	 */
	public HashMap<String, PayPeriod> getPayPeriods() {
		this.updatePayPeriods();
		return payPeriods;
	}

	// Class Methods
	/**
	 * Generates an employee ID number using the account ID and the number of employees that the
	 * account has, up to 9999 employees. Style: "[AccountID]-E-[# of Employees, with leading zeros
	 * to make 4 digits]"
	 * 
	 * @return - the generated EmployeeID string
	 */
	public String generateEmployeeID() {
		String empId = String.valueOf(this.id);
		empId += "-E-";
		int empNum = DatabaseQueries.getNumEmployees(this) + 1;
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
	 * Generates the end date of a PayPeriod by using the given start date and the account's
	 * information about the type of PayPeriod it uses to calculate the PayPeriod's end date.
	 * 
	 * @param startDate - the date that the PayPeriod begins
	 * @return - the last day of the PayPeriod (is included in the period)
	 */
	public Date generateEndDate(Date startDate) {
		int numDaysToIncrement = 0;
		switch (this.periodType) {
			case WEEKLY:
				numDaysToIncrement = 6;
				break;
			case BIWEEKLY:
				numDaysToIncrement = 13;
				break;
			default:
				numDaysToIncrement = 1;
				break;
		}
		LocalDate endLocalDate = startDate.toLocalDate().plusDays(numDaysToIncrement);
		return Date.valueOf(endLocalDate);
	}

	/**
	 * Generates a pay period ID number using the account ID and the number of pay periods that the
	 * account has, up to 9999 pay periods. Style: "[AccountID]-P-[# of PayPeriods, with leading
	 * zeros to make 4 digits]"
	 * 
	 * @return - the generated PayPeriodID string
	 */
	public String generatePayPeriodID() {
		String ppId = String.valueOf(this.id);
		ppId += "-P-";
		int ppNum = DatabaseQueries.getNumPayPeriods(this) + 1;
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
	 * Collects all of the tuples attached to the Employee table with the AccountID equal to the
	 * current account's AccountID from the database, and then adds any tuple to the employees
	 * HashMap that is not already listed in it.
	 */
	private void updateEmployees() {
		List<Employee> empList = DatabaseQueries.getEmployees(this);
		for (Employee e : empList) {
			if (!employees.containsKey(e.getEmployeeId())) {
				employees.put(e.getEmployeeId(), e);
			}
		}
	}

	/**
	 * Collects all of the tuples attached to the PayPeriod table with the AccountID equal to the
	 * current account's AccountID from the database, and then adds any tuple to the payPeriods
	 * HashMap that is not already listed in it.
	 */
	private void updatePayPeriods() {
		List<PayPeriod> payPeriodList = DatabaseQueries.getPayPeriods(this);
		for (PayPeriod p : payPeriodList) {
			if (!payPeriods.containsKey(p.getPeriodId())) {
				payPeriods.put(p.getPeriodId(), p);
			}
		}
	}

	/**
	 * Collects all of the information about the Account object and then creates a JSONObject
	 * representation of all of that information (including the basic info about the Account object
	 * [excluding the AccountSub], basic info about all of the Employees tied to this account, and
	 * basic info about all of the PayPeriods tied to this account.
	 * 
	 * @return - a JSONObject representation of an Account object as well as all of its Employees
	 *         and PayPeriods
	 */
	public JSONObject makeIntoJSONObject() {
		JSONObject result = new JSONObject();
		result.put("ID", this.getId());
		result.put("Name", this.getName());
		result.put("Email", this.getEmail());
		result.put("PeriodType", this.getPeriodType());
		JSONArray employeesArray = new JSONArray();
		for (HashMap.Entry<String, Employee> empMap : this.getEmployees().entrySet()) {
			employeesArray.put(empMap.getValue().makeIntoJSONObject());
		}
		result.put("Employees", employeesArray);
		JSONArray payPeriodsArray = new JSONArray();
		for (HashMap.Entry<String, PayPeriod> payPeriodMap : this.getPayPeriods().entrySet()) {
			payPeriodsArray.put(payPeriodMap.getValue().makeIntoJSONObject());
		}
		result.put("PayPeriods", payPeriodsArray);
		return result;
	}
}
