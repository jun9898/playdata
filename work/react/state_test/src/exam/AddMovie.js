// import React from 'react';
// import {useState} from 'react';
// import Test, { Test2 } from './Test';

// const AddMovie = () => {
//     const [movieList, setMovieList] = useState([]);
//     const [movieName, setMovieName] = useState("");

//     function changeName(event) {
//         setMovieName(event.target.value)
//     }

//     function addMovie() {
//         setMovieList([...movieList,...[{movieName : movieName}]])
//         document.getElementById("name").value = null
//     }

//     return (
//         <div>
//             <h1>상영영화 목록 : </h1>
//             <input type='text' id='name' onChange={changeName}/>
//             <input type='button' value="입력" onClick={(addMovie)}/>

//             <ul>
//                 {movieList.map((row,index) =>
//                     <li key={index}>{row.movieName}</li>    
//                 )}
//                 <Test/>
//                 <Test2/>
//             </ul>

            
//         </div>
//     );
// };

// export default AddMovie;