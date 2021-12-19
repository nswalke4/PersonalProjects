package util;

import java.sql.Date;

/**
 * This class is a representation of the PayPeriod table from the database used
 * for the payroll application, as well as the two enumerators used by the
 * account object in the database.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.01
 */
public class PayPeriod {

	// Enumerators
	/**
	 * This enumerator represents all of the different possible pay-period types
	 * that can be used with this payroll application.
	 */
	public enum PayPeriodType {
		WEEKLY, BIWEEKLY
	}

	/**
	 * This enumerator represents all of the different potential start days for the
	 * pay period that can be used with this payroll application.
	 */
	public enum PeriodStartDay {
		SUN, MON, TUES, WED, THURS, FRI, SAT
	}

	// Class Variables
	private final String periodId;
	private final Date startDate;
	private final Date endDate;

	// Constructor
	public PayPeriod(String pPeriodId, Date pStartDate, Date pEndDate) {
		this.periodId = pPeriodId;
		this.startDate = pStartDate;
		this.endDate = pEndDate;
	}

	/**
	 * Get's the id of the Pay Period object.
	 * 
	 * @return the periodId of the PayPeriod object
	 */
	public String getPeriodId() {
		return periodId;
	}

	/**
	 * Get's the start date of the Pay Period object.
	 * 
	 * @return the startDate of the PayPeriod object
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Get's the end date of the Pay Period object.
	 * 
	 * @return the endDate of the PayPeriod object
	 */
	public Date getEndDate() {
		return endDate;
	}
}