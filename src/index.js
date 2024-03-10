import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import {renderXatkitWidget} from 'xatkit-chat-widget'
import 'xatkit-chat-widget/lib/xatkit.css';

renderXatkitWidget({
  elementId : "chat",
  widget : {
    title : "Aerobot",
    subtitle : "Parle avec Aerobot🤖",
    startMinimized : false, // when push to prod, toggle true
    placeHolders : {
      sender : "Écrit moi quelque chose",
      buttons : "Choisis une option",
    },
    images : {
      profileAvatar  : process.env.PUBLIC_URL + "/rosemont.svg",
    }
  },
  location : {
    url : "http://localhost:3000"
  },
  storage : {
    autoClear : true,
  }
});



const root = ReactDOM.createRoot(document.getElementById('main'));

root.render(
 // remove the strict mode on deploy
 <React.StrictMode>
   <App/>
 </React.StrictMode>
);
