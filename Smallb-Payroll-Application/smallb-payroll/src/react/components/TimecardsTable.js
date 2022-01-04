const TimecardsTable = ({ timecards }) => {
    return (
        <table className="timecards-table">
            <caption>
                <div className="tableHeader">Timecards</div>
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
                    <th>Employee ID</th>
                    <th>Pay Period ID</th>
                    <th>Regular Hours</th>
                    <th>Overtime Hours</th>
                    <th>Bonus Pay</th>
                    <th>Other Pay</th>
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
