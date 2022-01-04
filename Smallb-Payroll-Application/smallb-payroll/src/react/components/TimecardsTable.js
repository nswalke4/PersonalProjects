const TimecardsTable = ({ timecards }) => {
    return (
        <table className="timecards-table">
            <caption>
                <div className="tableHeader">Timecards</div>
                {/* <button className="addButton" onClick={addTimecard}>
                    Add New Employee
                </button> */}
            </caption>
            <colgroup className="timecard-colgroup">
                <col className="timecard-emp-id" />
                <col className="timecard-pay-period-id" />
                <col className="timecard-reg-hrs" />
                <col className="timecard-over-hrs" />
                <col className="timecard-bonus-pay" />
                <col className="timecard-other-pay" />
            </colgroup>
            <thead>
                <tr>
                    <th>EmployeeID</th>
                    <th>PayPeriodID</th>
                    <th>RegularHours</th>
                    <th>OvertimeHours</th>
                    <th>BonusPay</th>
                    <th>OtherPay</th>
                </tr>
            </thead>
            <tbody>
                {timecards.map((tc) => {
                    return (
                        <tr>
                            <td>{tc.empId}</td>
                            <td>{tc.perId}</td>
                            <td>{tc.regHrs}</td>
                            <td>{tc.overHrs}</td>
                            <td>{tc.bonus}</td>
                            <td>{tc.other}</td>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
};

export default TimecardsTable;
