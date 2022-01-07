import { useState } from "react";
import { FcApproval, FcCancel } from "react-icons/fc";

const AddEmployeeTimecard = ({ employee, index, onSave }) => {
    const [regularHours, setRegularHours] = useState(0);
    const [overtimeHours, setOvertimeHours] = useState(0);
    const [bonusPay, setBonusPay] = useState(0);
    const [otherPay, setOtherPay] = useState(0);

    const [saved, setSaved] = useState(false);
    const save = () => {
        setSaved(true);
        onSave(index, regularHours, overtimeHours, bonusPay, otherPay);
    };

    return (
        <div className="add-employee-timecard">
            {employee.id} - {employee.firstName} {employee.lastName}
            <input type="button" onClick={save} value="Save Timecard" />
            <br />
            Regular Hours:
            <input
                type="number"
                step="0.01"
                placeholder={regularHours}
                onChange={(e) => setRegularHours(e.target.value)}
            />
            Overtime Hours:
            <input
                type="number"
                step="0.01"
                placeholder={overtimeHours}
                onChange={(e) => setOvertimeHours(e.target.value)}
            />
            Bonus Pay:
            <input
                type="number"
                step="0.01"
                placeholder={bonusPay}
                onChange={(e) => setBonusPay(e.target.value)}
            />
            Other Pay:
            <input
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
