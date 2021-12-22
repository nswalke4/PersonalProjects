package main.java.nswalke4.smallbpayroll.api;

import org.json.JSONObject;

/**
 * The class contains static methods that are used in the back-end of the Smallb Payroll
 * application to gather information or add new information to the Payroll Database, and
 * return's a JSONObject that contains the results of the requested action.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.01
 */
public class SmallbPayrollMethods {
	
	/**
	 * Gather's the account tied to the given "accountSub" string and then generates a
	 * JSONObject response with the account information.
	 * 
	 * @param accountSub - the AWS Cognito-generated ID used to select the correct account
	 * @return - a JSONObject with the account information (or a message explaining why the
	 *           requested method failed
	 */
	protected static JSONObject gatherAccountInformation(String accountSub) {
		JSONObject result = new JSONObject();
		// #TODO Gather information about the account and attached tables to create a JSONObject
		return result;
	}

	/**
	 * Gather's the employee tied to the given "employeeId" string and then generates a
	 * JSONObject response with the employee's timecards information.
	 * 
	 * @param employeeId - the ID of the employee to gather the timecards for
	 * @return - a JSONObject with the employee's timecards information (or a message explaining
	 *           why the requested method failed
	 */
	protected static JSONObject gatherEmployeeTimecards(String employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Gather's the pay period tied to the given "payPeriodId" string and then generates a
	 * JSONObject response with the pay period's timecards information.
	 * 
	 * @param payPeriodId - the ID of the pay period to gather the timecards for
	 * @return - a JSONObject with the pay period's timecards information (or a message explaining
	 *           why the requested method failed
	 */
	protected static JSONObject gatherPayPeriodTimecards(String payPeriodId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Attempt's to create a new Account object from the given "accountObj" JSONObject, and then
	 * generates a JSONObject response with the created Account information (or a failure message).
	 * 
	 * @param accountObj - a JSONObject that contains the necessary information to create a new
	 *                     Account
	 * @return - a JSONObject with the new Account information (or a message explaining why the
	 *           requested method failed
	 */
	protected static JSONObject createNewAccount(JSONObject accountObj) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Attempt's to create a new Employee object from the given "requestObj" JSONObject (which has
	 * an "AccountSub" string to signify which account the employee belongs to and a "NewEmployee"
	 * object that contains the employee's information), and then generates a JSONObject response
	 * with the created Employee information (or a failure message).
	 * 
	 * @param requestObj - a JSONObject that contains the necessary information to create a new
	 *                     Employee connected to the given Account
	 * @return - a JSONObject with the new Employee's information (or a message explaining why the
	 *           requested method failed
	 */
	protected static JSONObject createNewEmployee(JSONObject requestObj) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Attempt's to create a new PayPeriod object from the given "requestObj" JSONObject (which has
	 * an "AccountSub" string to signify which account the pay period belongs to and a
	 * "PeriodStartDate" date), and then generates a JSONObject response with the created Pay Period
	 * information (or a failure message).
	 * 
	 * @param requestObj - a JSONObject that contains the necessary information to create a new
	 *                     Pay Period connected to the given Account
	 * @return - a JSONObject with the new PayPeriod's information (or a message explaining why the
	 *           requested method failed
	 */
	protected static JSONObject createNewPayPeriod(JSONObject requestObj) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Attempt's to create a new Timecard object from the given "requestObj" JSONObject (which has
	 * an "AccountSub" string to signify which account the timecard belongs to and a "TimecardInfo"
	 * object that contains the timecard's information), and then generates a JSONObject response
	 * with the created Timecard information (or a failure message).
	 * 
	 * @param requestObj - a JSONObject that contains the necessary information to create a new
	 *                     Timecard connected to the given Account
	 * @return - a JSONObject with the new Timecard information (or a message explaining why the
	 *           requested method failed
	 */
	protected static JSONObject createNewTimecard(JSONObject requestObj) {
		// TODO Auto-generated method stub
		return null;
	}

}
