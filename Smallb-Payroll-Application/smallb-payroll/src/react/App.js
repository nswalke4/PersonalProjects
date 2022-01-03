import AccountHome from "./containers/AccountHome";
import Goal from "./Goal";
import { useState } from "react";
import { Amplify } from "aws-amplify";
import { withAuthenticator } from "@aws-amplify/ui-react";
import "@aws-amplify/ui-react/styles.css";
import awsExports from "../aws-exports";
Amplify.configure(awsExports);

function App({ signOut, user }) {
    const [showGoal, setShowGoal] = useState(false);

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
            {!showGoal && <AccountHome account={user} signOut={signOut} />}
        </div>
    );
}

export default withAuthenticator(App);
