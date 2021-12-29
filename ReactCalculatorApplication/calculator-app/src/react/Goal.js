const Goal = () => {
    return (
        <div className="App">
            <div className="about-project">
                <h1>Project Header</h1>
                <p>About the Project...</p>
            </div>
            <div className="calculator-group">
                <div className="screen-group">
                    <div className="screen">
                        <p>This is where the results will go...</p>
                    </div>
                </div>
                <div className="button-group">
                    <div className="button-top-row">
                        <button className="all-clear-button">AC</button> 
                        <button className="clear-button">C</button>
                        <button className="other-button">/</button>
                    </div>
                    <div className="button-second-row">
                        <button className="number-button">7</button>
                        <button className="number-button">8</button>
                        <button className="number-button">9</button>
                        <button className="other-button">*</button>
                    </div>
                    <div className="button-third-row">
                        <button className="number-button">4</button>
                        <button className="number-button">5</button>
                        <button className="number-button">6</button>
                        <button className="other-button">-</button>
                    </div>
                    <div className="button-fourth-row">
                        <button className="number-button">1</button>
                        <button className="number-button">2</button>
                        <button className="number-button">3</button>
                        <button className="other-button">+</button>
                    </div>
                    <div className="button-bottom-row">
                        <button className="number-button">0</button>
                        <button className="number-button">.</button>
                        <button className="other-button">=</button>
                    </div>
                </div>
            </div>
            <div className="about-developer">
                <p>About the developer...</p>
            </div>
        </div>
    )
}

export default Goal
