import AllClearButton from "../components/AllClearButton";
import ClearButton from "../components/ClearButton";
import EqualButton from "../components/EqualButton";
import NumberButton from "../components/NumberButton";
import OtherButton from "../components/OtherButton";
import Screen from "../components/Screen";

const Calculator = () => {
    return (
        <div className="calculator-group">
            <div className="screen-group">
                <Screen topRow="43+17" bottomRow="60" />
            </div>
            <div className="button-group">
                <div className="button-top-row">
                    <AllClearButton />
                    <ClearButton />
                    <OtherButton action="divide" />
                </div>
                <div className="button-second-row">
                    <NumberButton value="7" />
                    <NumberButton value="8" />
                    <NumberButton value="9" />
                    <OtherButton action="multiply" />
                </div>
                <div className="button-third-row">
                    <NumberButton value="4" />
                    <NumberButton value="5" />
                    <NumberButton value="6" />
                    <OtherButton action="subtract" />
                </div>
                <div className="button-fourth-row">
                    <NumberButton value="1" />
                    <NumberButton value="2" />
                    <NumberButton value="3" />
                    <OtherButton action="add" />
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
