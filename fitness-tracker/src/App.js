import './App.css';
import { Route, Routes } from 'react-router-dom';
import { useState } from 'react';
import Header from './components/Header';
import Home from './components/Home';
import Login from './components/Login';
import Menu from './components/Menu';
import Add from './components/Add';
import View from './components/View';
import Update from './components/Update';


function App() {

  const [sessionToUpdate, setSessionToUpdate] = useState();

  return (
    <div className="App">
      
      <Header/>

      <Routes>
      <Route path="/" element={ <Home/> } exact />
      <Route path="/login" element={ <Login/> } />
      <Route path="/menu" element={ <Menu/> } />
      <Route path="/add" element={ <Add/> } />
      <Route path="/view" element={ <View setSessionToUpdate = {setSessionToUpdate}/> } />
      <Route path="/update" element={ <Update sessionToUpdate =  {sessionToUpdate}/> } />


      </Routes>


    </div>
  );
}

export default App;
