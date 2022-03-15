import React, { useReducer } from "react";
import "./Login.css";
import profile from "./forgLogo.JPG";
import email from "./mail.png";
import pass from "./lock.jpg";
function Registration(props) {
  const [userData, setUserData] = useReducer({
    username: "",
    email: "",
    password: "",
    fullName: "",
    phone: "",
    address: "",
  });
  const submitHandler = (event) => {
    event.preventDefault();
    props.onSubmit(userData);
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
                  className="name"
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
                    className="name"
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
                    className="name"
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
                    className="name"
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
                    className="name"
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
                  className="name"
                  onChange={(e) =>
                    setUserData({ ...userData, password: e.target.value })}
                />
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
