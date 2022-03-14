import React, { useState } from "react";

const Main = (props) => {
    const [buttonClick, setButtonClick] = useState(false);
    return (<div className="container">
        <div className="buttonContainer">
            <button onClick={() => { setButtonClick(true) }}>QueryResults</button>
        </div>
        {buttonClick &&
            <div className="tableContainer">
                <table >
                    <thead>
                        <tr>
                            <td>Username</td>
                            <td>Password</td>
                            <td>Email</td>
                        </tr>
                    </thead>
                    <tbody>{props.users.map((user) => (
                        <tr key={Math.random() * 1000}>
                            <td>{user.username}</td>
                            <td>{user.password}</td>
                            <td>{user.email}</td>
                        </tr>
                    ))
                    } </tbody>
                </table>
            </div>}
    </div>);
}
export default Main;