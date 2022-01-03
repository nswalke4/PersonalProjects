import AccountHome from "./containers/AccountHome";
import Goal from "./Goal";
import { Amplify } from "aws-amplify";
import { withAuthenticator } from "@aws-amplify/ui-react";
import "@aws-amplify/ui-react/styles.css";
import awsExports from "../aws-exports";
Amplify.configure(awsExports);

function App({ signOut, user }) {
    const showGoal = false;

    return (
        <div className="App">
            {showGoal && <Goal />}
            {!showGoal && <AccountHome account={user} signOut={signOut} />}
        </div>
    );
}

export default withAuthenticator(App);
