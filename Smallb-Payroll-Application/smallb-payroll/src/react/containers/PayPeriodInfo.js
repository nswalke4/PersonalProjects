import TimecardsTable from "../components/TimecardsTable";
import { useState } from "react";

/* The Pay Period Info container conatins all of the information about the Pay Period and all of the timecards that are 
attached to the given pay period's id. */
const PayPeriodInfo = ({ onClose, payPeriod }) => {
    const [timecards] = useState([
        {
            empId: "1-E-0001",
            perId: payPeriod.id,
            regHrs: 40,
            overHrs: 10,
            bonus: 0,
            other: 100,
        },
        {
            empId: "1-E-0002",
            perId: payPeriod.id,
            regHrs: 35,
            overHrs: 10,
            bonus: 250,
            other: 0,
        },
        {
            empId: "1-E-0003",
            perId: payPeriod.id,
            regHrs: 40,
            overHrs: 5,
            bonus: 0,
            other: 0,
        },
    ]);

    // Presents the user with the pay period's information and the table of all of the pay period's timecards.
    return (
        <div className="pay-period-info">
            <p>Pay Period ID: {payPeriod.id}</p>
            <p>Start Date: {payPeriod.startDate}</p>
            <p>End Date: {payPeriod.endDate}</p>
            <TimecardsTable timecards={timecards} isEmployee={false} />
            <button onClick={onClose}>Close</button>
        </div>
    );
};

export default PayPeriodInfo;
