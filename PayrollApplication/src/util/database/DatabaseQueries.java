package util.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * (The following description is the "goal" of this class, and does not
 * accurately represent the current state of this class) This class is an
 * abstract class responsible for all of the different queries that can be
 * executed onto the Payroll database.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.02
 */
public class DatabaseQueries {

	// Class Variables
	private final String readDbURL = "payroll-instance-1-us-east-2c.c0eq0yjaxo9k.us-east-2.rds"
			+ ".amazonaws.com:3306";
	private final String writeDbURL = "payroll-instance-1.c0eq0yjaxo9k.us-east-2.rds.amazonaws"
			+ ".com:3306";
	private final String dbUsername = "admin";
	private final String dbPassword = "iz3cEOftoroFYYmf27Sh";
	private DatabaseConnector readDB;
	private DatabaseConnector writeDB;

	// Constructor
	/**
	 * Constructs a basic DatabaseQueries object with a "read-only" database as well
	 * as a database that can be written to.
	 */
	public DatabaseQueries() {
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
}