import AddEmployeeTimecard from "../components/AddEmployeeTimecard";
import { useState } from "react";

const AddPayPeriod = ({ employees, onClose }) => {
    const [showTimecards, setShowTimecards] = useState(false);
    const swapShowTimecards = () => {
        setShowTimecards(!showTimecards);
    };

    return (
        <div className="add-pay-period">
            <h1>Add Pay Period will go here...</h1>
            <button onClick={onClose}>Close</button>
            <form className="new-pay-period">
                Start Date: <input name="start-date" type="date" />
                Create Timecards?{" "}
                <input name="create-timecards" type="checkbox" onChange={swapShowTimecards} />
            </form>
            <br />
            {showTimecards &&
                employees.map((emp) => {
                    return <AddEmployeeTimecard employee={emp} />;
                })}
        </div>
    );
};

export default AddPayPeriod;
