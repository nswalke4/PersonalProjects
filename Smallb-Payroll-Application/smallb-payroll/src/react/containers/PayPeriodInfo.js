import React from "react";

const PayPeriodInfo = ({ onClose, payPeriod }) => {
    return (
        <div className="pay-period-info">
            <p>Pay Period Information will go here...</p>
            <p>Pay Period ID: {payPeriod}</p>
            <button onClick={onClose}>Close</button>
        </div>
    );
};

export default PayPeriodInfo;
