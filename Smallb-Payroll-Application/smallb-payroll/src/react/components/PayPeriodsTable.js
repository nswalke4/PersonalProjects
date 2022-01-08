/* The Pay Period Table component creates a table from the given pay periods array object, and provides the ability to 
choose a pay period in the table by double clicking it to view more information of that pay period.  This component is used 
by the Account Tables component. */
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
                    <th>Start Date</th>
                    <th>End Date</th>
                </tr>
            </thead>
            <tbody>
                {payPeriods.map((pp) => {
                    return (
                        <tr key={pp.id} onDoubleClick={() => selectPayPeriod(pp)}>
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
