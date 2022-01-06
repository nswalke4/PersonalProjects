import { useState } from "react";

const AddEmployeeTimecard = ({ employee }) => {
    const [active, setActive] = useState(false);
    const swapActive = () => {
        setActive(!active);
    };

    return <p>This will be where the "add employee timecard" will go</p>;
};

export default AddEmployeeTimecard;
