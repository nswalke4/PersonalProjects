import TimecardsTable from "../components/TimecardsTable";

const EmployeeInfo = ({ onClose, employee }) => {
    const timecards = null;

    return (
        <div className="employee-info">
            <p>Employee Information will go here...</p>
            <p>Employee ID: {employee.id}</p>
            {/* <TimecardsTable timecards={timecards} /> */}
            <button onClick={onClose}>Close</button>
        </div>
    );
};

export default EmployeeInfo;
