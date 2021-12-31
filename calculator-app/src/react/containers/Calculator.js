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
    };

    const calculate = (equationText) => {
        const { values, operations, error } = parseEquation(equationText);
        if (error || values.length !== operations.length + 1) {
            return "Syntax Error";
        }
        const secVals = [];
        const secOps = [];
        // First run through only handles multiplication/division
        while (operations.length > 0) {
            const curOp = operations[0];
            if (curOp === "div") {
                const res = values[0] / values[1];
                operations.shift();
                values.shift();
                values.shift();
                values.unshift(res);
            } else if (curOp === "mul") {
                const res = values[0] * values[1];
                operations.shift();
                values.shift();
                values.shift();
                values.unshift(res);
            } else {
                secVals.push(values.shift());
                secOps.push(operations.shift());
            }
        }
        // Add remaining value to secVals
        secVals.push(values.pop());
        // Complete addition/subtraction
        while (secOps.length > 0) {
            const curOp = secOps[0];
            let res;
            if (curOp === "add") {
                res = secVals[0] + secVals[1];
            } else {
                res = secVals[0] - secVals[1];
            }
            secOps.shift();
            secVals.shift();
            secVals.shift();
            secVals.unshift(res);
        }
        if (Number.isInteger(secVals[0])) {
            return secVals[0];
        } else {
            return parseFloat(secVals[0].toPrecision(9));
        }
    };

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

    const parseEquation = (equationText) => {
        const values = [];
        const operations = [];
        let error = false;
        let start = 0;
        for (let i = 0; i < equationText.length - 1; i++) {
            const cur = equationText[i];
            if (isNaN(equationText.substring(start, i + 1))) {
                if (cur === "-" && start === i) {
                } else {
                    if (cur === ".") {
                        error = true;
                    }
                    values.push(Number(equationText.substring(start, i)));
                    if (cur === "+") {
                        operations.push("add");
                    } else if (cur === "-") {
                        operations.push("sub");
                    } else if (cur === "×") {
                        operations.push("mul");
                    } else if (cur === "÷") {
                        operations.push("div");
                    }
                    start = i + 1;
                }
            }
        }
        const lastChar = equationText[equationText.length - 1];
        if (isNaN(lastChar)) {
            if (lastChar === "×") {
                operations.push("mul");
                const val = equationText.substring(start, equationText.length - 1);
                values.push(Number(val));
                values.push(Number(val));
            } else {
                error = true;
            }
        } else {
            values.push(Number(equationText.substring(start)));
        }
        return { values, operations, error };
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
