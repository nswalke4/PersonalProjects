package nswalke4.smallbpayroll.util.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Creates an properties object from the database properties file and stores the key/value pairs as
 * class parameters accessable through getter methods.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.03
 */
public class DatabaseProperties {

	// Class Varialbes
	private static final String FILE_NAME = "src/main/resources/database.properties";

	// Constructor
	/**
	 * (NOT IN USE) A Database Properties object is not creates, as all of the different methods are
	 * static methods.
	 */
	public DatabaseProperties() {

	}

	// Getters
	/**
	 * Get's the username to access the database.
	 * 
	 * @return the username of the database
	 * @throws IOException
	 */
	public static String getUsername() throws IOException {
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(FILE_NAME);
		props.load(fis);
		return props.getProperty("username");
	}

	/**
	 * Get's the password to access the database.
	 * 
	 * @return the password of the database
	 * @throws IOException
	 */
	public static String getPassword() throws IOException {
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(FILE_NAME);
		props.load(fis);
		return props.getProperty("password");
	}

	/**
	 * Get's the url of the read-only database.
	 * 
	 * @return the url of the read-only database
	 * @throws IOException
	 */
	public static String getReadDb() throws IOException {
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(FILE_NAME);
		props.load(fis);
		return props.getProperty("read_database");
	}

	/**
	 * Get's the url of the full-access database.
	 * 
	 * @return the url of the writeable database
	 * @throws IOException
	 */
	public static String getWriteDb() throws IOException {
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(FILE_NAME);
		props.load(fis);
		return props.getProperty("write_database");
	}

	/**
	 * Get's the string representation of the database driver.
	 * 
	 * @return the string representation of the driver for the database connection
	 * @throws IOException
	 */
	public static String getDriver() throws IOException {
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream(FILE_NAME);
		props.load(fis);
		return props.getProperty("driver");
	}
}
