import React, { useState } from "react";
import "./Login.css";
import profile from "./forgLogo.JPG";
import email from "./mail.png";
import pass from "./lock.jpg";
import { useHistory } from "react-router-dom/cjs/react-router-dom.min";
import axios from "axios";

function Login({}) {
  const history = useHistory();
  const [errorMessage, setErrorMessage] = useState("");
  const [loginData, setLoginData] = useState({
    username: "",
    password: "",
  });

  const loginHandler = async () => {
    const res = await axios.post("http://localhost:8081/demo/Login", loginData);
    if (res.data === "Authenticated") history.push("/");
    else setErrorMessage(res.data);
  };

  const signUpClicked = () => {
    history.push("/registration");
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
                <input
                  type="text"
                  placeholder="Username"
                  className="login-input name"
                  onChange={(e) =>
                    setLoginData({ ...loginData, username: e.target.value })
                  }
                />
              </div>
              <div className="second-input">
                <img src={pass} alt="pass" className="email" />
                <input
                  type="password"
                  placeholder="Password"
                  className="login-input name"
                  onChange={(e) =>
                    setLoginData({ ...loginData, password: e.target.value })
                  }
                />
              </div>
              <div className="buttonContainer">
                <div className="login-button">
                  <button className="button" onClick={loginHandler}>
                    Login
                  </button>
                </div>
                <div className="login-button">
                  <button className="button" onClick={signUpClicked}>
                    Sign Up
                  </button>
                </div>
              </div>
              <div className="errorMessageContainer">{errorMessage}</div>
            </div>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Login;
