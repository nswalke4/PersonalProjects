import React from "react";
import ReactDOM from "react-dom";
import "./resources/GoalStyle.css";
import "./resources/Style.css";
import App from "./react/App";
import Amplify, { Auth } from "aws-amplify";
import awsconfig from "./aws-exports";
Amplify.configure(awsconfig);

ReactDOM.render(
    <React.StrictMode>
        <App />
    </React.StrictMode>,
    document.getElementById("root")
);
