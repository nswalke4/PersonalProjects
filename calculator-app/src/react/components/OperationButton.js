const OperationButton = ({ action }) => {
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

    const clickAction = () => {
        console.log({ action });
    };

    return (
        <button className="operation-button" onClick={clickAction}>
            {value}
        </button>
    );
};

export default OperationButton;
