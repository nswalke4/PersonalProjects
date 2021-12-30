import AllClearButton from "../components/AllClearButton";
import ClearButton from "../components/ClearButton";
import EqualButton from "../components/EqualButton";
import NumberButton from "../components/NumberButton";
import OperationButton from "../components/OperationButton";
import Screen from "../components/Screen";
import { useState } from "react";

const Calculator = () => {
    const [history, setHistory] = useState(["43+17"]);
    const [current, setCurrent] = useState(["60"]);

    return (
        <div className="calculator-group">
            <div className="screen-group">
                <Screen topRow={history} bottomRow={current} />
            </div>
            <div className="button-group">
                <div className="button-top-row">
                    <AllClearButton />
                    <ClearButton />
                    <OperationButton action="divide" />
                </div>
                <div className="button-second-row">
                    <NumberButton value="7" />
                    <NumberButton value="8" />
                    <NumberButton value="9" />
                    <OperationButton action="multiply" />
                </div>
                <div className="button-third-row">
                    <NumberButton value="4" />
                    <NumberButton value="5" />
                    <NumberButton value="6" />
                    <OperationButton action="subtract" />
                </div>
                <div className="button-fourth-row">
                    <NumberButton value="1" />
                    <NumberButton value="2" />
                    <NumberButton value="3" />
                    <OperationButton action="add" />
                </div>
                <div className="button-bottom-row">
                    <NumberButton value="0" />
                    <NumberButton value="." />
                    <EqualButton />
                </div>
            </div>
        </div>
    );
};

export default Calculator;
