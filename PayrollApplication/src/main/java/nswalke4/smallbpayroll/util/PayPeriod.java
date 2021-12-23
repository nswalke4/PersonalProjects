package main.java.nswalke4.smallbpayroll.util;

import java.sql.Date;

import org.json.JSONObject;

/**
 * This class is a representation of the PayPeriod table from the database used
 * for the payroll application, as well as the two enumerators used by the
 * account object in the database.
 * 
 * @author Nicholas Walker (nswalke4@asu.edu)
 * @version 1.05
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

	// Constructor
	public PayPeriod(String pPeriodId, Date pStartDate, Date pEndDate) {
		this.periodId = pPeriodId;
		this.startDate = pStartDate;
		this.endDate = pEndDate;
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

	// Class Methods
	/**
	 * Creates a JSONObject representation of the PayPeriod object.
	 * 
	 * @return - a JSONObject representation of this PayPeriod object
	 */
	public JSONObject makeIntoJSONObject() {
		JSONObject result = new JSONObject();
		result.put("PeriodID", this.getPeriodId());
		result.put("StartDate", this.getStartDate());
		result.put("EndDate", this.getEndDate());
		return result;
	}
}