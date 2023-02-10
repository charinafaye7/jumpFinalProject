import './App.css';
import { Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Home from './components/Home';
import Login from './components/Login';
import Menu from './components/Menu';
import Add from './components/Add';
import View from './components/View';



function App() {
  return (
    <div className="App">
      
      <Header/>

      <Routes>
      <Route path="/" element={ <Home/> } exact />
      <Route path="/login" element={ <Login/> } />
      <Route path="/menu" element={ <Menu/> } />
      {/* <Route path="/add" element={ <Add/> } />
      <Route path="/view" element={ <View/> } /> */}


      </Routes>


    </div>
  );
}

export default App;
