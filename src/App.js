import { useEffect, useState } from 'react';
import Login from './Components/Login';
// import { useEffect, useRef, useState } from 'react';
import NewWindow from 'react-new-window';
// import make from './make';

const fts = "resizable=0";

function App() {
  const [show, setShow] = useState(false);
  const dockChat = () => {
    // make( ".", "docked-chat");
    setShow( ! show );
  }

  return (
    <>
      <Login/>
      <button 
        title='Your session wont be saved' 
        onClick={dockChat}
      >
        Dock chat
      </button>
      { show ?
        <NewWindow 
          name='Chat docked' 
          url="http://localhost:3000/docked"
          onOpen={dockChat} 
          title='Chat docked'
          // features={fts}
        >
        </NewWindow>
        : ""
      }
    </>
  );
}

export default App;
