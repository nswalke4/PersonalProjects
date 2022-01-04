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
                <tr onDoubleClick={() => selectPayPeriod("1-P-0001")}>
                    <td>1-P-0001</td>
                    <td>11/28/2021</td>
                    <td>12/04/2021</td>
                </tr>
                <tr onDoubleClick={() => selectPayPeriod("1-P-0002")}>
                    <td>1-P-0002</td>
                    <td>12/05/2021</td>
                    <td>12/11/2021</td>
                </tr>
                <tr onDoubleClick={() => selectPayPeriod("1-P-0003")}>
                    <td>1-P-0003</td>
                    <td>12/12/2021</td>
                    <td>12/18/2021</td>
                </tr>
            </tbody>
        </table>
    );
};

export default PayPeriodsTable;
