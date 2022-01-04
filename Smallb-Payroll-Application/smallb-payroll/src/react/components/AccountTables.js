import EmployeesTable from "./EmployeesTable";
import PayPeriodsTable from "./PayPeriodsTable";

const AccountTables = ({ employees, addEmp, empInfo, payPeriods, addPer, perInfo }) => {
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

export default AccountTables;
