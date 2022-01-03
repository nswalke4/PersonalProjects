import React from "react";

const EmployeeInfo = ({ onClose, employee }) => {
    return (
        <div className="employee-info">
            <p>Employee Information will go here...</p>
            <p>Employee ID: {employee}</p>
            <button onClick={onClose}>Close</button>
        </div>
    );
};

export default EmployeeInfo;
