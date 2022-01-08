import AddEmployeeTimecard from "../components/AddEmployeeTimecard";
import EmployeeCheckbox from "../components/EmployeeCheckbox";
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
    const selectedEmployees = () => {
        const selectedEmployeesArr = [];
        employees.forEach((emp, index) => {
            if (selected.has(index)) {
                selectedEmployeesArr.push(emp);
            }
        });
        return selectedEmployeesArr;
    };

    const [submittedPayPeriod, setSubmittedPayPeriod] = useState(false);
    const flipSumbitted = () => {
        setSubmittedPayPeriod(!submittedPayPeriod);
    };
    const submitPayPeriodForm = (e) => {
        e.preventDefault();
        console.log(`Start Date: ${startDate.date}\nSelected Employees: `);
        console.log(selected);
        setupTimecards();
        flipSumbitted();
    };

    const [timecards, setTimecards] = useState([]);
    const setupTimecards = () => {
        selectedEmployees().forEach((emp) => {
            const newTimecards = [...timecards];
            newTimecards.push({
                empId: emp.id,
                regHrs: 0,
                overHrs: 0,
                bonus: 0,
                other: 0,
                saved: false,
            });
            setTimecards(newTimecards);
        });
    };
    const updateTimecard = (index, regHrs, overHrs, bonus, other) => {
        const newTimecards = [...timecards];
        newTimecards[index] = {
            empId: newTimecards[index].empId,
            regHrs: regHrs,
            overHrs: overHrs,
            bonus: bonus,
            other: other,
            saved: true,
        };
        console.log(newTimecards[index]);
        setTimecards(newTimecards);
    };

    const submitEmployeeTimecardsForm = (e) => {
        e.preventDefault();
        console.log("Employee Timecards Submitted");
        console.log(timecards);
    };

    return (
        <div className="add-pay-period">
            <button onClick={onClose}>Go Back</button>
            <br />
            {!submittedPayPeriod && (
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
                            <EmployeeCheckbox
                                key={index}
                                employee={emp}
                                index={index}
                                onChange={flipSelected}
                            />
                        );
                    })}
                    <input name="index-submit" type="submit" value="Add Pay Period" />
                </form>
            )}
            {submittedPayPeriod && (
                <form
                    className="add-employees-timecards-form"
                    onSubmit={submitEmployeeTimecardsForm}
                >
                    <h3>Pay Period Start Date: {startDate.date}</h3>
                    {selectedEmployees().map((emp, index) => {
                        return (
                            <AddEmployeeTimecard
                                key={index}
                                employee={emp}
                                index={index}
                                onSave={updateTimecard}
                            />
                        );
                    })}
                    <input name="timecards-submit" type="submit" value="Add Timecards" />
                </form>
            )}
        </div>
    );
};

export default AddPayPeriod;
