import TimecardsTable from "../components/TimecardsTable";

const PayPeriodInfo = ({ onClose, payPeriod }) => {
    const timecards = null;

    return (
        <div className="pay-period-info">
            <p>Pay Period Information will go here...</p>
            <p>Pay Period ID: {payPeriod.id}</p>
            {/* <TimecardsTable timecards={timecards} /> */}
            <button onClick={onClose}>Close</button>
        </div>
    );
};

export default PayPeriodInfo;
