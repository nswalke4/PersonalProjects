import TimecardTable from "./TimecardTable";

const PayPeriodInfo = ({ onClose, payPeriod }) => {
    return (
        <div className="pay-period-info">
            <p>Pay Period Information will go here...</p>
            <p>Pay Period ID: {payPeriod}</p>
            <TimecardTable info={payPeriod.timecards} />
            <button onClick={onClose}>Close</button>
        </div>
    );
};

export default PayPeriodInfo;
