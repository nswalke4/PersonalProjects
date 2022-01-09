import { useState } from "react";
import { FcApproval, FcCancel } from "react-icons/fc";

/* The Add Employee Timecard component contains the form to gather the necessary infromation to create a new timecard for
the given employee. */
const AddEmployeeTimecard = ({ employee, index, onSave }) => {
    // The New Timecard information objects
    const [regularHours, setRegularHours] = useState(0);
    const [overtimeHours, setOvertimeHours] = useState(0);
    const [bonusPay, setBonusPay] = useState(0);
    const [otherPay, setOtherPay] = useState(0);

    // Object that represents whether the form has been submitted and the timecard information has been "saved"
    const [saved, setSaved] = useState(false);
    const save = () => {
        setSaved(true);
        onSave(index, employee.id, regularHours, overtimeHours, bonusPay, otherPay);
    };

    // Presents the user with a form to fill in the information about the given employee's timecard, and includes an icon
    // that informs the user if the given timecard has been "saved".
    return (
        <div className="add-employee-timecard">
            {employee.id} - {employee.firstName} {employee.lastName}
            <input name="save-timecard-button" type="button" onClick={save} value="Save Timecard" />
            <br />
            Regular Hours:
            <input
                name="reg-hrs-input"
                type="number"
                step="0.01"
                placeholder={regularHours}
                onChange={(e) => setRegularHours(e.target.value)}
            />
            Overtime Hours:
            <input
                name="over-hrs-input"
                type="number"
                step="0.01"
                placeholder={overtimeHours}
                onChange={(e) => setOvertimeHours(e.target.value)}
            />
            Bonus Pay:
            <input
                name="bonus-pay-input"
                type="number"
                step="0.01"
                placeholder={bonusPay}
                onChange={(e) => setBonusPay(e.target.value)}
            />
            Other Pay:
            <input
                name="other-pay-input"
                type="number"
                step="0.01"
                placeholder={otherPay}
                onChange={(e) => setOtherPay(e.target.value)}
            />
            {!saved && <FcCancel style={{ fontSize: "25px" }} />}
            {saved && <FcApproval style={{ fontSize: "25px" }} />}
        </div>
    );
};

export default AddEmployeeTimecard;
