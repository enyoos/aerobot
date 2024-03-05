import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import make from './make';



make("http://localhost:3000", "chat");

const root = ReactDOM.createRoot(document.getElementById('main'));

root.render(
  // remove the strict mode on deploy
  <React.StrictMode>
    <App/>
  </React.StrictMode>
);