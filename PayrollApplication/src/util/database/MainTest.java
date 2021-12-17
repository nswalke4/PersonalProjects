package util.database;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseQueries dbQueries = new DatabaseQueries();
		dbQueries.basicDbReadTestAccounts();
		dbQueries.basicDbReadTestEmployees();
		dbQueries.closeConnections();
	}

}
