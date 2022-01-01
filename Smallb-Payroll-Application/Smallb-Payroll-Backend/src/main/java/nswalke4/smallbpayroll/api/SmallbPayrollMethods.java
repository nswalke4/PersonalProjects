package nswalke4.smallbpayroll.api;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import nswalke4.smallbpayroll.util.Account;
import nswalke4.smallbpayroll.util.Employee;
import nswalke4.smallbpayroll.util.PayPeriod;
import nswalke4.smallbpayroll.util.Timecard;
import nswalke4.smallbpayroll.util.PayPeriod.PayPeriodType;
import nswalke4.smallbpayroll.util.database.DatabaseQueries;

/**
 * The class contains static methods that are used in the back-end of the Smallb Payroll application
 * to gather information or add new information to the Payroll Database, and return's a JSONObject
 * that contains the results of the requested action.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.05
 */
public class SmallbPayrollMethods {

    /**
     * (NOT FOR USE) - The SmallbPayrollMethods class contains static methods to be used by the
     * SmallbPayrollApi.
     */
    public SmallbPayrollMethods() {
        System.out.println("SmallbPayrollMethods object constructed");
    }

    // Get Methods
    /**
     * Gather's the account tied to the given "accountSub" string and then generates a JSONObject
     * response with the account information.
     * 
     * @param accountSub the AWS Cognito-generated ID used to select the correct account
     * @return a JSONObject with the account information (or a message explaining why the requested
     *         method failed
     */
    protected static JSONObject gatherAccountInformation(String accountSub) {
        JSONObject result = new JSONObject();
        try {
            Account account = DatabaseQueries.getSpecificAccount(accountSub);
            if (account == null) {
                result.put("Failure", "Invalid AccountSub");
                result.put("ErrorMessage",
                        "The given 'AccountSub' was not found tied to a valid Smallb Payroll Account.");
            } else {
                result.put("Account", account.makeIntoJSONObject());
            }
        } catch (IOException ioex) {
            result.put("Failure", "Database Connection Failed");
            result.put("ErrorMessage",
                    "The connection to the database has failed for some reason.  Unable to complete the request.");
        }
        return result;
    }

