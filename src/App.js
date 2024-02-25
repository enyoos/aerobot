import Login from './Components/Login';
import { useEffect, useRef, useState } from 'react';

function App() {
  const [name, setName] = useState("");

  return (
    <>
      <Login name={name} setName={setName}/>
    </>
  );
}

export default App;
