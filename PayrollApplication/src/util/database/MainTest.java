package util.database;

/**
 * This basic class handles the ability to "test" the connection to the Payroll
 * database and check to ensure that basic queries are being executed properly.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.01
 */
public class MainTest {

	/**
	 * The basic main method creates a DatabaseQueries class and attempts to execute
	 * all of the different queries in its class.
	 * 
	 * @param args - the command-line arguments given while executing this program
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseQueries dbQueries = new DatabaseQueries();
		dbQueries.basicDbReadTestAccounts();
		dbQueries.basicDbReadTestEmployees();
		dbQueries.closeConnections();
	}

}
