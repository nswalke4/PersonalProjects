import AddEmployeeTimecard from "../components/AddEmployeeTimecard";
import { useState } from "react";
import Datetime from "react-datetime";

const AddPayPeriod = ({ employees, onClose }) => {
    const formatDate = (date) => {
        return `${(date.getMonth() + 1).toString().padStart(2, "0")}/${date
            .getDate()
            .toString()
            .padStart(2, "0")}/${date.getFullYear()}`;
    };

    const [startDate, chosenStartDate] = useState({
        date: formatDate(new Date()),
    });
    const changeDate = (newDate) => {
        console.log(newDate);
        chosenStartDate({ date: formatDate(newDate._d) });
    };

    const [selected] = useState(new Set());
    const flipSelected = (index) => {
        console.log(index);
        if (selected.has(index)) {
            selected.delete(index);
        } else {
            selected.add(index);
        }
    };

    const submitPayPeriodForm = (e) => {
        e.preventDefault();
        console.log(`Start Date: ${startDate.date}\nSelected Employees: `);
        console.log(selected);
    };

    return (
        <div className="add-pay-period">
            <h3>Add Pay Period will go here...</h3>
            <button onClick={onClose}>Close</button>
            <br />
            <form className="add-pay-period-form" onSubmit={submitPayPeriodForm}>
                Start Date:{" "}
                <Datetime
                    initialValue={startDate.date}
                    dateFormat="MM/DD/YYYY"
                    timeFormat={false}
                    closeOnSelect={true}
                    closeOnClickOutside={true}
                    onChange={changeDate}
                />
                Select which employees to create timecards for in this Pay Period:
                {employees.map((emp, index) => {
                    return (
                        <label key={emp.id}>
                            <input
                                key={emp.id}
                                type="checkbox"
                                value={index}
                                onChange={() => flipSelected(index)}
                            />
                            {emp.firstName} {emp.lastName}
                        </label>
                    );
                })}
                <input name="index-submit" type="submit" value="Add Pay Period" />
            </form>
        </div>
    );
};

export default AddPayPeriod;
