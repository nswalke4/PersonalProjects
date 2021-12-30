import AllClearButton from "../components/AllClearButton";
import ClearButton from "../components/ClearButton";
import EqualButton from "../components/EqualButton";
import NumberButton from "../components/NumberButton";
import OperationButton from "../components/OperationButton";
import Screen from "../components/Screen";
import { useState } from "react";

const Calculator = () => {
    const [historyScreen, setHistoryScreen] = useState({
        text: "-",
        clearedOnce: false,
    });

    const [currentScreen, setCurrentScreen] = useState({
        text: "0",
        final: true,
    });

    const addToScreen = (value) => {
        if (historyScreen.clearedOnce) {
            setHistoryScreen({
                text: historyScreen.text,
                clearedOnce: false,
            });
        }
        console.log({ value });
        if (currentScreen.final) {
            setCurrentScreen({
                text: value,
                final: false,
            });
        } else {
            const newStr = currentScreen.text + value;
            setCurrentScreen({
                text: newStr,
                final: false,
            });
        }
        console.log(currentScreen);
    };

    const calculate = (equationText) => {};

    const calculateResult = () => {
        setHistoryScreen({
            text: currentScreen.text,
            clearedOnce: false,
        });
        setCurrentScreen({
            text: calculate(currentScreen.text),
            final: true,
        });
    };

    const deleteFromScreen = () => {
        if (historyScreen.clearedOnce) {
            setHistoryScreen({
                text: historyScreen.text,
                clearedOnce: false,
            });
        }
        if (currentScreen.text.length !== 0) {
            if (currentScreen.text.length === 1) {
                setCurrentScreen({
                    text: "0",
                    final: true,
                });
            } else {
                const newStr = currentScreen.text.substring(0, currentScreen.text.length - 1);
                setCurrentScreen({
                    text: newStr,
                    final: false,
                });
            }
        }
    };

    const resetAll = () => {
        setCurrentScreen({
            text: "0",
            final: true,
        });
        if (historyScreen.clearedOnce) {
            setHistoryScreen({
                text: "-",
                clearedOnce: false,
            });
        } else {
            setHistoryScreen({
                text: historyScreen.text,
                clearedOnce: true,
            });
        }
    };

    return (
        <div className="calculator-group">
            <div className="screen-group">
                <Screen topRow={historyScreen.text} bottomRow={currentScreen.text} />
            </div>
            <div className="button-group">
                <div className="button-top-row">
                    <AllClearButton reset={resetAll} />
                    <ClearButton clearOne={deleteFromScreen} />
                    <OperationButton action="divide" insert={addToScreen} />
                </div>
                <div className="button-second-row">
                    <NumberButton value="7" insert={addToScreen} />
                    <NumberButton value="8" insert={addToScreen} />
                    <NumberButton value="9" insert={addToScreen} />
                    <OperationButton action="multiply" insert={addToScreen} />
                </div>
                <div className="button-third-row">
                    <NumberButton value="4" insert={addToScreen} />
                    <NumberButton value="5" insert={addToScreen} />
                    <NumberButton value="6" insert={addToScreen} />
                    <OperationButton action="subtract" insert={addToScreen} />
                </div>
                <div className="button-fourth-row">
                    <NumberButton value="1" insert={addToScreen} />
                    <NumberButton value="2" insert={addToScreen} />
                    <NumberButton value="3" insert={addToScreen} />
                    <OperationButton action="add" insert={addToScreen} />
                </div>
                <div className="button-bottom-row">
                    <NumberButton value="0" insert={addToScreen} />
                    <NumberButton value="." insert={addToScreen} />
                    <EqualButton calculate={calculateResult} />
                </div>
            </div>
        </div>
    );
};

export default Calculator;
