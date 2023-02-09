import { Routes, Route } from 'react-router-dom';
import logo from './logo.svg';
import './App.css';
import { Routes } from 'react-router-dom';


function App() {
  return (
    <div className="App">
      
      <Header/>

      <Routes>
      <Route path="/" element={ <Home/> } exact />
      <Route path="/login" element={ <Login/> } />
      <Route path="/menu" element={ <Menu/> } />
      <Route path="/add" element={ <Add/> } />
      <Route path="/view" element={ <View/> } />


      </Routes>


    </div>
  );
}

export default App;
