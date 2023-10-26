import './App.css';
import Home from './pages/Home';
import Write from './pages/Write';
import List from './pages/List';
import Read from './pages/Read';
import Update from './pages/Update';
import BoardHeader from './component/board/BoardHeader';
import {BrowserRouter, Route, Routes} from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <div className='App'>
        <h1>라우팅 연습</h1>
        <BoardHeader/>
        {/* 페이지가 교체되는 것이 아니라 보여줄 컴포넌트만 바꿔치기 하는 작업*/}
        <Routes>
          <Route path='/' element={<Home/>}/>
          <Route path='/write' element={<Write/>}/>
          <Route path='/list' element={<List/>}/>
          <Route path='/read' element={<Read/>}/>
          <Route path='/read/:val' element={<Read/>}/>
          <Route path='/update' element={<Update/>}/>
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;
