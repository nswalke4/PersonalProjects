package util.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

	// Class Variables
	private final String databaseURL;
	private final String databaseUsername;
	private final String databasePassword;
	private final String databaseDriverString = "software.aws.rds.jdbc.mysql.Driver";
	private final String urlStringStarter = "jdbc:mysql:aws://";
	private final String schemaName = "/Payroll_Test";
	private Connection conn;

	// Constructor
	public DatabaseConnector(String pDatabaseURL, String pDatabaseUsername, String pDatabasePassword) {
		this.databaseURL = urlStringStarter + pDatabaseURL + schemaName;
		this.databaseUsername = pDatabaseUsername;
		this.databasePassword = pDatabasePassword;
		this.initalizeConnection();
	}

	// Getters
	/**
	 * @return the database URL for the database connector
	 */
	public String getDatabaseURL() {
		return databaseURL;
	}

	/**
	 * @return the database username for the database connector
	 */
	public String getDatabaseUsername() {
		return databaseUsername;
	}

	/**
	 * @return the database password for the database connector
	 */
	public String getDatabasePassword() {
		return databasePassword;
	}

	/**
	 * @return the connection of the database connector
	 */
	public Connection getConn() {
		return conn;
	}

	// Class Methods
	private void initalizeConnection() {
		try {
			Class.forName(databaseDriverString);
			this.conn = DriverManager.getConnection(getDatabaseURL(), getDatabaseUsername(), getDatabasePassword());
		} catch (ClassNotFoundException cnfex) {
			System.out.println("[FAILURE] Unable to find the driver class...");
			cnfex.printStackTrace();
		} catch (SQLException sqlex) {
			System.out.println("[FAILURE] Something went wrong with opening this connection...");
			sqlex.printStackTrace();
		}
	}

	public void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException sqlex) {
			System.out.println("[FAILURE] Something went wrong with closing this connection...");
			sqlex.printStackTrace();
		}
	}
}