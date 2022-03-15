import React, { useState } from "react";
import { useHistory } from "react-router-dom/cjs/react-router-dom.min";
import "./Login.css";
import profile from "./forgLogo.JPG";
import email from "./mail.png";
import pass from "./lock.jpg";
import axios from "axios";

function Registration({}) {
  const history = useHistory();
  const [userData, setUserData] = useState({
    username: "",
    email: "",
    password: "",
    fullName: "",
    phone: "",
    address: "",
  });

  const submitHandler = (event) => {
    event.preventDefault();
    axios.post('http://localhost:8081/demo/registration/saveUser', userData);
    history.push("/login");
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
                <input
                  type="text"
                  placeholder="Username"
                  className="name login-input"
                  onChange={(e) =>
                    setUserData({ ...userData, username: e.target.value })
                  }
                />
              </div>
              <div className="second-input">
                <div>
                  <img src={email} alt="email" className="email" />
                  <input
                    type="text"
                    placeholder="Full Name"
                    className="name login-input"
                    onChange={(e) =>
                        setUserData({ ...userData, fullName: e.target.value })}
                  />
                </div>
              </div>
              <div className="second-input">
                <div>
                  <img src={email} alt="email" className="email" />
                  <input
                    type="text"
                    placeholder="Email"
                    className="name login-input"
                    onChange={(e) =>
                        setUserData({ ...userData, email: e.target.value })}
                  />
                </div>
              </div>
              <div className="second-input">
                <div>
                  <img src={email} alt="email" className="email" />
                  <input
                    type="text"
                    placeholder="Contact Number"
                    className="name login-input"
                    onChange={(e) =>
                        setUserData({ ...userData, phone: e.target.value })}
                  />
                </div>
              </div>
              <div className="second-input">
                <div>
                  <img src={email} alt="email" className="email" />
                  <input
                    type="text"
                    placeholder="Address"
                    className="name login-input"
                    onChange={(e) =>
                        setUserData({ ...userData, address: e.target.value })}
                  />
                </div>
              </div>
              <div className="second-input">
                <img src={pass} alt="pass" className="email" />
                <input
                  type="password"
                  placeholder="Password"
                  className="name login-input"
                  onChange={(e) =>
                    setUserData({ ...userData, password: e.target.value })}
                />
              </div>
              <div className="buttonContainer">
                <div className="login-button">
                  <button type="Submit" className="button">Sign Up</button>
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
