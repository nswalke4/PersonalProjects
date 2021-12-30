const NumberButton = ({ value }) => {
    const clickAction = () => {
        console.log({value})
    }
    
    return (
        <button className="number-button" onClick={clickAction}>
            {value}
        </button>
    );
};

export default NumberButton;
