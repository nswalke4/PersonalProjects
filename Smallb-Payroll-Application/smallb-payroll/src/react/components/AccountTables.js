import EmployeesTable from "./EmployeesTable";
import PayPeriodsTable from "./PayPeriodsTable";

const AccountTables = ({ employees, addEmp, empInfo, payPeriods, addPer, perInfo }) => {
    return (
        <div className="account-tables">
            <PayPeriodsTable
                payPeriods={payPeriods}
                addPayPeriod={addPer}
                selectPayPeriod={perInfo}
            />
            <div className="break" />
            <EmployeesTable employees={employees} addEmployee={addEmp} selectEmployee={empInfo} />
        </div>
    );
};

export default AccountTables;
