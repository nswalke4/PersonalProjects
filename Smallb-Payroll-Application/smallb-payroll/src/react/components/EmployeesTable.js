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
                <col className="emp-id" />
                <col className="emp-first-name" />
                <col className="emp-last-name" />
                <col className="emp-phone-num" />
                <col className="emp-type" />
                <col className="emp-pay-rate" />
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
                {employees.map((emp) => {
                    return (
                        <tr onDoubleClick={() => selectEmployee(emp)}>
                            <td>{emp.id}</td>
                            <td>{emp.firstName}</td>
                            <td>{emp.lastName}</td>
                            <td>{emp.phoneNuim}</td>
                            <td>{emp.type}</td>
                            <td>{emp.payRate}</td>
                        </tr>
                    );
                })}
            </tbody>
        </table>
    );
};

export default EmployeesTable;
