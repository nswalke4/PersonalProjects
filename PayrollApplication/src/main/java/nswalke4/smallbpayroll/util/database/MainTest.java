package main.java.nswalke4.smallbpayroll.util.database;

import java.sql.Date;
import java.sql.Types;
import java.util.List;

import main.java.nswalke4.smallbpayroll.util.Account;
import main.java.nswalke4.smallbpayroll.util.Employee;
import main.java.nswalke4.smallbpayroll.util.PayPeriod;
import main.java.nswalke4.smallbpayroll.util.Timecard;

/**
 * This basic class handles the ability to "test" the connection to the Payroll database and check
 * to ensure that basic queries are being executed properly.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.03
 */
public class MainTest {

	/**
	 * The basic main method creates a DatabaseQueries class and attempts to execute all of the
	 * different queries in its class.
	 * 
	 * @param args - the command-line arguments given while executing this program
	 */
	public static void main(String[] args) {
		new DatabaseProperties();
		System.out.println(DatabaseProperties.getDriver());
		System.out.println(DatabaseProperties.getUsername());
		System.out.println(DatabaseProperties.getPassword());
		System.out.println(DatabaseProperties.getReadDb());
		System.out.println(DatabaseProperties.getWriteDb());

		System.out.println("Welcome to the Small-b Payroll Application Testing!");
		System.out.println(" Testing Version 1.03");

		// Basic Query Tests
		System.out.println("\nBeginning Query Testing...");
		printAccounts(DatabaseQueries.getAllAccounts());
		Account account =
				DatabaseQueries.getSpecificAccount("ada144e7-5084-49e4-a7e5-701f762ecacf");
		printEmployees(DatabaseQueries.getEmployees(account));
		printPayPeriods(DatabaseQueries.getPayPeriods(account));
		Employee emp = getEmployee(DatabaseQueries.getEmployees(account), "1-E-0001");
		if (emp != null) {
			printTimecards(DatabaseQueries.getAllEmployeeTimecards(emp));
		}
		PayPeriod payP = getPayPeriod(DatabaseQueries.getPayPeriods(account), "1-P-0001");
		if (payP != null) {
			printTimecards(DatabaseQueries.getAllPayPeriodTimecards(payP));
		}
		System.out.println("\nEnd Query Testing...");

		// Basic Insertion Tests
		System.out.println("\nBeginning Insertion Testing...");
		DatabaseQueries.addAccount("JavaTestingAccount", "testEmail@javaTest1",
				"abc123-notarealsub", PayPeriod.PayPeriodType.BIWEEKLY);
		printAccounts(DatabaseQueries.getAllAccounts());
		Account newAccount = DatabaseQueries.getSpecificAccount("abc123-notarealsub");
		DatabaseQueries.addHourlyEmployee(newAccount, "3JavaA", "3EmployeeA",
				String.valueOf(Types.NULL), 21.00);
		printEmployees(DatabaseQueries.getEmployees(newAccount));
		DatabaseQueries.addPayPeriod(newAccount, new Date(System.currentTimeMillis()));
		printPayPeriods(DatabaseQueries.getPayPeriods(newAccount));
		Employee newEmp = getEmployee(DatabaseQueries.getEmployees(newAccount), "3-E-0001");
		PayPeriod newPayP = getPayPeriod(DatabaseQueries.getPayPeriods(newAccount), "3-P-0001");
		DatabaseQueries.addTimecard(newAccount, newEmp.getEmployeeId(), newPayP.getPeriodId(),
				40.00, 5.00, 0.00, 0.00);
		printTimecards(DatabaseQueries.getAllEmployeeTimecards(newEmp));
		System.out.println("\nEnd Insertion Testing...");

		// Basic Count Tests
		System.out.println("\nBeginning Count Testing...");
		System.out.println("\nCounting the number of Employees for Account #2");
		System.out.println(" - NOTE: The result should be 1");
		Account account2 =
				DatabaseQueries.getSpecificAccount("bcdea241-27b3-4efd-a8c6-cd797c0f8a68");
		System.out.println(DatabaseQueries.getNumEmployees(account2));

		System.out.println("\nCounting the number of PayPeriods for Account #2");
		System.out.println(" - Note: The result should be 2");
		System.out.println(DatabaseQueries.getNumPayPeriods(account2));

		System.out.println("\nThis concludes the basic testing for the Database connection");
	}

	/**
	 * Get's a specific employee given the employee id string and the list of employees.
	 *
	 * @param employees - the list of employees to get a specific employee from
	 * @param empIdString - the employee id to get from the list of employees
	 * @return - the employee that has the given employeeID from the employees list
	 * 
	 */
	private static Employee getEmployee(List<Employee> employees, String empIdString) {
		for (Employee e : employees) {
			if (e.getEmployeeId().equals(empIdString)) {
				return e;
			}
		}
		return null;
	}

	/**
	 * Get's a specific payPeriod given the pay period id string and the list of payPeriods.
	 *
	 * @param payPeriods - the list of pay periods to get a specific pay period from
	 * @param payPerString - the pay period id to get from the list of pay periods
	 * @return - the pay period that has the given payPeriodID from the payPeriods list
	 */
	private static PayPeriod getPayPeriod(List<PayPeriod> payPeriods, String payPerString) {
		for (PayPeriod p : payPeriods) {
			if (p.getPeriodId().equals(payPerString)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Print's the Account Id, Name, and Email for all of the accounts in the given list.
	 *
	 * @param accounts - the list of accounts to print information from
	 */
	private static void printAccounts(List<Account> accounts) {
		System.out.println("\nAccounts:");
		for (Account a : accounts) {
			System.out.println(" ID: " + a.getId());
			System.out.println(" Name: " + a.getName());
			System.out.println(" Email: " + a.getEmail());
		}
	}

	/**
	 * Print's the Employee Id and Name for all of the employees in the given list.
	 *
	 * @param employees - the list of employees to print information from
	 */
	private static void printEmployees(List<Employee> employees) {
		System.out.println("\nEmployees:");
		for (Employee e : employees) {
			System.out.println(" ID: " + e.getEmployeeId());
			System.out.println(" Name: " + e.getFirstName() + " " + e.getLastName());
		}
	}

	/**
	 * Print's the Pay Period ID, Start Date, and End Date of all of the pay periods in the given
	 * list.
	 *
	 * @param payPeriods - the list of pay periods to print information from
	 */
	private static void printPayPeriods(List<PayPeriod> payPeriods) {
		System.out.println("\nPayPeriods:");
		for (PayPeriod p : payPeriods) {
			System.out.println(" ID: " + p.getPeriodId());
			System.out.println(" Start Date: " + p.getStartDate());
			System.out.println(" End Date: " + p.getEndDate());
		}
	}

	/**
	 * Print's the EmployeeId, PayPeriodID, number of regular hours, overtime hours, bonus pay, and
	 * other pay for all of the timecards in the given list.
	 *
	 * @param timecards - the list of timecards to print information from
	 */
	private static void printTimecards(List<Timecard> timecards) {
		System.out.println("\nTimecards:");
		for (Timecard t : timecards) {
			System.out.println(" EmpId: " + t.getEmployeeId() + " PeriodId: " + t.getPeriodId());
			System.out.println(
					" RegHrs: " + t.getRegularHours() + "\tOvertimeHrs: " + t.getOvertimeHours());
			System.out.println(" BonusPay: " + t.getBonusPay() + "\tOtherPay: " + t.getOtherPay());
		}
	}

}
