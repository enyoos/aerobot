import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import make from './make';
import { RouterProvider, createBrowserRouter } from 'react-router-dom';
import NewWindow from 'react-new-window';
import Docked from './Components/Docked';


const router = createBrowserRouter([
  {
    path : "/",
    element : <App/>
  },
  {
    path : "/docked",
    element: <Docked/>
  }
])

make("http://localhost:3000", "chat");

const root = ReactDOM.createRoot(document.getElementById('main'));

root.render(
  <React.StrictMode>
    <RouterProvider router={router}/>
  </React.StrictMode>
);