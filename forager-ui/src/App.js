import React, { useState, useEffect } from 'react';
import './App.css';
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import Home from './pages/Home';
import Messaging from './pages/Messaging';
import History from './pages/History';
import Donation from './pages/Donor';
import Reception from './pages/Receiver';
import Login from './components/Login/Login';
import axios from 'axios';
import Registration from './components/Login/Registration';
import Main from './pages/Main';

function App() {
  const [login, setLogin] = useState(false);
  const [reg, setReg] = useState(false);
  const [response, setResponse] = useState("");
  const [err, setErr] = useState(false);

  let res;
  const LoginHandler = async (loginData) => {
    res = await axios.post('http://localhost:8081/demo/Login', loginData);
    if (res.data === "Authenticated") setLogin(true);
    else {
      setResponse(res);
      setErr(true);
    }
  };
  const formHandler = (userData) => {
    setReg(false);
    axios.post('http://localhost:8081/demo/registration/saveUser', userData);
  };
  const signUp = () => {
    setReg(true);
    setErr(false);
  }
  const [users, setUsers] = useState([]);
  const USER_GET_REST_API_URL = "http://localhost:8081/demo/getUsers";
  useEffect(async () => {
    const r = await axios.get(USER_GET_REST_API_URL);
    setUsers(r.data);
  }, []);
  return (
    <>{login &&
      <Router>
        <Navbar />
        <Switch>
          <Route path='/' exact component={Home} />
          <Route path='/donation' component={Donation} />
          <Route path='/reception' component={Reception} />
          <Route path='/messaging' component={Messaging} />
          <Route path='/history' component={History} />
          <Route path='/Main' render={(props) => <Main {...props} users={users} />} />
        </Switch>
      </Router>
    }
      {(!login && !reg) && <Login onLogon={LoginHandler} response={response} signUpHandler={signUp} login={err} />}

      {reg && <Registration onSubmit={formHandler} />}
    </>
  );
}

export default App;