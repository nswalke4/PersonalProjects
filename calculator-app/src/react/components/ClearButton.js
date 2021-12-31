import backspace from "../../resources/backspace.jpg";

const ClearButton = ({ clearOne }) => {
    return (
        <button className="clear-button" onClick={clearOne}>
            <img src={backspace} alt="C" />
        </button>
    );
};

export default ClearButton;
