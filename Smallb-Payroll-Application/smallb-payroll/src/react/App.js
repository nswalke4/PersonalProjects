import AccountHome from "./containers/AccountHome";
import Login from "./containers/Login";
import Goal from "./Goal";
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

    const [account, setAccount] = useState({
        sub: "test-sub",
    });

    const completeLogin = (accSub) => {
        setAccount({
            sub: accSub,
        });
    };

    return (
        <div className="App">
            <div className="constant-header">
                <p className="goalOrActual">{goalOrActual()}</p>
                <button className="swapButton" onClick={swapGoalVsActual}>
                    Switch Version
                </button>
            </div>
            <hr />
            {showGoal && <Goal />}
            {!showGoal && account.sub === null && <Login login={completeLogin} />}
            {!showGoal && account.sub !== null && <AccountHome account={account} />}
        </div>
    );
}

export default App;
