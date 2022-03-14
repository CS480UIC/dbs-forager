import React, { useState } from 'react';
import './Login.css';
import profile from "./forgLogo.JPG"
import email from "./mail.png";
import pass from "./lock.jpg";
function Registration(props) {
    const [enteredUsername, setEnteredUsername] = useState("");
    const [enteredPassword, setEnteredPassword] = useState("");
    const [enteredEmail, setEnteredEmail] = useState("");
    const userNameChangeHandler = (event) => {
        setEnteredUsername(event.target.value);
    }
    const passwordChangeHandler = (event) => {
        setEnteredPassword(event.target.value);
    }
    const emailChangeHandler = (event) => {
        setEnteredEmail(event.target.value);
    }
    const submitHandler = (event) => {
        event.preventDefault();
        const userData = {
            username: enteredUsername,
            password: enteredPassword,
            email: enteredEmail
        };
        props.onSubmit(userData);
        setEnteredUsername("");
        setEnteredPassword("");
        setEnteredEmail("");
    };
    return (
        <div className="main">
            <div className="sub-main">
                <form onSubmit={submitHandler}>
                    <div>
                        <div className="imgs">
                            <div className="container-image">
                                <img src={profile} alt="profile" className="profile" />
                            </div>
                        </div>
                        <div style={{ margin: "bottom" }}>
                            <div>
                                <img src={email} alt="email" className="email" />
                                <input type="text" placeholder="username" className="name" onChange={userNameChangeHandler} />
                            </div>
                            <div className="second-input">
                                <div>
                                    <img src={email} alt="email" className="email" />
                                    <input type="text" placeholder="email" className="name" onChange={emailChangeHandler} />
                                </div>
                            </div>
                            <div className="second-input">
                                <img src={pass} alt="pass" className="email" />
                                <input type="password" placeholder="password" className="name" onChange={passwordChangeHandler} />
                            </div>
                            <div className="buttonContainer">
                                <div className="login-button">
                                    <button type="Submit">Sign Up</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default Registration;