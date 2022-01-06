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

    const createNewPayPeriod = (e) => {
        e.preventDefault();
        console.log(startDate);
    };

    const [selectedIndex, setSelectedIndex] = useState(0);
    const changeIndex = (e) => {
        setSelectedIndex(e.target.value);
    };

    const createNewEmployeeTimecard = (e) => {
        e.preventDefault();
        console.log(employees[selectedIndex]);
    };

    return (
        <div className="add-pay-period">
            <h3>Add Pay Period will go here...</h3>
            <button onClick={onClose}>Close</button>
            <form className="choose-start-date" onSubmit={createNewPayPeriod}>
                <Datetime
                    initialValue={startDate.date}
                    dateFormat="MM/DD/YYYY"
                    timeFormat={false}
                    closeOnSelect={true}
                    closeOnClickOutside={true}
                    onChange={changeDate}
                />
                <input name="date-submit" type="submit" value="Add Pay Period" />
            </form>
            <br />
            <form className="choose-emp" onSubmit={createNewEmployeeTimecard}>
                Select Employee to Create Timecard for:{"  "}
                <select name="select-emp" defaultValue={selectedIndex} onChange={changeIndex}>
                    {employees.map((emp, index) => {
                        return (
                            <option key={emp.id} value={index}>
                                {emp.firstName} {emp.lastName}
                            </option>
                        );
                    })}
                </select>
                <input name="index-submit" type="submit" value="Add Timecard" />
            </form>
        </div>
    );
};

export default AddPayPeriod;
