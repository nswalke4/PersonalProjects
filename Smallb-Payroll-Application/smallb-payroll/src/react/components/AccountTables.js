import EmployeesTable from "./EmployeesTable";
import PayPeriodsTable from "./PayPeriodsTable";

/* The Account Tables component contains the Employees Table and Pay Periods Table components, and is used as the main 
component in the "Account Home" container. */
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
