import AddEmployeeTimecard from "../components/AddEmployeeTimecard";
import EmployeeCheckbox from "../components/EmployeeCheckbox";
import { useState } from "react";
import Datetime from "react-datetime";

/* The Add Pay Period container contains the ability to create a new Pay Period for the Account object, as well as the
ability to choose which employees to create timecards for during this pay period (and then the ability to create those
timecards).  This container contains the methods to switch the view to the "create timecards" view after the new pay period
and the employees to create timecards for during that period have been chosen. */
const AddPayPeriod = ({ employees, onClose }) => {
    // Basic method to ensure that the date is provided in the requested format ("MM-DD-YYYY")
    const formatDate = (date) => {
        return `${(date.getMonth() + 1).toString().padStart(2, "0")}/${date
            .getDate()
            .toString()
            .padStart(2, "0")}/${date.getFullYear()}`;
    };

    // The date the New Pay Period will start on (the end date will be determined automatically)
    const [startDate, chosenStartDate] = useState({
        date: formatDate(new Date()),
    });
    const changeDate = (newDate) => {
        console.log(newDate);
        chosenStartDate({ date: formatDate(newDate._d) });
    };

    // Set of the indexes of the employees array to show which employees have been selected to add timecards for
    const [selected] = useState(new Set());
    const flipSelected = (index) => {
        console.log(index);
        if (selected.has(index)) {
            selected.delete(index);
        } else {
            selected.add(index);
        }
    };
    // Given the set of selected indexes, returns an array of the selected employee objects
    const selectedEmployees = () => {
        const selectedEmployeesArr = [];
        employees.forEach((emp, index) => {
            if (selected.has(index)) {
                selectedEmployeesArr.push(emp);
            }
        });
        return selectedEmployeesArr;
    };

    // Method to check if the "create new pay period" button has been submitted
    const [submittedPayPeriod, setSubmittedPayPeriod] = useState(false);
    const flipSumbitted = () => {
        setSubmittedPayPeriod(!submittedPayPeriod);
    };
    // Creates the new Pay Period object in the database (currently skips that step, just logs the selected employees),
    // and then prepares to switch to the timecard creation view
    const submitPayPeriodForm = (e) => {
        e.preventDefault();
        console.log(`Start Date: ${startDate.date}\nSelected Employees: `);
        console.log(selected);
        setupTimecards();
        flipSumbitted();
    };

    // The array of new timecards to be added to the database
    const [timecards, setTimecards] = useState([]);
    // Creates a set of new timecards for each employee id to be added to the timecards array
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
    // Updates the given timecard (given by its index) to the given values
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

    // Submits the new employee timecards for the given pay period to be added to the database (currently skips that step
    // and only logs the created timecards).
    const submitEmployeeTimecardsForm = (e) => {
        e.preventDefault();
        console.log("Employee Timecards Submitted");
        console.log(timecards);
    };

    // Presents the user with a screen to choose the start date of the pay period and the employees to create timecards for
    // during the new period, creates the new pay period, and the presents the user with the ability to create new timecards
    // for the chosen employees.
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
