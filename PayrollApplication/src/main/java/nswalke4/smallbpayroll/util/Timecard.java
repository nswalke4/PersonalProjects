package main.java.nswalke4.smallbpayroll.util;

/**
 * This class is a representation of the Timecard table in the database for the
 * payroll application.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.02
 */
public class Timecard {

	// Class Variables
	private final String employeeId;
	private final String periodId;
	private double regularHours;
	private double overtimeHours;
	private double bonusPay;
	private double otherPay;

	// Constructors
	/**
	 * Creates a timecard object from the given information.
	 * 
	 * @param pEmployeeId    - the employee id of the Timecard object
	 * @param pPeriodId      - the pay period id of the Timecard object
	 * @param pRegularHours  - the number of regular hours of the Timecard object
	 * @param pOvertimeHours - the number of overtime hours of the Timecard object
	 * @param pBonusPay      - the amount of bonus pay of the Timecard object
	 * @param pOtherPay      - the amount of other pay of the Timecard object
	 */
	public Timecard(String pEmployeeId, String pPeriodId, double pRegularHours,
			double pOvertimeHours, double pBonusPay, double pOtherPay) {
		this.employeeId = pEmployeeId;
		this.periodId = pPeriodId;
		this.regularHours = pRegularHours;
		this.overtimeHours = pOvertimeHours;
		this.bonusPay = pBonusPay;
		this.otherPay = pOtherPay;
	}

	// Getters
	/**
	 * Get's the employee id of the Timecard object.
	 * 
	 * @return the employeeId of the Timecard object
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * Get's the pay period id of the Timecard object.
	 * 
	 * @return the periodId of the Timecard object
	 */
	public String getPeriodId() {
		return periodId;
	}

	/**
	 * Get's the number of regular hours of the Timecard object.
	 * 
	 * @return the regularHours of the Timecard object
	 */
	public double getRegularHours() {
		return regularHours;
	}

	/**
	 * Get's the number of overtime hours of the Timecard object.
	 * 
	 * @return the overtimeHours of the Timecard object
	 */
	public double getOvertimeHours() {
		return overtimeHours;
	}

	/**
	 * Get's the amount of bonus pay of the Timecard object.
	 * 
	 * @return the bonusPay of the Timecard object
	 */
	public double getBonusPay() {
		return bonusPay;
	}

	/**
	 * Get's the amount of other pay of the Timecard object.
	 * 
	 * @return the otherPay of the Timecard object
	 */
	public double getOtherPay() {
		return otherPay;
	}
}