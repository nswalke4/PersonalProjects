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
 * @version 1.01
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
	 * @return the username of the database
	 */
	public static String getUsername() {
		return username;
	}

	/**
	 * @return the password of the database
	 */
	public static String getPassword() {
		return password;
	}

	/**
	 * @return the url of the read-only database
	 */
	public static String getReadDb() {
		return readDb;
	}

	/**
	 * @return the url of the writeable database
	 */
	public static String getWriteDb() {
		return writeDb;
	}

	/**
	 * @return the string representation of the driver for the database connection
	 */
	public static String getDriver() {
		return driver;
	}
}
