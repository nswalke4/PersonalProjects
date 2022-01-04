const PayPeriodsTable = ({ payPeriods, addPayPeriod, selectPayPeriod }) => {
    return (
        <table className="pay-periods-table">
            <caption>
                <div className="tableHeader">Pay Periods</div>
                <button className="addButton" onClick={addPayPeriod}>
                    Add New Pay Period
                </button>
            </caption>
            <colgroup className="pay-period-colgroup">
                <col className="pay-period-id" />
                <col className="pay-period-start" />
                <col className="pay-period-end" />
            </colgroup>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>StartDate</th>
                    <th>EndDate</th>
                </tr>
            </thead>
            <tbody>
                {payPeriods.map((pp) => {
                    return (
                        <tr onDoubleClick={() => selectPayPeriod(pp)}>
                            <td>{pp.id}</td>
                            <td>{pp.startDate}</td>
                            <td>{pp.endDate}</td>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
};

export default PayPeriodsTable;
