import EmployeesTable from "../components/EmployeesTable";
import PayPeriodsTable from "../components/PayPeriodsTable";

const AccountInfo = ({ employees, payPeriods, addEmp, addPer, empInfo, perInfo }) => {
    return (
        <div className="account-tables">
            <EmployeesTable employees={employees} addEmployee={addEmp} selectEmployee={empInfo} />
            <div className="break" />
            <PayPeriodsTable
                payPeriods={payPeriods}
                addPayPeriod={addPer}
                selectPayPeriod={perInfo}
            />
        </div>
    );
};

export default AccountInfo;
