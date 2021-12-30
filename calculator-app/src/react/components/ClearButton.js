import backspace from "../../resources/backspace.jpg";

const ClearButton = () => {
    const clickAction = () => {
        console.log("Backspace");
    };

    return (
        <button className="clear-button" onClick={clickAction}>
            <img src={backspace} alt="C" />
        </button>
    );
};

export default ClearButton;
