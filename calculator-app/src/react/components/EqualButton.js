const EqualButton = () => {
    const clickAction = () => {
        console.log("Equals...");
    };

    return (
        <button className="equal-button" onClick={clickAction}>
            =
        </button>
    );
};

export default EqualButton;
