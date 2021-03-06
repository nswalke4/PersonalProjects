package nswalke4.smallbpayroll.util.database;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nswalke4.smallbpayroll.util.Account;
import nswalke4.smallbpayroll.util.Employee;
import nswalke4.smallbpayroll.util.HourlyEmployee;
import nswalke4.smallbpayroll.util.PayPeriod;
import nswalke4.smallbpayroll.util.SalaryEmployee;
import nswalke4.smallbpayroll.util.Timecard;

/**
 * This class is an static class, giving the users the ability to access any of these commands
 * without the necessity of creating a "DatabaseQueries" object. This handles the entire
 * communication process with the database to ensure that the query/insertion is handled properly,
 * and only opens/closes the connection for that specific query/ insertion to be sent through,
 * keeping the connection time as minimal as possible.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.12
 */
public class DatabaseQueries {

	/**
	 * (NOT FOR USE) - The DatabaseQueries class contains static methods to be used by the
	 * SmallbPayrollApi to access and gather/add information from/to the database through only one
	 * command.
	 */
	public DatabaseQueries() {
		System.out.println("DatabaseQueries object constructed");
	}

	// Insertion Methods
	/**
	 * Inserts the given information into the database as a new Account tuple. NOTE: This does not
	 * check if the insertion worked properly...
	 * 
	 * @param name the business name / name of the account object/tuple
	 * @param email the email associated with the account
	 * @param sub the AWS Cognito generated sub (id) to signify the account being used
	 * @param periodType the type of PayPeriod the account uses
	 * @return (T or F) the account was successfully added to the database
	 * @throws IOException
	 */
	public static boolean addAccount(String name, String email, String sub,
			PayPeriod.PayPeriodType periodType) throws IOException {
		String insert = "INSERT INTO Account (Name, Email, Account_Sub, Pay_Period) VALUES (\""
				+ name + "\", \"" + email + "\", \"" + sub + "\", \"" + periodType + "\");";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getWriteDb());
		int insertedRows = db.executeBasicUpdate(insert);
		db.closeConnection();
		if (insertedRows == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Inserts the given information plus the calculated employeeId into the database as a new
	 * Employee and Hourly_Employee tuple that should be attached to the given Account object. NOTE:
	 * This does not check if the insertion worked properly...
	 * 
	 * @param account the account to insert the employee into
	 * @param firstName the first name of the employee
	 * @param lastName the last name of the employee
	 * @param phoneNum the phone number of the employee
	 * @param payRate the pay rate of the hourly employee
	 * @return (T or F) the hourly employee was successfully added to the database
	 * @throws IOException
	 */
	public static boolean addHourlyEmployee(Account account, String firstName, String lastName,
			String phoneNum, double payRate) throws IOException {
		String empId = account.generateEmployeeID();
		String insertEmp =
				"INSERT INTO Employee VALUES (" + account.getId() + ", \"" + empId + "\", \""
						+ firstName + "\", \"" + lastName + "\", \"" + phoneNum + "\", 'HOURLY');";
		String insertHrly = "INSERT INTO Hourly_Employee VALUES (" + account.getId() + ", \""
				+ empId + "\", " + payRate + ");";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getWriteDb());
		int insertedRows = 0;
		insertedRows += db.executeBasicUpdate(insertEmp);
		insertedRows += db.executeBasicUpdate(insertHrly);
		db.closeConnection();
		if (insertedRows == 2) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Inserts the given information plus the calculated employeeId into the database as a new
	 * Employee and Salary_Employee tuple that should be attached to the given Account object. NOTE:
	 * This does not check if the insertion worked properly...
	 * 
	 * @param account the account to insert the employee into
	 * @param firstName the first name of the employee
	 * @param lastName the last name of the employee
	 * @param phoneNum the phone number of the employee
	 * @param payRate the pay rate of the salary employee
	 * @return (T or F) the salary employee was successfully added to the database
	 * @throws IOException
	 */
	public static boolean addSalaryEmployee(Account account, String firstName, String lastName,
			String phoneNum, double payRate) throws IOException {
		String empId = account.generateEmployeeID();
		String insertEmp =
				"INSERT INTO Employee VALUES (" + account.getId() + ", \"" + empId + "\", \""
						+ firstName + "\", \"" + lastName + "\", \"" + phoneNum + "\", 'SALARY');";
		String insertSlry = "INSERT INTO Salary_Employee VALUES (" + account.getId() + ", \""
				+ empId + "\", " + payRate + ");";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getWriteDb());
		int insertedRows = 0;
		insertedRows += db.executeBasicUpdate(insertEmp);
		insertedRows += db.executeBasicUpdate(insertSlry);
		db.closeConnection();
		if (insertedRows == 2) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Inserts the given information plus the calculated endDate into the database as a new
	 * PayPeriod tuple that should be attached to the given Account object. NOTE: This does not
	 * check if the insertion worked properly...
	 * 
	 * @param account the account to attach the payPeriod to
	 * @param startDate the start date of the payPeriod
	 * @return (T or F) the pay period was successfully added to the database
	 * @throws IOException
	 */
	public static boolean addPayPeriod(Account account, Date startDate) throws IOException {
		String periodId = account.generatePayPeriodID();
		Date endDate = account.generateEndDate(startDate);
		String insert = "INSERT INTO Pay_Period VALUES (" + account.getId() + ", \"" + periodId
				+ "\", '" + startDate + "', '" + endDate + "');";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getWriteDb());
		int insertedRows = db.executeBasicUpdate(insert);
		db.closeConnection();
		if (insertedRows == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Inserts the given information into the database as a new Timecard tuple that should be
	 * attached to the given Account, Employee, and PayPeriod object. NOTE: This does not check if
	 * the insertion worked properly...
	 * 
	 * @param account the account to attach the timecard to
	 * @param employeeId the id of the employee to attach the timecard to
	 * @param payPeriodId the id of the payPeriod to attach the timercard to
	 * @param regHours the number of regular hours worked (used by 'hourly')
	 * @param overtimeHours the number of overtime hours worked (used by 'hourly')
	 * @param bonusPay the amount of bonusPay given to the employee
	 * @param otherPay the amount of otherPay given to the employee
	 * @return (T or F) the timecard was successfully added to the database
	 * @throws IOException
	 */
	public static boolean addTimecard(Account account, String employeeId, String payPeriodId,
			double regHours, double overtimeHours, double bonusPay, double otherPay)
			throws IOException {
		String insert = "INSERT INTO Timecard VALUES (" + account.getId() + ", \"" + employeeId
				+ "\", \"" + payPeriodId + "\", " + regHours + ", " + overtimeHours + ", "
				+ bonusPay + ", " + otherPay + ");";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getWriteDb());
		int insertedRows = db.executeBasicUpdate(insert);
		db.closeConnection();
		if (insertedRows == 1) {
			return true;
		} else {
			return false;
		}
	}

	// Query Methods
	/**
	 * Queries the database to gather all of the accounts tied to the database, creates Account
	 * Objects for each of them, and then returns an ArrayList of all of those Accounts.
	 * 
	 * @return the ArrayList of all of the Account tuples in the database
	 * @throws IOException
	 */
	public static List<Account> getAllAccounts() throws IOException {
		List<Account> result = new ArrayList<Account>();
		String query = "SELECT * FROM Account;";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getReadDb());
		ResultSet rs = db.executeBasicQuery(query);
		try {
			while (rs.next()) {
				Account act = new Account(rs.getInt("Account_Id"), rs.getString("Name"),
						rs.getString("Email"), rs.getString("Account_Sub"),
						PayPeriod.PayPeriodType.valueOf(rs.getString("Pay_Period")));
				result.add(act);
			}
		} catch (SQLException sqlex) {
			System.out.println(
					"[FAILURE] Something went wrong while trying to read the " + "results...");
			sqlex.printStackTrace();
		}
		db.closeConnection();
		return result;
	}

