import TimecardTable from "./TimecardTable";

const EmployeeInfo = ({ onClose, employee }) => {
    return (
        <div className="employee-info">
            <p>Employee Information will go here...</p>
            <p>Employee ID: {employee}</p>
            <TimecardTable info={employee.timecards} />
            <button onClick={onClose}>Close</button>
        </div>
    );
};

export default EmployeeInfo;
