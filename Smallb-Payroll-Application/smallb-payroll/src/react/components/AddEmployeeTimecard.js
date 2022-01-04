import { useState } from "react";

const AddEmployeeTimecard = ({ employee }) => {
    const [active, setActive] = useState(false);
    const swapActive = () => {
        setActive(!active);
    };

    return (
        <form className="new-timecard">
            {employee.firstName} {employee.lastName}
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Include
            <input name="emp-active" type="checkbox" onChange={swapActive} />
            {active && (
                <div>
                    Regular Hours:
                    <input name="hours" type="number" step="0.01" />
                    Overtime Hours:
                    <input name="hours" type="number" step="0.01" />
                    Bonus Pay:
                    <input name="pay" type="number" step="0.01" />
                    Other Pay:
                    <input name="pay" type="number" step="0.01" />
                </div>
            )}
        </form>
    );
};

export default AddEmployeeTimecard;
