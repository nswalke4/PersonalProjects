import { useState } from "react";

const Goal = () => {
    const onClick = (str, what) => {
        console.log(`${str} Button Clicked`);
        if (what === "emp") {
            swapAddEmpState();
        } else if (what === "pay") {
            swapAddPayPerState();
        }
    };

    const onDoubleClick = (str, what) => {
        console.log(`${str} Double Clicked`);
        if (what === "emp") {
            swapEmpInfoState();
        } else if (what === "pay") {
            swapPayPerInfoState();
        }
    };

    const [addEmpActive, setAddEmpActive] = useState(false);

    const swapAddEmpState = () => {
        setAddEmpActive(!addEmpActive);
    };

    const [addPayPerActive, setAddPayPerActive] = useState(false);

    const swapAddPayPerState = () => {
        setAddPayPerActive(!addPayPerActive);
    };

    const [empInfoActive, setEmpInfoActive] = useState(false);

    const swapEmpInfoState = () => {
        setEmpInfoActive(!empInfoActive);
    };

    const [payPerInfoActive, setPayPerInfoActive] = useState(false);

    const swapPayPerInfoState = () => {
        setPayPerInfoActive(!payPerInfoActive);
    };

    return (
        <div>
            <div className="header">
                <h1>Smallb Payroll Application</h1>
                <h2>Prototype Design</h2>
                <h3>Developer: Nicholas Walker (nswalke4@asu.edu)</h3>
            </div>
            <hr />
            <div className="body">
                <h2>Account: "test_account"</h2>
                {addEmpActive && (
                    <div className="addEmployee">
                        <div>Add a new Employee here...</div>
                        <button onClick={swapAddEmpState}>Close</button>
                    </div>
                )}
                {addPayPerActive && (
                    <div className="addPayPeriod">
                        <div>Add a new Pay Period here...</div>
                        <button onClick={swapAddPayPerState}>Close</button>
                    </div>
                )}
                {empInfoActive && (
                    <div className="employeeInfo">
                        <div>Showing Employee Info Here...</div>
                        <button onClick={swapEmpInfoState}>Close</button>
                    </div>
                )}
                {payPerInfoActive && (
                    <div className="payPeriodInfo">
                        <div>Showing Pay Period Info Here...</div>
                        <button onClick={swapPayPerInfoState}>Close</button>
                    </div>
                )}
                {!addEmpActive && !addPayPerActive && !empInfoActive && !payPerInfoActive && (
                    <div className="accountTables">
                        <table>
                            <caption>
                                <div className="tableHeader">Employees</div>
                                <button
                                    className="addButton"
                                    onClick={() => onClick("Add Employee", "emp")}
                                >
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
                                <tr onDoubleClick={() => onDoubleClick("Employee Row 1", "emp")}>
                                    <td>1-E-0001</td>
                                    <td>TestA</td>
                                    <td>EmployeeA</td>
                                    <td>-</td>
                                    <td>HOURLY</td>
                                    <td>7.25</td>
                                </tr>
                                <tr onDoubleClick={() => onDoubleClick("Employee Row 2", "emp")}>
                                    <td>1-E-0002</td>
                                    <td>TestB</td>
                                    <td>EmployeeB</td>
                                    <td>-</td>
                                    <td>HOURLY</td>
                                    <td>9.50</td>
                                </tr>
                                <tr onDoubleClick={() => onDoubleClick("Employee Row 3", "emp")}>
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
                        <table>
                            <caption>
                                <div className="tableHeader">Pay Periods</div>
                                <button
                                    className="addButton"
                                    onClick={() => onClick("Add Pay Period", "pay")}
                                >
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
                                <tr onDoubleClick={() => onDoubleClick("Pay Period Row 1", "pay")}>
                                    <td>1-P-0001</td>
                                    <td>11/28/2021</td>
                                    <td>12/04/2021</td>
                                </tr>
                                <tr onDoubleClick={() => onDoubleClick("Pay Period Row 2", "pay")}>
                                    <td>1-P-0002</td>
                                    <td>12/05/2021</td>
                                    <td>12/11/2021</td>
                                </tr>
                                <tr onDoubleClick={() => onDoubleClick("Pay Period Row 3", "pay")}>
                                    <td>1-P-0003</td>
                                    <td>12/12/2021</td>
                                    <td>12/18/2021</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                )}
            </div>
        </div>
    );
};

export default Goal;
