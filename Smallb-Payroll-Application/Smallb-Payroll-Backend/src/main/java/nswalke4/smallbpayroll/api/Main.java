package nswalke4.smallbpayroll.api;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        System.out.println("Attempting to add new timecard.");
        JSONObject timecardObj = new JSONObject();
        timecardObj.put("EmployeeId", "5-E-0001");
        timecardObj.put("PeriodId", "5-P-0001");
        timecardObj.put("RegularHours", 0);
        timecardObj.put("OvertimeHours", 0);
        timecardObj.put("BonusPay", 0);
        timecardObj.put("OtherPay", 0);
        JSONObject response = SmallbPayrollMethods.createNewTimecard("testing-acct1", timecardObj);
        System.out.println(response);
    }
}
