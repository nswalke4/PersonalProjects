import { useState } from "react";

const AddEmployee = ({ onClose }) => {
    const [firstName, setFirstName] = useState(" ");
    const [lastName, setLastName] = useState(" ");
    const [phoneNum, setPhoneNum] = useState(" ");
    const [type, setType] = useState("HOURLY");
    const [payRate, setPayRate] = useState(" ");

    const addNewEmployee = (e) => {
        e.preventDefault();
        const employee = {
            firstName: firstName,
            lastName: lastName,
            phoneNum: phoneNum,
            type: type,
            payRate: payRate,
        };
        console.log("Add new employee pressed");
        console.log(employee);
    };

    return (
        <div className="add-employee">
            <button onClick={onClose}>Close</button>
            <br />
            <form className="add-employee-form" onSubmit={addNewEmployee}>
                First Name:
                <input
                    name="first-name-input"
                    type="text"
                    placeholder="John"
                    onChange={(e) => setFirstName(e.target.value)}
                    required
                />
                Last Name:
                <input
                    name="last-name-input"
                    type="text"
                    placeholder="Smith"
                    onChange={(e) => setLastName(e.target.value)}
                    required
                />
                Phone Number:
                <input
                    name="phone-num-input"
                    type="tel"
                    pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
                    placeholder="XXX-XXX-XXXX"
                    onChange={(e) => setPhoneNum(e.target.value)}
                />
                <small className="phone-num-patterns">Phone Number Format: XXX-XXX-XXXX</small>
                <div className="employee-type-radio">
                    Employee Type:
                    <input
                        name="employee-type-input"
                        type="radio"
                        value="HOURLY"
                        checked={type === "HOURLY"}
                        onChange={(e) => setType(e.target.value)}
                    />
                    Hourly
                    <input
                        name="employee-type-input"
                        type="radio"
                        value="SALARY"
                        checked={type === "SALARY"}
                        onChange={(e) => setType(e.target.value)}
                    />
                    Salary
                </div>
                Pay Rate:
                <input
                    name="pay-rate-input"
                    type="number"
                    step="0.01"
                    placeholder="7.25"
                    onChange={(e) => setPayRate(e.target.value)}
                    required
                />
                <input name="add-employee-submit" type="submit" value="Add Employee" />
            </form>
        </div>
    );
};

export default AddEmployee;
