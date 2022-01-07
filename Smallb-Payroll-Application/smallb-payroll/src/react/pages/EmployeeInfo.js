import TimecardsTable from "../components/TimecardsTable";
import { useState } from "react";

const EmployeeInfo = ({ onClose, employee }) => {
    const [timecards] = useState([
        {
            empId: employee.id,
            perId: "1-P-0001",
            regHrs: 40,
            overHrs: 10,
            bonus: 0,
            other: 100,
        },
        {
            empId: employee.id,
            perId: "1-P-0002",
            regHrs: 35,
            overHrs: 10,
            bonus: 250,
            other: 0,
        },
        {
            empId: employee.id,
            perId: "1-P-0003",
            regHrs: 40,
            overHrs: 5,
            bonus: 0,
            other: 0,
        },
    ]);

    return (
        <div className="employee-info">
            <p>Employee ID: {employee.id}</p>
            <p>
                Name: {employee.firstName} {employee.lastName}
            </p>
            <p>Employee Type: {employee.type}</p>
            <p>Pay Rate: {employee.payRate}</p>
            <TimecardsTable timecards={timecards} isEmployee={true} />
            <button onClick={onClose}>Close</button>
        </div>
    );
};

export default EmployeeInfo;
