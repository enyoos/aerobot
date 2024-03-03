import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import make from './make';

make("http://localhost:3000", "root");

const root = ReactDOM.createRoot(document.getElementById('otherroot'));

root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);