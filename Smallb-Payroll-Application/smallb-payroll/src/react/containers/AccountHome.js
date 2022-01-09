import AccountTables from "../components/AccountTables";
import AddEmployee from "./AddEmployee";
import AddPayPeriod from "./AddPayPeriod";
import EmployeeInfo from "./EmployeeInfo";
import PayPeriodInfo from "./PayPeriodInfo";
import { useState } from "react";

/* The Account Home container contains information about the Account, a list of the Account's Employees and Pay Periods, 
and the ability to add new employees or pay periods to the Account.  This Home Page contains the AccountTables object, and 
the functions that provide the ability to allow the primary view to be changed to either the Employee/PayPeriod information 
page, or to add new employees or pay periods. */
const AccountHome = () => {
    // Account Object
    const accountSub = "Testing-Sub-123";

    // Employees Array
    const [employees, setEmployees] = useState([
        {
            id: "1-E-0001",
            firstName: "TestA",
            lastName: "EmployeeA",
            phoneNum: "-",
            type: "HOURLY",
            payRate: 7.25,
        },
        {
            id: "1-E-0002",
            firstName: "TestB",
            lastName: "EmployeeB",
            phoneNum: "-",
            type: "HOURLY",
            payRate: 9.5,
        },
        {
            id: "1-E-0003",
            firstName: "TestC",
            lastName: "EmployeeC",
            phoneNum: "-",
            type: "SALARY",
            payRate: 525.25,
        },
    ]);
    const addEmployee = (emp) => {
        const newEmployees = [...employees];
        newEmployees.push(emp);
        setEmployees(newEmployees);
    };

    // Pay Periods Array
    const [payPeriods, setPayPeriods] = useState([
        {
            id: "1-P-0001",
            startDate: "11/28/2021",
            endDate: "12/04/2021",
        },
        {
            id: "1-P-0002",
            startDate: "12/05/2021",
            endDate: "12/11/2021",
        },
        {
            id: "1-P-0003",
            startDate: "12/12/2021",
            endDate: "12/18/2021",
        },
    ]);
    const addPayPeriod = (payPeriod) => {
        const newPayPeriods = [...payPeriods];
        newPayPeriods.push(payPeriod);
        setPayPeriods(newPayPeriods);
    };

    // Methods to Adjust Current View
    // Add Employee View
    const [addEmpActive, setAddEmpActive] = useState(false);
    const swapAddEmpState = () => {
        setAddEmpActive(!addEmpActive);
    };

    // Add Pay Period View
    const [addPayPerActive, setAddPayPerActive] = useState(false);
    const swapAddPayPerState = () => {
        setAddPayPerActive(!addPayPerActive);
    };

    // Specific Employee View
    const [empInfo, setEmpInfo] = useState({
        active: false,
        employee: null,
    });
    const chooseEmp = (emp) => {
        setEmpInfo({
            active: true,
            employee: emp,
        });
    };
    const resetEmp = () => {
        setEmpInfo({
            active: false,
            employee: null,
        });
    };

    // Specific Pay Period View
    const [payPerInfo, setPayPerInfo] = useState({
        active: false,
        payPeriod: null,
    });
    const choosePayPer = (payPer) => {
        setPayPerInfo({
            active: true,
            payPeriod: payPer,
        });
    };
    const resetPayPer = () => {
        setPayPerInfo({
            active: false,
            payPeriod: null,
        });
    };

    // Checks the above "view" objects and determines which "view" to present.  Initially presents the "AccountTables"
    // unless the user requests to view a specific employee or pay period, or requests to add a new employee or pay period
    return (
        <div className="account-home">
            <h2>Test Account: {accountSub}</h2>
            {addEmpActive && <AddEmployee addEmployee={addEmployee} onClose={swapAddEmpState} />}
            {addPayPerActive && (
                <AddPayPeriod
                    addPayPeriod={addPayPeriod}
                    employees={employees}
                    onClose={swapAddPayPerState}
                />
            )}
            {empInfo.active && <EmployeeInfo onClose={resetEmp} employee={empInfo.employee} />}
            {payPerInfo.active && (
                <PayPeriodInfo onClose={resetPayPer} payPeriod={payPerInfo.payPeriod} />
            )}
            {!addEmpActive && !addPayPerActive && !empInfo.active && !payPerInfo.active && (
                <AccountTables
                    employees={employees}
                    addEmp={swapAddEmpState}
                    empInfo={chooseEmp}
                    payPeriods={payPeriods}
                    addPer={swapAddPayPerState}
                    perInfo={choosePayPer}
                />
            )}
        </div>
    );
};

export default AccountHome;
