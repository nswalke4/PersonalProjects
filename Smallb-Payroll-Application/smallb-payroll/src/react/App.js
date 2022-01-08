import AccountHome from "./containers/AccountHome";
import Header from "./containers/Header";

/* The main conatiner of the Smallb Payroll Application. */
function App() {
    return (
        <div className="App">
            <Header />
            <AccountHome />
        </div>
    );
}

export default App;
