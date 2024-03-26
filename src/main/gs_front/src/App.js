// src/main/frontend/src/App.js

import React, {useEffect, useState} from 'react';
import axios from 'axios';
import logo from './logo.svg';
import './App.css';

function App() {
   const [message, setMassage] = useState('')

    useEffect(() => {
        axios.get('/api/hello')
        .then(response => setMassage(response.data))
        .catch(error => console.log(error))
    }, []);

    return (
       <div className="App">
          <header className="App-header">
              <img src={logo} className="App-logo" alt="logo"/>
              <h1 className="App-title">{message}</h1>
          </header>
          <p className="App-intro">
              To get started, edit <code>src/App.js</code> and save to reload.
          </p>
      </div>
    );
}

export default App;