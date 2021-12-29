import backspace from "../../resources/backspace.jpg";

const ClearButton = () => {
    return (
        <button className="clear-button">
            <img src={backspace} alt="C" />
        </button>
    );
};

export default ClearButton;
