import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
        <div className='App'>
            <Menu/>
            <Routes>
                <Route path='/write' element={<CommentWrite/>}/>
                <Route path='/list' element={<CommentList/>}/>
                <Route path='/read/:commentNo' element={<CommentRead/>}/>
                <Route path='/update/:commentNo' element={<CommentUpdate/>}/>
            </Routes>

        </div>
    </BrowserRouter>
  );
}

export default App;
