package nswalke4.smallbpayroll.util.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Creates a basic database connection to the given database URL using the Amazon Web Services JDBC
 * MySQL Driver. This class contains all of the connections to the given database URL and provides
 * the basic framework for communicating with the database to insert new tuples and query
 * information from the database.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.07
 */
public class DatabaseConnector {

	// Class Variables
	private final String URL;
	private final String USERNAME;
	private final String PASSWORD;
	private Connection conn;

	// Constructor
	/**
	 * Constructs a basic Database Connector object to the given database URL..
	 * 
	 * @param pDatabaseURL the URL of the database connection
	 * @throws IOException
	 */
	public DatabaseConnector(String pDatabaseURL) throws IOException {
		this.URL = pDatabaseURL;
		this.USERNAME = DatabaseProperties.getUsername();
		this.PASSWORD = DatabaseProperties.getPassword();
		this.connect();
	}

	// Class Methods
	/**
	 * Initializes a connection to the database, and informs the user if there were any errors in
	 * attempting to connect to the database.
	 */
	private void connect() {
		try {
			this.conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException sqlex) {
			System.out.println("[FAILURE] Something went wrong with opening this connection...");
			System.out.println("Error Code: " + sqlex.getErrorCode());
			System.out.println("SQL State: " + sqlex.getSQLState());
			System.out.println("Message: " + sqlex.getMessage());
			sqlex.printStackTrace();
		}
	}

	/**
	 * Executes a basic query (given as a parameter) onto the database and return's the ResultSet
	 * associated with that query.
	 * 
	 * @param query the query string to be sent to the database to be executed
	 * @return the ResultSet containing the answer to the query (or null)
	 */
	protected ResultSet executeBasicQuery(String query) {
		try {
			Statement stmt = conn.createStatement();
			return stmt.executeQuery(query);
		} catch (SQLException sqlex) {
			System.out.println("[FAILURE] Something went wrong while attempting to execute this "
					+ "query...");
			System.out.println("    Query: " + query);
			sqlex.printStackTrace();
			return null;
		}
	}

	/**
	 * Executes a basic update (given as a parameter) statement onto the database and returns a
	 * value representing the number of rows affected (or -1 if the update failed).
	 * 
	 * @param update the update string to be sent to the database to be executed
	 * @return the number of rows affected by the update (or -1 if it fails)
	 */
	protected int executeBasicUpdate(String update) {
		try {
			Statement stmt = conn.createStatement();
			return stmt.executeUpdate(update);
		} catch (SQLException sqlex) {
			System.out.println("[FAILURE] Something went wrong while attempting to execute this "
					+ "update...");
			System.out.println("    Update: " + update);
			sqlex.printStackTrace();
			return -1;
		}
	}

	/**
	 * Closes a connection to the database, and informs the user if there were any errors in
	 * attempting to disconnect from the database.
	 */
	protected void closeConnection() {
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
