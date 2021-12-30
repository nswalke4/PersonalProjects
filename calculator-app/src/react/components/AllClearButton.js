const AllClearButton = () => {
    const clickAction = () => {
        console.log("All Clear");
    };

    return (
        <button className="all-clear-button" onClick={clickAction}>
            AC
        </button>
    );
};

export default AllClearButton;
