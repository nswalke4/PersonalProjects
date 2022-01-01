package nswalke4.smallbpayroll.api;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        System.out.println("Attempting connection to gather information from test account.");
        JSONObject response = SmallbPayrollMethods.gatherAccountInformation("abc123-notarealsub");
        System.out.println(response);
    }
}
