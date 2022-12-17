import './App.css';
import { Route, Routes } from 'react-router-dom';
import Login from './views/Login';
import Register from './views/Register';
import Home from './views/Home';


function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/home" element={<Home />} />
      </Routes>
    </div>
  );
}

export default App;
