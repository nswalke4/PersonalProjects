import { useState } from "react";

const ChooseEmployee = (employees, createNewEmployeeTimecard) => {
    const [selectedIndex, setSelectedIndex] = useState(0);
    const changeSelected = (e) => {
        setSelectedIndex(e.target.value);
    };

    return (
        <form className="choose-emp" onSubmit={() => createNewEmployeeTimecard(selectedIndex)}>
            Select Employee to Create Timecard for:{"  "}
            <select name="select-emp" defaultValue={selectedIndex} onChange={changeSelected}>
                {employees.map((emp, index) => {
                    return (
                        <option key={emp.id} value={index}>
                            {emp.firstName} {emp.lastName}
                        </option>
                    );
                })}
            </select>
            <input name="selected-submit" type="submit" value="Add Timecard" />
        </form>
    );
};

export default ChooseEmployee;