    /**
     * Gather's the employee tied to the given "employeeId" string and then generates a JSONObject
     * response with the employee's timecards information.
     * 
     * @param employeeId the ID of the employee to gather the timecards for
     * @return a JSONObject with the employee's timecards information (or a message explaining why
     *         the requested method failed
     */
    protected static JSONObject gatherEmployeeTimecards(String employeeId) {
        JSONObject result = new JSONObject();
        try {
            Employee emp = DatabaseQueries.getSpecificEmployee(employeeId);
            if (emp == null) {
                result.put("Failure", "Invalid EmployeeId");
                result.put("ErrorMessage",
                        "There were no employees found in the database matching the given 'EmployeeId' parameter.");
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
        } catch (IOException ioex) {
            result.put("Failure", "Database Connection Failed");
            result.put("ErrorMessage",
                    "The connection to the database has failed for some reason.  Unable to complete the request.");
        }
        return result;
    }

    /**
     * Gather's the pay period tied to the given "payPeriodId" string and then generates a
     * JSONObject response with the pay period's timecards information.
     * 
     * @param payPeriodId the ID of the pay period to gather the timecards for
     * @return a JSONObject with the pay period's timecards information (or a message explaining why
     *         the requested method failed
     */
    protected static JSONObject gatherPayPeriodTimecards(String payPeriodId) {
        JSONObject result = new JSONObject();
        try {
            PayPeriod payPeriod = DatabaseQueries.getSpecificPayPeriod(payPeriodId);
            if (payPeriod == null) {
                result.put("Failure", "Invalid PayPeriodId");
                result.put("ErrorMessage",
                        "There were no pay periods found in the database matching the given 'PayPeriodId' parameter.");
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
        } catch (IOException ioex) {
            result.put("Failure", "Database Connection Failed");
            result.put("ErrorMessage",
                    "The connection to the database has failed for some reason.  Unable to complete the request.");
        }
        return result;
    }

    // Insert Methods
    /**
     * Attempt's to create a new Account object from the given "accountObj" JSONObject, and then
     * generates a JSONObject response with the created Account information (or a failure message).
     * 
     * @param accountSub the sub of the account that is being added to the database
     * @param accountObj a JSONObject that contains the necessary information to create a new
     *        Account
     * @return a JSONObject with the new Account information (or a message explaining why the
     *         requested method failed
     */
    protected static JSONObject createNewAccount(String accountSub, JSONObject accountObj) {
        JSONObject result = new JSONObject();
        String name = accountObj.getString("Name");
        String email = accountObj.getString("Email");
        PayPeriodType periodType = PayPeriodType.valueOf(accountObj.getString("PayPeriodType"));
        try {
            if (DatabaseQueries.addAccount(name, email, accountSub, periodType)) {
                result.put("Success", "Account Created");
            } else {
                result.put("Failure", "Unable to Create Account");
                result.put("ErrorMessage",
                        "Something went wrong when trying to create this account.");
            }
        } catch (IOException ioex) {
            result.put("Failure", "Database Connection Failed");
            result.put("ErrorMessage",
                    "The connection to the database has failed for some reason.  Unable to complete the request.");
        }
        return result;
    }

    /**
     * Attempt's to create a new Employee object from the given "newEmployee"" JSONObject, and then
     * generates a JSONObject response with the created Employee information (or a failure message).
     * 
     * @param accountSub the sub of the account that the new employee is being added to
     * @param newEmpObj a JSONObject that contains the necessary information to create a new
     *        Employee connected to the given Account
     * @return a JSONObject with the new Employee's information (or a message explaining why the
     *         requested method failed
     */
    protected static JSONObject createNewEmployee(String accountSub, JSONObject newEmpObj) {
        JSONObject result = new JSONObject();
        try {
            Account account = DatabaseQueries.getSpecificAccount(accountSub);
            String firstName = newEmpObj.getString("FirstName");
            String lastName = newEmpObj.getString("LastName");
            String empType = newEmpObj.getString("EmpType");
            String phoneNum = null;
            if (newEmpObj.has("PhoneNum")) {
                phoneNum = newEmpObj.getString("PhoneNum");
            }
            Double payRate = newEmpObj.getDouble("PayRate");
            if (empType.equalsIgnoreCase("hourly")) {
                if (DatabaseQueries.addHourlyEmployee(account, firstName, lastName, phoneNum,
                        payRate)) {
                    result.put("Success", "Hourly Employee Created");
                } else {
                    result.put("Failure", "Unable to Create Employee");
                    result.put("ErrorMessage",
                            "Something went wrong with trying to create this " + "employee.");
                }
            } else {
                if (DatabaseQueries.addSalaryEmployee(account, firstName, lastName, phoneNum,
                        payRate)) {
                    result.put("Success", "Salary Employee Created");
                } else {
                    result.put("Failure", "Unable to Create Employee");
                    result.put("ErrorMessage",
                            "Something went wrong with trying to create this " + "employee.");
                }
            }
        } catch (IOException ioex) {
            result.put("Failure", "Database Connection Failed");
            result.put("ErrorMessage",
                    "The connection to the database has failed for some reason.  Unable to complete the request.");
        }
        return result;
    }

    /**
     * Attempt's to create a new PayPeriod object from the given "periodStartDate" String, and then
     * generates a JSONObject response with the created Pay Period information (or a failure
     * message).
     * 
     * @param accountSub the sub of the account that the new pay period is being added to
     * @param periodStartDate the date that the pay period will start on
     * @return a JSONObject with the new PayPeriod's information (or a message explaining why the
     *         requested method failed
     */
    protected static JSONObject createNewPayPeriod(String accountSub, String periodStartDate) {
        JSONObject result = new JSONObject();
        try {
            Account account = DatabaseQueries.getSpecificAccount(accountSub);
            Date startDate = Date.valueOf(periodStartDate);
            if (DatabaseQueries.addPayPeriod(account, startDate)) {
                result.put("Success", "Pay Period Created");
            } else {
                result.put("Failure", "Unable to Create Pay Period");
                result.put("ErrorMessage",
                        "Something went wrong with trying to create this " + "pay period.");
            }
        } catch (IOException ioex) {
            result.put("Failure", "Database Connection Failed");
            result.put("ErrorMessage",
                    "The connection to the database has failed for some reason.  Unable to complete the request.");
        }
        return result;
    }

    /**
     * Attempt's to create a new Timecard object from the given "TimecardInfo" JSONObject , and then
     * generates a JSONObject response with the created Timecard information (or a failure message).
     * 
     * @param accountSub the sub of the account that the new employee is being added to
     * @param timecardObj a JSONObject that contains the necessary information to create a new
     *        Timecard connected to the given Account
     * @return a JSONObject with the new Timecard information (or a message explaining why the
     *         requested method failed
     */
    protected static JSONObject createNewTimecard(String accountSub, JSONObject timecardObj) {
        JSONObject result = new JSONObject();
        try {
            Account account = DatabaseQueries.getSpecificAccount(accountSub);
            String empId = timecardObj.getString("EmployeeId");
            String payPeriodId = timecardObj.getString("PeriodId");
            Double regHrs = timecardObj.getDouble("RegularHours");
            Double overHrs = timecardObj.getDouble("OvertimeHours");
            Double bonus = timecardObj.getDouble("BonusPay");
            Double other = timecardObj.getDouble("OtherPay");
            System.out.println(account.makeIntoJSONObject());
            if (DatabaseQueries.addTimecard(account, empId, payPeriodId, regHrs, overHrs, bonus,
                    other)) {
                result.put("Success", "Timecard Created");
            } else {
                result.put("Failure", "Unable to Create Timecard");
                result.put("ErrorMessage",
                        "Something went wrong with trying to create this " + "timecard.");
            }
        } catch (IOException ioex) {
            result.put("Failure", "Database Connection Failed");
            result.put("ErrorMessage",
                    "The connection to the database has failed for some reason.  Unable to complete the request.");
        }
        return result;
    }
}
