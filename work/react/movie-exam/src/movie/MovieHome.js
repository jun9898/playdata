import React from 'react';
import {useState, useEffect} from 'react';
import MovieList from './MovieList';
import MovieWrite from './MovieWrite';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import MainHeader from '../MainHeader';
import App from '../App/App';

const MovieHome = () => {


  const [movielist, setMovieList] = useState([
    // {
    //   movieId: "movie001",
    //   title: "어바웃타임",
    //   url: "https://www.kobis.or.kr/common/mast/movie/2013/11/thumb_x192/thn_a645ccb83f1a42d3a1ad5bf641e9869e.jpg",
    //   genre: "로맨틱코미디",
    //   alt: "어바웃타임이미지",
    // },
    // {
    //   movieId: "movie002",
    //   title: "태양은없다.",
    //   url: "https://www.kobis.or.kr/upload/up_img/cleansing/x00/00/17/thumb_x192/thn_mov_19980003_32876.jpg",
    //   genre: "드라마액션",
    //   alt: "태양은없다이미지",
    // },
    // {
    //   movieId: "movie003",
    //   title: "변호인",
    //   url: "https://www.kobis.or.kr/common/mast/movie/2013/12/thumb_x192/thn_c3dbfe7d478c451e9c55ac42cf1fdd20.jpg",
    //   genre: "드라마",
    //   alt: "변호인이미지",
    // },
    // {
    //   movieId: "movie004",
    //   title: "가문의영광",
    //   url: "https://www.kobis.or.kr/common/mast/movie/2023/09/thumb_x192/thn_4f6f8760de4d484b80898aab4493e920.jpg",
    //   genre: "코미디",
    //   alt: "가문의영광이미지",
    // },
    // {
    //   movieId: "movie005",
    //   title: "어바웃타임",
    //   url: "https://www.kobis.or.kr/common/mast/movie/2013/11/thumb_x192/thn_a645ccb83f1a42d3a1ad5bf641e9869e.jpg",
    //   genre: "로맨틱코미디",
    //   alt: "어바웃타임이미지",
    // },
    // {
    //   movieId: "movie006",
    //   title: "태양은없다.",
    //   url: "https://www.kobis.or.kr/upload/up_img/cleansing/x00/00/17/thumb_x192/thn_mov_19980003_32876.jpg",
    //   genre: "드라마액션",
    //   alt: "태양은없다이미지",
    // },
    // {
    //   movieId: "movie007",
    //   title: "변호인",
    //   url: "https://www.kobis.or.kr/common/mast/movie/2013/12/thumb_x192/thn_c3dbfe7d478c451e9c55ac42cf1fdd20.jpg",
    //   genre: "드라마",
    //   alt: "변호인이미지",
    // },
    // {
    //   movieId: "movie008",
    //   title: "가문의영광",
    //   url: "https://www.kobis.or.kr/common/mast/movie/2023/09/thumb_x192/thn_4f6f8760de4d484b80898aab4493e920.jpg",
    //   genre: "코미디",
    //   alt: "가문의영광이미지",
    // },
  ]);

// https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20231011


  const getData = async () => {
    let resdata = await fetch("https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20231011")
                                .then((res) => res.json())
    console.log("resdata ===================================")
    let result = resdata.boxOfficeResult.dailyBoxOfficeList
    console.log(result)
    
    const initdata = result.map((comment) => {
      console.log("map data ===========", comment)
        return {
        //     // 2. 우리 데이터에 맞게 수정
          movieId : comment.movieCd,
          title : comment.movieNm,
          url: "https://www.kobis.or.kr/common/mast/movie/2023/09/thumb_x192/thn_4f6f8760de4d484b80898aab4493e920.jpg",
          genre: "코미디",
          alt: "가문의영광이미지"
        }
    })
    // 3. state 변경
    setMovieList(initdata);
  }


  const createMovie = (movieState) => {
    setMovieList([...movielist, {...movieState}])
  }

  useEffect(() => {
      getData()
  }, [])

    return (
      <BrowserRouter>
            <div className='MovieHome'>
              <h1>라우터 과제</h1>
                <MainHeader/>
                <Routes>
                    {/* <Route path='/' element={<MovieHome/>}/> */}
                    <Route path='/movielist' element={<MovieList movielist={movielist}/>}/>
                    <Route path='/moviewrite' element={<MovieWrite createMovie={createMovie}/>}/>
                    <Route path='/app' element={<App/>}/>
                </Routes>
            </div>
        </BrowserRouter>
    );
};

export default MovieHome;