const NumberButton = ({ value, insert }) => {
    return (
        <button className="number-button" onClick={() => insert(value)}>
            {value}
        </button>
    );
};

export default NumberButton;
