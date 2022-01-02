import AccountInfo from "./containers/AccountInfo.js";
import AddEmployee from "./containers/AddEmployee.js";
import AddPayPeriod from "./containers/AddPayPeriod.js";
import EmployeeInfo from "./containers/EmployeeInfo.js";
import PayPeriodInfo from "./containers/PayPeriodInfo.js";
import Goal from "./Goal.js";
import { useState } from "react";

function App() {
    const [showGoal, setShowGoal] = useState(true);

    const swapGoalVsActual = () => {
        setShowGoal(!showGoal);
    };

    const goalOrActual = () => {
        if (showGoal) {
            return "Goal";
        } else {
            return "Actual";
        }
    };

    const [addEmpActive, setAddEmpActive] = useState(false);

    const swapAddEmpState = () => {
        setAddEmpActive(!addEmpActive);
    };

    const [addPayPerActive, setAddPayPerActive] = useState(false);

    const swapAddPayPerState = () => {
        setAddPayPerActive(!addPayPerActive);
    };

    const [empInfoActive, setEmpInfoActive] = useState(false);

    const swapEmpInfoState = () => {
        setEmpInfoActive(!empInfoActive);
    };

    const [payPerInfoActive, setPayPerInfoActive] = useState(false);

    const swapPayPerInfoState = () => {
        setPayPerInfoActive(!payPerInfoActive);
    };

    return (
        <div className="App">
            <div className="header">
                <p className="goalOrActual">{goalOrActual()}</p>
                <button className="swapButton" onClick={swapGoalVsActual}>
                    Switch Version
                </button>
            </div>
            <hr />
            <div className="body">
                {showGoal && <Goal />}
                {!showGoal && addEmpActive && <AddEmployee onClose={swapAddEmpState} />}
                {!showGoal && addPayPerActive && <AddPayPeriod onClose={swapAddPayPerState} />}
                {!showGoal && empInfoActive && <EmployeeInfo onClose={swapEmpInfoState} />}
                {!showGoal && payPerInfoActive && <PayPeriodInfo onClose={swapPayPerInfoState} />}
                {!showGoal &&
                    !addEmpActive &&
                    !addPayPerActive &&
                    !empInfoActive &&
                    !payPerInfoActive && (
                        <AccountInfo
                            addEmp={swapAddEmpState}
                            addPer={swapAddPayPerState}
                            empInfo={swapEmpInfoState}
                            perInfo={swapPayPerInfoState}
                        />
                    )}
            </div>
        </div>
    );
}

export default App;
