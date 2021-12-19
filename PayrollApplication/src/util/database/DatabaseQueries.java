package util.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseQueries {

	private final String readDbURL = "payroll-instance-1-us-east-2c.c0eq0yjaxo9k.us-east-2.rds" + ".amazonaws.com:3306";
	private final String writeDbURL = "payroll-instance-1.c0eq0yjaxo9k.us-east-2.rds.amazonaws" + ".com:3306";
	private final String dbUsername = "admin";
	private final String dbPassword = "iz3cEOftoroFYYmf27Sh";
	private DatabaseConnector readDB;
	private DatabaseConnector writeDB;

	public DatabaseQueries() {
		this.readDB = new DatabaseConnector(readDbURL, dbUsername, dbPassword);
		this.writeDB = new DatabaseConnector(writeDbURL, dbUsername, dbPassword);
	}

	public void basicDbReadTestAccounts() {
		try {
			Statement stmt = readDB.getConn().createStatement();
			String queryString = "SELECT * FROM Account;";
			ResultSet rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				System.out.println("Account #" + rs.getInt("Account_Id") + ": " + rs.getString("Name"));
			}
		} catch (SQLException sqlex) {
			System.out.println("[FAILURE] Something went wrong with the connection...");
			sqlex.printStackTrace();
		}
	}

	public void basicDbReadTestEmployees() {
		try {
			Statement stmt = readDB.getConn().createStatement();
			String queryString = "SELECT * FROM Employee;";
			ResultSet rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				System.out.println(
						"Employee Id: " + rs.getString("Emp_Id") + "\t LastName: " + rs.getString("Last_Name"));
			}
		} catch (SQLException sqlex) {
			System.out.println("[FAILURE] Something went wrong with the connection...");
			sqlex.printStackTrace();
		}
	}

	public void closeConnections() {
		this.readDB.closeConnection();
		this.writeDB.closeConnection();
	}
}