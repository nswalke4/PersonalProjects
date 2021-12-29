const Screen = ({ expression, result }) => {
    return (
        <div className="screen">
            <p className="screen-top">{expression}</p>
            <hr />
            <p className="screen-bottom">{result}</p>
        </div>
    );
};

export default Screen;
