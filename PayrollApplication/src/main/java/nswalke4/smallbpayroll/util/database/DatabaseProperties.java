package nswalke4.smallbpayroll.util.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Creates an properties object from the database properties file and stores the key/value pairs as
 * class parameters accessable through getter methods.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.02
 */
public class DatabaseProperties {

	// Class Varialbes
	private final String FILE_NAME = "src/main/resources/database.properties";
	private static String username;
	private static String password;
	private static String readDb;
	private static String writeDb;
	private static String driver;

	// Constructor
	/**
	 * Creates the database properties object and sets up all of the different parameters to match
	 * the key/value pairs listed in properties file. NOTE: This constructor must be called prior to
	 * using any of the getter methods that follow.
	 */
	public DatabaseProperties() {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			prop = new Properties();
			fis = new FileInputStream(FILE_NAME);
			prop.load(fis);
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			readDb = prop.getProperty("read_database");
			writeDb = prop.getProperty("write_database");
			driver = prop.getProperty("driver");
		} catch (FileNotFoundException fnfex) {
			System.out.println("[FAILURE] The database properties files was not found in the "
					+ "resources directory");
			fnfex.printStackTrace();
		} catch (IOException ioex) {
			System.out.println("[FAILURE] Something went wrong with the input/output");
			ioex.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException ioex2) {
					System.out.println("[FAILURE] Unable to properly close the input stream...");
					ioex2.printStackTrace();
				}
			}
		}
	}

	// Getters
	/**
	 * Get's the username to access the database.
	 * 
	 * @return the username of the database
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Get's the password to access the database.
	 * 
	 * @return the password of the database
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Get's the url of the read-only database.
	 * 
	 * @return the url of the read-only database
	 */
	public String getReadDb() {
		return readDb;
	}

	/**
	 * Get's the url of the full-access database.
	 * 
	 * @return the url of the writeable database
	 */
	public String getWriteDb() {
		return writeDb;
	}

	/**
	 * Get's the string representation of the database driver.
	 * 
	 * @return the string representation of the driver for the database connection
	 */
	public String getDriver() {
		return driver;
	}
}
