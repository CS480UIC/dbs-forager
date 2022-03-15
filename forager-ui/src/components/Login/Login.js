import React, { useState } from 'react';
import './Login.css';
import profile from "./forgLogo.JPG"
import email from "./mail.png";
import pass from "./lock.jpg";
function Login(props) {
  const [enteredUsername, setEnteredUsername] = useState("");
  const [enteredPassword, setEnteredPassword] = useState("");
  const userNameChangeHandler = (event) => {
    setEnteredUsername(event.target.value);
  }
  const passwordChangeHandler = (event) => {
    setEnteredPassword(event.target.value);
  }
  const submitHandler = (event) => {
    event.preventDefault();
    const loginData = {
      username: enteredUsername,
      password: enteredPassword,
      email: ""
    };
    props.onLogon(loginData);
    setEnteredUsername("");
    setEnteredPassword("");
  };
  return (
    <div className="main">
      <div className="sub-main">
        <form>
          <div>
            <div className="imgs">
              <div className="container-image">
                <img src={profile} alt="profile" className="profile" />
              </div>
            </div>
            <div style={{ margin: "bottom" }}>
              <div>
                <img src={email} alt="email" className="email" />
                <input type="text" placeholder="username" className="login-input name" onChange={userNameChangeHandler} />
              </div>
              <div className="second-input">
                <img src={pass} alt="pass" className="email" />
                <input type="password" placeholder="password" className="login-input name" onChange={passwordChangeHandler} />
              </div>
              <div className="buttonContainer">
                <div className="login-button">
                  <button className='button' onClick={submitHandler}>Login</button>
                </div>
                <div className="login-button">
                  <button className='button' onClick={props.signUpHandler}>Sign Up</button>
                </div>
              </div>
              {props.login && <div className="errorMessageContainer">{props.response.data}</div>}
            </div>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;