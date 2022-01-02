import React from "react";

const EmployeeInfo = ({ onClose }) => {
    return (
        <div>
            <p>Employee Information will go here...</p>
            <button onClick={onClose}>Close</button>
        </div>
    );
};

export default EmployeeInfo;
