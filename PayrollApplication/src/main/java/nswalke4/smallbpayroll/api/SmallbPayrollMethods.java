package main.java.nswalke4.smallbpayroll.api;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import main.java.nswalke4.smallbpayroll.util.Account;
import main.java.nswalke4.smallbpayroll.util.Employee;
import main.java.nswalke4.smallbpayroll.util.PayPeriod;
import main.java.nswalke4.smallbpayroll.util.Timecard;
import main.java.nswalke4.smallbpayroll.util.database.DatabaseQueries;

/**
 * The class contains static methods that are used in the back-end of the Smallb Payroll
 * application to gather information or add new information to the Payroll Database, and
 * return's a JSONObject that contains the results of the requested action.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.02
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
		Account account = DatabaseQueries.getSpecificAccount(accountSub);
		if (account == null) {
			result.put("Failure", "Invalid AccountSub");
			result.put("ErrorMessage", "The given \"AccountSub\" was not found tied to a valid "
					+ "Smallb Payroll Account.");
		} else {
			result.put("Account", account.makeIntoJSONObject());
		}
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
		JSONObject result = new JSONObject();
		Employee emp = DatabaseQueries.getSpecificEmployee(employeeId);
		if (emp == null) {
			result.put("Failure", "Invalid EmployeeId");
			result.put("ErrorMessage", "There were no employees found in the database matching the"
					+ " given \"EmployeeId\" parameter.");
		} else {
			result = emp.makeIntoJSONObject();
			List<Timecard> timecards = DatabaseQueries.getAllEmployeeTimecards(emp);
			JSONArray timecardArray = new JSONArray();
			for (Timecard t : timecards) {
				JSONObject timecardObj = t.makeIntoJSONObject();
				timecardArray.put(timecardObj);
			}
			result.put("Timecards", timecardArray);
		}
		return result;
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
		JSONObject result = new JSONObject();
		PayPeriod payPeriod = DatabaseQueries.getSpecificPayPeriod(payPeriodId);
		if (payPeriod == null) {
			result.put("Failure", "Invalid PayPeriodId");
			result.put("ErrorMessage", "There were no pay periods found in the database matching "
					+ "the given \"PayPeriodId\" parameter.");
		} else {
			result = payPeriod.makeIntoJSONObject();
			List<Timecard> timecards = DatabaseQueries.getAllPayPeriodTimecards(payPeriod);
			JSONArray timecardArray = new JSONArray();
			for (Timecard t : timecards) {
				JSONObject timecardObj = t.makeIntoJSONObject();
				timecardArray.put(timecardObj);
			}
			result.put("Timecards", timecardArray);
		
		}
		return result;
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
