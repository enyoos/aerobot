import Login from './Components/Login';
import { useEffect, useRef, useState } from 'react';
import NewWindow from 'react-new-window';
import make from './make';

function App() {
  const dockChat = () => {
    make( 'http://localhost:3000/docked', "chat-container" );
  }

  return (
    <>
      {/* <button onClick={dockChat}>Dock chat bot</button> */}
      <NewWindow 
        name='Chat docked' 
        url='http://localhost:3000/docked' 
        onOpen={dockChat} 
        title='Chat docked'
      >
        <div id='chat-container'></div>
      </NewWindow>
    </>
  );
}

export default App;
