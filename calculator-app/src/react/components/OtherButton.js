const OtherButton = ({ action }) => {
    let value;

    switch (action) {
        case "divide":
            value = "÷";
            break;
        case "multiply":
            value = "×";
            break;
        case "subtract":
            value = "-";
            break;
        case "add":
            value = "+";
            break;
        default:
            value = "??";
            break;
    }

    return <button className="other-button">{value}</button>;
};

export default OtherButton;
