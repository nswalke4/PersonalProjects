package main.java.nswalke4.smallbpayroll.util.database;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import main.java.nswalke4.smallbpayroll.util.Account;
import main.java.nswalke4.smallbpayroll.util.Employee;
import main.java.nswalke4.smallbpayroll.util.PayPeriod;
import main.java.nswalke4.smallbpayroll.util.Timecard;

/**
 * (The following description is the "goal" of this class, and does not
 * accurately represent the current state of this class) This class is an
 * abstract class responsible for all of the different queries that can be
 * executed onto the Payroll database.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.03A
 */
public class DatabaseQueries {

	// Class Variables
	private final String readDbURL;
	private final String writeDbURL;
	private final String dbUsername;
	private final String dbPassword;
	private DatabaseConnector readDB;
	private DatabaseConnector writeDB;

	// Constructor
	/**
	 * Constructs a basic DatabaseQueries object with a "read-only" database as well
	 * as a database that can be written to.
	 */
	public DatabaseQueries() {
		this.readDbURL = DatabaseProperties.getReadDb();
		this.writeDbURL = DatabaseProperties.getWriteDb();
		this.dbUsername = DatabaseProperties.getUsername();
		this.dbPassword = DatabaseProperties.getPassword();
		this.readDB = new DatabaseConnector(readDbURL, dbUsername, dbPassword);
		this.writeDB = new DatabaseConnector(writeDbURL, dbUsername, dbPassword);
	}

	// Class Methods
	/**
	 * This basic method gathers all of the different tuples on the "Account" table
	 * of the Payroll database and return's them in the console output.
	 */
	public void basicDbReadTestAccounts() {
		String queryString = "SELECT * FROM Account;";
		ResultSet rs = this.readDB.executeBasicQuery(queryString);
		if (rs != null) {
			try {
				while (rs.next()) {
					System.out.println("Account #" + rs.getInt("Account_Id") + ": " 
							+ rs.getString("Name"));
				}
				rs.close();
			} catch (SQLException sqlex) {
				System.out.println("[FAILURE] Something went wrong while trying to read the "
						+ "results...");
				sqlex.printStackTrace();
			}
		}
	}

	/**
	 * This basic method gathers all of the different tuples on the "Employee" table
	 * of the Payroll database and return's them in the console output.
	 */
	public void basicDbReadTestEmployees() {
		String queryString = "SELECT * FROM Employee;";
		ResultSet rs = this.readDB.executeBasicQuery(queryString);
		if (rs != null) {
			try {
				while (rs.next()) {
					System.out.println(
							"Employee Id: " + rs.getString("Emp_Id") + "\t LastName: " 
							+ rs.getString("Last_Name"));
				}
				rs.close();
			} catch (SQLException sqlex) {
				System.out.println("[FAILURE] Something went wrong while trying to read the "
						+ "results...");
				sqlex.printStackTrace();
			}
		}
	}

	/**
	 * Closes the connections of the two databases.
	 */
	public void closeConnections() {
		this.readDB.closeConnection();
		this.writeDB.closeConnection();
	}
	
	// #TODO Methods to be implemented (not all, just a handful from first thoughts)
	public static void addAccount(String name, String email, PayPeriod.PayPeriodType periodType,
			PayPeriod.PeriodStartDay startDay) {
	}
	
	public static void addHourlyEmployee(Account account, String firstName, String lastName,
			String phoneNum, Double payRate) {
	}
	
	public static void addSalaryEmployee(Account account, String firstName, String lastName,
			String phoneNum, Double payRate) {
	}
	
	public static void addPayPeriod(Account account, Date startDate) {
	}
	
	public static void addTimecard(Account account, Employee employee, PayPeriod payPeriod,
			float regHours, float overtimeHours, float bonusPay, float otherPay) {
	}
	
	public static List<Account> getAccounts() {
		List<Account> result = null;
		
		return result;
	}
	
	public static List<Employee> getEmployees(Account account) {
		List<Employee> result = null;
		
		return result;
	}
	
	public static List<PayPeriod> getPayPeriods(Account account) {
		List<PayPeriod> result = null;
		
		return result;
	}
	
	public static List<Timecard> getAllTimecards(Account account) {
		List<Timecard> result = null;
		
		return result;
	}
	
	public static List<Timecard> getAllTimecardsPeriod(Account account, Date start, Date end) {
		List<Timecard> result = null;
		
		return result;
	}
	
	public static List<Timecard> getTimecardsFromPayPeriod(Account account, PayPeriod payPeriod) {
		List<Timecard> result = null;
		
		return result;
	}
	
	public static List<Timecard> getEmployeeTimecards(Account account, Employee employee) {
		List<Timecard> result = null;
		
		return result;
	}
	
	public static List<Timecard> getEmployeeTimecardsPeriod(Account account, Employee employee,
			Date start, Date end) {
		List<Timecard> result = null;
		
		return result;
	}
}