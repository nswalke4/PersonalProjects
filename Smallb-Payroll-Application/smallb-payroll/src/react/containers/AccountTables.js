const AccountInfo = ({ addEmp, addPer, empInfo, perInfo }) => {
    return (
        <div className="account-tables">
            <table className="employee-table">
                <caption>
                    <div className="tableHeader">Employees</div>
                    <button className="addButton" onClick={addEmp}>
                        Add New Employee
                    </button>
                </caption>
                <colgroup className="employee">
                    <col className="empId" />
                    <col className="firstName" />
                    <col className="lastName" />
                    <col className="phoneNum" />
                    <col className="type" />
                    <col className="payRate" />
                </colgroup>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>PhoneNum</th>
                        <th>Type</th>
                        <th>PayRate</th>
                    </tr>
                </thead>
                <tbody>
                    <tr onDoubleClick={() => empInfo("1-E-0001")}>
                        <td>1-E-0001</td>
                        <td>TestA</td>
                        <td>EmployeeA</td>
                        <td>-</td>
                        <td>HOURLY</td>
                        <td>7.25</td>
                    </tr>
                    <tr onDoubleClick={() => empInfo("1-E-0002")}>
                        <td>1-E-0002</td>
                        <td>TestB</td>
                        <td>EmployeeB</td>
                        <td>-</td>
                        <td>HOURLY</td>
                        <td>9.50</td>
                    </tr>
                    <tr onDoubleClick={() => empInfo("1-E-0003")}>
                        <td>1-E-0003</td>
                        <td>TestC</td>
                        <td>EmployeeC</td>
                        <td>-</td>
                        <td>SALARY</td>
                        <td>525.25</td>
                    </tr>
                </tbody>
            </table>
            <div className="break" />
            <table className="pay-period-table">
                <caption>
                    <div className="tableHeader">Pay Periods</div>
                    <button className="addButton" onClick={addPer}>
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
                    <tr onDoubleClick={() => perInfo("1-P-0001")}>
                        <td>1-P-0001</td>
                        <td>11/28/2021</td>
                        <td>12/04/2021</td>
                    </tr>
                    <tr onDoubleClick={() => perInfo("1-P-0002")}>
                        <td>1-P-0002</td>
                        <td>12/05/2021</td>
                        <td>12/11/2021</td>
                    </tr>
                    <tr onDoubleClick={() => perInfo("1-P-0003")}>
                        <td>1-P-0003</td>
                        <td>12/12/2021</td>
                        <td>12/18/2021</td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
};

export default AccountInfo;
