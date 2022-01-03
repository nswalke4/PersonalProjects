import AccountTables from "./AccountTables";
import AddEmployee from "./AddEmployee";
import AddPayPeriod from "./AddPayPeriod";
import EmployeeInfo from "./EmployeeInfo";
import PayPeriodInfo from "./PayPeriodInfo";
import { useState } from "react";

const AccountHome = ({ account }) => {
    const [addEmpActive, setAddEmpActive] = useState(false);

    const swapAddEmpState = () => {
        setAddEmpActive(!addEmpActive);
    };

    const [addPayPerActive, setAddPayPerActive] = useState(false);

    const swapAddPayPerState = () => {
        setAddPayPerActive(!addPayPerActive);
    };

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
            <h2>Account ID: {account.sub}</h2>
            {addEmpActive && <AddEmployee onClose={swapAddEmpState} />}
            {addPayPerActive && <AddPayPeriod onClose={swapAddPayPerState} />}
            {empInfo.active && <EmployeeInfo onClose={resetEmp} employee={empInfo.employee} />}
            {payPerInfo.active && (
                <PayPeriodInfo onClose={resetPayPer} payPeriod={payPerInfo.payPeriod} />
            )}
            {!addEmpActive && !addPayPerActive && !empInfo.active && !payPerInfo.active && (
                <AccountTables
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
