// import './App.css';
// import {BrowserRouter, Route, Routes} from 'react-router-dom';
// import MovieHome from './movie/MovieHome';
// import MovieList from './movie/MovieList';
// import MovieWrite from './movie/MovieWrite';
// import MainHeader from './MainHeader';

// function MainApp() {
//     //정의한 함수를 CommentWrite의 props로 전달
//     return (
//         <BrowserRouter>
//             <div className='MainApp'>

//                 {/* 여기에 해더 보드가 들어가야 함 해더 보드는 각 패스로 이동하는 Link를 걸어줘야 함*/}
//                 <MainHeader/>
//                 <Routes>
//                     <Route path='/' element={<MovieHome/>}/>
//                     <Route path='/movielist' element={<MovieList/>}/>
//                     <Route path='/moviewrite' element={<MovieWrite/>}/>
//                     {/* 여기 주석처리된 부분엔 아까 연습했던 댓글창을 띄우면 됨*/}
//                     {/* <Route path='/' element={<MovieHome/>}/> */}
//                 </Routes>
//             </div>
//         </BrowserRouter>
//     );
// }

// export default MainApp;