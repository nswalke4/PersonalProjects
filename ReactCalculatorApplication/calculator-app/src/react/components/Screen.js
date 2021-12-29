const Screen = ({ topRow, bottomRow }) => {
    return (
        <div className="screen">
            <p className="screen-top">{topRow}</p>
            <hr />
            <p className="screen-bottom">{bottomRow}</p>
        </div>
    );
};

export default Screen;
