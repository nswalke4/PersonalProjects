const PayPeriodsTable = ({ payPeriods, addPayPeriod, selectPayPeriod }) => {
    return (
        <table className="pay-periods-table">
            <caption>
                <div className="tableHeader">Pay Periods</div>
                <button className="addButton" onClick={addPayPeriod}>
                    Add New Pay Period
                </button>
            </caption>
            <colgroup className="payPeriod">
                <col className="periodId" />
                <col className="startDate" />
                <col className="endDate" />
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
