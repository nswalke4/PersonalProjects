import AccountTables from "./AccountTables";
import AddEmployee from "./AddEmployee";
import AddPayPeriod from "./AddPayPeriod";
import EmployeeInfo from "./EmployeeInfo";
import PayPeriodInfo from "./PayPeriodInfo";
import { useState } from "react";

const AccountHome = () => {
    // Account Object
    const account = {
        sub: "Testing-Sub-123",
        employees: [
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
        ],
        payPeriods: [
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
        ],
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

    return (
        <div className="account-home">
            <h2>Test Account: {account.sub}</h2>
            {addEmpActive && <AddEmployee onClose={swapAddEmpState} />}
            {addPayPerActive && <AddPayPeriod onClose={swapAddPayPerState} />}
            {empInfo.active && <EmployeeInfo onClose={resetEmp} employee={empInfo.employee} />}
            {payPerInfo.active && (
                <PayPeriodInfo onClose={resetPayPer} payPeriod={payPerInfo.payPeriod} />
            )}
            {!addEmpActive && !addPayPerActive && !empInfo.active && !payPerInfo.active && (
                <AccountTables
                    employees={account.employees}
                    payPeriods={account.payPeriods}
                    addEmp={swapAddEmpState}
                    addPer={swapAddPayPerState}
                    empInfo={chooseEmp}
                    perInfo={choosePayPer}
                />
            )}
        </div>
    );
};

export default AccountHome;
