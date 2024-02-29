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
    }
  },
  storage : {
    autoClear : true,
  }
})

const root = ReactDOM.createRoot(document.getElementById('otherroot'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);