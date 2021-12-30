const Screen = ({ topRow, bottomRow }) => {
    return (
        <div className="screen">
            <input type="text" id="screen-top" readOnly value={topRow} />
            <input type="text" id="screen-bottom" readOnly value={bottomRow} />
        </div>
    );
};

export default Screen;
