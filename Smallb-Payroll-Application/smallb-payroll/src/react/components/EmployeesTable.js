const EmployeesTable = ({ employees, addEmployee, selectEmployee }) => {
    return (
        <table classname="employees-table">
            <caption>
                <div className="tableHeader">Employees</div>
                <button className="addButton" onClick={addEmployee}>
                    Add New Employee
                </button>
            </caption>
            <colgroup className="employee-colgroup">
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
                <tr onDoubleClick={() => selectEmployee("1-E-0001")}>
                    <td>1-E-0001</td>
                    <td>TestA</td>
                    <td>EmployeeA</td>
                    <td>-</td>
                    <td>HOURLY</td>
                    <td>7.25</td>
                </tr>
                <tr onDoubleClick={() => selectEmployee("1-E-0002")}>
                    <td>1-E-0002</td>
                    <td>TestB</td>
                    <td>EmployeeB</td>
                    <td>-</td>
                    <td>HOURLY</td>
                    <td>9.50</td>
                </tr>
                <tr onDoubleClick={() => selectEmployee("1-E-0003")}>
                    <td>1-E-0003</td>
                    <td>TestC</td>
                    <td>EmployeeC</td>
                    <td>-</td>
                    <td>SALARY</td>
                    <td>525.25</td>
                </tr>
            </tbody>
        </table>
    );
};

export default EmployeesTable;
