import AccountHome from "./containers/AccountHome";
import Goal from "./Goal";

function App() {
    const showGoal = false;

    return (
        <div className="App">
            {showGoal && <Goal />}
            {!showGoal && <AccountHome />}
        </div>
    );
}

export default App;
