import { Routes, Route } from 'react-router-dom';
import './App.css';
import Menu from './components/Menu';
import Header from './components/Header';
import Login from './components/Login';

function App() {
  return (
    <div className="App">
      
      <Header/>

      <Routes>
      {/* <Route path="/" element={ <Home/> } exact /> */}
      <Route path="/login" element={ <Login/> } />
      <Route path="/menu" element={ <Menu/> } />
      {/* <Route path="/add" element={ <Add/> } />
      <Route path="/view" element={ <View/> } /> */}


      </Routes>


    </div>
  );
}

export default App;
