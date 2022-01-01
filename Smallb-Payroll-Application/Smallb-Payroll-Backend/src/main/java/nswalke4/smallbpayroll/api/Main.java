package nswalke4.smallbpayroll.api;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        System.out.println("Attempting connection to gather information from test account.");
        JSONObject response = SmallbPayrollMethods
                .gatherAccountInformation("ada144e7-5084-49e4-a7e5-701f762ecacf");
        System.out.println(response);
    }
}
