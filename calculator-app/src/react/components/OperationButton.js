const OperationButton = ({ action, insert }) => {
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

    return (
        <button className="operation-button" onClick={() => insert(value)}>
            {value}
        </button>
    );
};

export default OperationButton;
