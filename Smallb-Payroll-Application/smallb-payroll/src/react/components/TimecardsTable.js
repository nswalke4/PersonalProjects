/* The Timecards Table component creates a table from the given timecards array object.  This component is used by both the 
EmployeeInfo and PayPeriodInfo components, and so includes a parameter named "isEmployee" that is set to either true or
false, depending on if the table is being creted inside the EmployeeInfo component or not.  This just selects whether the
pay period id or employee id column is included in the table. */
const TimecardsTable = ({ timecards, isEmployee }) => {
    // This method takes the employee id and pay period id of a timecard object and combines them to create a unique id to
    // be used as the key for each row.
    const tcKey = (tc) => {
        return `${tc.empId}:${tc.perId}`;
    };

    return (
        <table className="timecards-table">
            <caption>
                <div className="tableHeader">Timecards</div>
            </caption>
            <colgroup className="timecard-colgroup">
                {!isEmployee && <col className="timecard-emp-id" />}
                {isEmployee && <col className="timecard-pay-period-id" />}
                <col className="timecard-reg-hrs" />
                <col className="timecard-over-hrs" />
                <col className="timecard-bonus-pay" />
                <col className="timecard-other-pay" />
            </colgroup>
            <thead>
                <tr>
                    {!isEmployee && <th>Employee ID</th>}
                    {isEmployee && <th>Pay Period ID</th>}
                    <th>Regular Hours</th>
                    <th>Overtime Hours</th>
                    <th>Bonus Pay</th>
                    <th>Other Pay</th>
                </tr>
            </thead>
            <tbody>
                {timecards.map((tc) => {
                    return (
                        <tr key={tcKey(tc)}>
                            {!isEmployee && <td>{tc.empId}</td>}
                            {isEmployee && <td>{tc.perId}</td>}
                            <td>{tc.regHrs}</td>
                            <td>{tc.overHrs}</td>
                            <td>${tc.bonus.toFixed(2)}</td>
                            <td>${tc.other.toFixed(2)}</td>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
};

export default TimecardsTable;
