package main.java.nswalke4.smallbpayroll.util;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import main.java.nswalke4.smallbpayroll.util.database.DatabaseQueries;

/**
 * This class is a representation of the PayPeriod table from the database used
 * for the payroll application, as well as the two enumerators used by the
 * account object in the database.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.03
 */
public class PayPeriod {

	// Enumerator
	/**
	 * This enumerator represents all of the different possible pay-period types
	 * that can be used with this payroll application.
	 */
	public enum PayPeriodType {
		WEEKLY, BIWEEKLY
	}

	// Class Variables
	private final String periodId;
	private final Date startDate;
	private final Date endDate;
	private HashMap<String, Timecard> timecards;

	// Constructor
	public PayPeriod(String pPeriodId, Date pStartDate, Date pEndDate) {
		this.periodId = pPeriodId;
		this.startDate = pStartDate;
		this.endDate = pEndDate;
		this.timecards = new HashMap<String, Timecard>();
		this.updateTimecards();
	}

	// Getters
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

	/**
	 * Get's the hash map of all the timecards that are connected to the Pay Period
	 * object using the employee's id as the key and the timecard object as the value.
	 * 
	 * @return the HashMap of the timecards of the PayPeriod object
	 */
	public HashMap<String, Timecard> getTimecards() {
		return timecards;
	}

	// Class Methods
	/**
	 * Collects all of the tuples attached to the Timecard table with the PeriodID
	 * equal to the current PayPeriod's PeriodID from the database, and then adds
	 * any tuple to the timecards HashMap that is not already listed in it.
	 */
	public void updateTimecards() {
		List<Timecard> timecardList = DatabaseQueries.getAllPayPeriodTimecards(this);
		for (Timecard t : timecardList) {
			if (!timecards.containsKey(t.getEmployeeId())) {
				timecards.put(t.getEmployeeId(), t);
			}
		}
	}
}