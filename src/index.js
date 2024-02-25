import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

import {renderXatkitWidget} from 'xatkit-chat-widget'
import 'xatkit-chat-widget/lib/xatkit.css';

renderXatkitWidget({
  elementId : "root",
  widget : {
    title : "Rosemont bot",
    subtitle : "Parle avec roseBot🤖",
    startMinimized : true, // when push to prod, toggle true
    placeHolders : {
      sender : "Écrit moi quelque chose",
      buttons : "Choisis une option",
    },
    images : {
      profileAvatar  : process.env.PUBLIC_URL + "/rosemont.svg",
      // launcherImage : process.env.PUBLIC_URL + "/rosemont.svg",
    }
  }
})

const root = ReactDOM.createRoot(document.getElementById('otherroot'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
// reportWebVitals();