	/**
	 * Queries the database to gather a specific account using the account's sub (which is generated
	 * by the AWS Cognito sign-in page) as the lookup parameter from the Payroll database.
	 * 
	 * @param sub the AWS Cognito generated "sub" id to lookup the account tuple
	 * @return the Account object that matches the given "sub" in the database
	 * @throws IOException
	 */
	public static Account getSpecificAccount(String sub) throws IOException {
		Account result = null;
		String query = "SELECT * FROM Account AS A WHERE A.Account_Sub = \"" + sub + "\";";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getReadDb());
		ResultSet rs = db.executeBasicQuery(query);
		try {
			while (rs.next()) {
				result = new Account(rs.getInt("Account_Id"), rs.getString("Name"),
						rs.getString("Email"), rs.getString("Account_Sub"),
						PayPeriod.PayPeriodType.valueOf(rs.getString("Pay_Period")));
			}
		} catch (SQLException sqlex) {
			System.out.println(
					"[FAILURE] Something went wrong while trying to read the " + "results...");
			sqlex.printStackTrace();
		}
		db.closeConnection();
		return result;
	}

	/**
	 * Queries the database to gather the number of Employee accounts attached to the given Account
	 * and returns the result.
	 * 
	 * @param account the Account object that the employees are tied to
	 * @return an integer representing the number of Employees the account has
	 * @throws IOException
	 */
	public static int getNumEmployees(Account account) throws IOException {
		int result = 0;
		String query = "SELECT COUNT(*) AS Emp_Count FROM Employee WHERE Account_Id = "
				+ account.getId() + ";";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getReadDb());
		ResultSet rs = db.executeBasicQuery(query);
		try {
			while (rs.next()) {
				result = rs.getInt("Emp_Count");
			}
		} catch (SQLException sqlex) {
			System.out.println(
					"[FAILURE] Something went wrong while trying to read the " + "results...");
			sqlex.printStackTrace();
		}
		db.closeConnection();
		return result;
	}

	/**
	 * Queries the database to gather all of the Employee accounts attached to the given Account,
	 * creates the HourlyEmployee or SalaryEmployee object representation based on the "emp_type"
	 * attribute, and then adds each employee to an ArrayList to be returned as the result.
	 * 
	 * @param account the Account object that the employees are tied to
	 * @return an ArrayList of all of the employees attached to the given account
	 * @throws IOException
	 */
	public static List<Employee> getEmployees(Account account) throws IOException {
		List<Employee> result = new ArrayList<Employee>();
		String query = "SELECT * FROM ((Employee AS E LEFT JOIN Hourly_Employee AS H ON E.Emp_Id = "
				+ "H.Emp_Id) LEFT JOIN Salary_Employee AS S ON E.Emp_Id = S.Emp_Id)"
				+ "WHERE E.Account_Id = " + account.getId() + ";";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getReadDb());
		ResultSet rs = db.executeBasicQuery(query);
		try {
			while (rs.next()) {
				Employee emp = null;
				if (rs.getString("Emp_Type").equalsIgnoreCase("hourly")) {
					emp = new HourlyEmployee(rs.getString("Emp_Id"), rs.getString("First_Name"),
							rs.getString("Last_Name"), rs.getString("Phone_Num"),
							rs.getDouble("Rate"));
				} else {
					emp = new SalaryEmployee(rs.getString("Emp_Id"), rs.getString("First_Name"),
							rs.getString("Last_Name"), rs.getString("Phone_Num"),
							rs.getDouble("Period_Rate"));
				}
				result.add(emp);
			}
		} catch (SQLException sqlex) {
			System.out.println(
					"[FAILURE] Something went wrong while trying to read the " + "results...");
			sqlex.printStackTrace();
		}
		db.closeConnection();
		return result;
	}

	/**
	 * Queries the database to gather the number of Pay Periods that are attached to the given
	 * Account and returns the result.
	 * 
	 * @param account the Account object that the pay periods are tied to
	 * @return an integer representing the number of pay periods the account has
	 * @throws IOException
	 */
	public static int getNumPayPeriods(Account account) throws IOException {
		int result = 0;
		String query = "SELECT COUNT(*) AS Pay_Period_Count FROM Pay_Period WHERE Account_Id = "
				+ account.getId() + ";";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getReadDb());
		ResultSet rs = db.executeBasicQuery(query);
		try {
			while (rs.next()) {
				result = rs.getInt("Pay_Period_Count");
			}
		} catch (SQLException sqlex) {
			System.out.println(
					"[FAILURE] Something went wrong while trying to read the " + "results...");
			sqlex.printStackTrace();
		}
		db.closeConnection();
		return result;
	}

	/**
	 * Queries the database to gather all of the different Pay Periods associated with the given
	 * account, creates PayPeriod object for each of the tuples, and then returns an array list of
	 * all of those PayPeriod objects.
	 * 
	 * @param account the account that the PayPeriods are tied to
	 * @return an ArrayList of PayPeriods that are all attached to the given account
	 * @throws IOException
	 */
	public static List<PayPeriod> getPayPeriods(Account account) throws IOException {
		List<PayPeriod> result = new ArrayList<PayPeriod>();
		String query = "SELECT * FROM Pay_Period WHERE Account_Id = " + account.getId() + ";";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getReadDb());
		ResultSet rs = db.executeBasicQuery(query);
		try {
			while (rs.next()) {
				PayPeriod period = new PayPeriod(rs.getString("Period_Id"),
						rs.getDate("Start_Date"), rs.getDate("End_Date"));
				result.add(period);
			}
		} catch (SQLException sqlex) {
			System.out.println(
					"[FAILURE] Something went wrong while trying to read the " + "results...");
			sqlex.printStackTrace();
		}
		db.closeConnection();
		return result;
	}

	/**
	 * Queries the database to gather a specific employee using the given "employeeId" string to
	 * find the specific employee, and then return's the given hourly or salary employee object.
	 * 
	 * @param employeeId the id of the employee to find in the database
	 * @return the Employee object tied to the given employeeId string (or null)
	 * @throws IOException
	 */
	public static Employee getSpecificEmployee(String employeeId) throws IOException {
		Employee result = null;
		String query = "SELECT * FROM ((Employee AS E LEFT JOIN Hourly_Employee AS H ON E.Emp_Id = "
				+ "H.Emp_Id) LEFT JOIN Salary_Employee AS S ON E.Emp_Id = S.Emp_Id)"
				+ "WHERE E.Emp_Id = \"" + employeeId + "\";";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getReadDb());
		ResultSet rs = db.executeBasicQuery(query);
		try {
			while (rs.next()) {
				if (rs.getString("Emp_Type").equalsIgnoreCase("hourly")) {
					result = new HourlyEmployee(rs.getString("Emp_Id"), rs.getString("First_Name"),
							rs.getString("Last_Name"), rs.getString("Phone_Num"),
							rs.getDouble("Rate"));
				} else {
					result = new SalaryEmployee(rs.getString("Emp_Id"), rs.getString("First_Name"),
							rs.getString("Last_Name"), rs.getString("Phone_Num"),
							rs.getDouble("Period_Rate"));
				}
			}
		} catch (SQLException sqlex) {
			System.out.println(
					"[FAILURE] Something went wrong while trying to read the " + "results...");
			sqlex.printStackTrace();
		}
		db.closeConnection();
		return result;
	}

	/**
	 * Queries the database to gather the number of Timecards that are attached to the given
	 * Employee and returns the result.
	 * 
	 * @param employee the Employee object that the timecards are tied to
	 * @return an integer representing the number of timecards the employee has
	 * @throws IOException
	 */
	public static int getNumEmployeeTimecards(Employee employee) throws IOException {
		int result = 0;
		String query = "SELECT COUNT(*) AS Timecard_Count FROM Timecard WHERE Emp_Id = "
				+ employee.getEmployeeId() + ";";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getReadDb());
		ResultSet rs = db.executeBasicQuery(query);
		try {
			while (rs.next()) {
				result = rs.getInt("Timecard_Count");
			}
		} catch (SQLException sqlex) {
			System.out.println(
					"[FAILURE] Something went wrong while trying to read the " + "results...");
			sqlex.printStackTrace();
		}
		db.closeConnection();
		return result;
	}

	/**
	 * Queries the database to gather all of the timecard tuples attached to the given employee,
	 * creates new Timecard object for each of the tuples, and then returns an ArrayList of all of
	 * the Timecards attached to the given employee.
	 * 
	 * @param employee the employee to gather all Timecards from
	 * @return an ArrayList of all of the Timecards attached to the given employee
	 * @throws IOException
	 */
	public static List<Timecard> getAllEmployeeTimecards(Employee employee) throws IOException {
		List<Timecard> result = new ArrayList<Timecard>();
		String query =
				"SELECT * FROM Timecard WHERE Emp_Id = \"" + employee.getEmployeeId() + "\";";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getReadDb());
		ResultSet rs = db.executeBasicQuery(query);
		try {
			while (rs.next()) {
				Timecard tc = new Timecard(rs.getString("Emp_Id"), rs.getString("Period_Id"),
						rs.getDouble("Regular_Hours"), rs.getDouble("Overtime_Hours"),
						rs.getDouble("Bonus_Pay"), rs.getDouble("Other_Pay"));
				result.add(tc);
			}
		} catch (SQLException sqlex) {
			System.out.println(
					"[FAILURE] Something went wrong while trying to read the " + "results...");
			sqlex.printStackTrace();
		}
		db.closeConnection();
		return result;
	}

	/**
	 * Queries the database to gather a specific pay period using the give "payPeriodId" string to
	 * find the specific pay period, and then return's the pay period object.
	 * 
	 * @param payPeriodId the id of the pay period to find in the database
	 * @return the PayPeriod object tied to the given payPeriodId string (or null)
	 * @throws IOException
	 */
	public static PayPeriod getSpecificPayPeriod(String payPeriodId) throws IOException {
		PayPeriod result = null;
		String query = "SELECT * FROM Pay_Period WHERE Period_Id = \"" + payPeriodId + "\";";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getReadDb());
		ResultSet rs = db.executeBasicQuery(query);
		try {
			while (rs.next()) {
				result = new PayPeriod(rs.getString("Period_Id"), rs.getDate("Start_Date"),
						rs.getDate("End_Date"));
			}
		} catch (SQLException sqlex) {
			System.out.println(
					"[FAILURE] Something went wrong while trying to read the " + "results...");
			sqlex.printStackTrace();
		}
		db.closeConnection();
		return result;
	}

	/**
	 * Queries the database to gather the number of Timecards that are attached to the given Pay
	 * Period and returns the result.
	 * 
	 * @param payPeriod the Pay Period object that the timecards are tied to
	 * @return an integer representing the number of timecards the pay period has
	 * @throws IOException
	 */
	public static int getNumPayPeriodTimecards(PayPeriod payPeriod) throws IOException {
		int result = 0;
		String query = "SELECT COUNT(*) AS Timecard_Count FROM Timecard WHERE Period_Id = "
				+ payPeriod.getPeriodId() + ";";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getReadDb());
		ResultSet rs = db.executeBasicQuery(query);
		try {
			while (rs.next()) {
				result = rs.getInt("Timecard_Count");
			}
		} catch (SQLException sqlex) {
			System.out.println(
					"[FAILURE] Something went wrong while trying to read the " + "results...");
			sqlex.printStackTrace();
		}
		db.closeConnection();
		return result;
	}

	/**
	 * Queries the database to gather all of the timecard tuples attached to the given pay period,
	 * creates new Timecard object for each of the tuples, and then returns an ArrayList of all of
	 * the Timecards attached to the given pay period.
	 * 
	 * @param payPeriod the payPeriod to gather all Timecards from
	 * @return an ArrayList of all of the Timecards attached to the given payPeriod
	 * @throws IOException
	 */
	public static List<Timecard> getAllPayPeriodTimecards(PayPeriod payPeriod) throws IOException {
		List<Timecard> result = new ArrayList<Timecard>();
		String query =
				"SELECT * FROM Timecard WHERE Period_Id = \"" + payPeriod.getPeriodId() + "\";";
		DatabaseConnector db = new DatabaseConnector(DatabaseProperties.getReadDb());
		ResultSet rs = db.executeBasicQuery(query);
		try {
			while (rs.next()) {
				Timecard tc = new Timecard(rs.getString("Emp_Id"), rs.getString("Period_Id"),
						rs.getDouble("Regular_Hours"), rs.getDouble("Overtime_Hours"),
						rs.getDouble("Bonus_Pay"), rs.getDouble("Other_Pay"));
				result.add(tc);
			}
		} catch (SQLException sqlex) {
			System.out
					.println("[FAILURE] Something went wrong while trying to read the results...");
			sqlex.printStackTrace();
		}
		db.closeConnection();
		return result;
	}
}
