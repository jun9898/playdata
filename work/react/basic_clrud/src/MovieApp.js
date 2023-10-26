import React from 'react';
import {useState} from 'react';
import MovieList from './movieexam/MovieList';
import MovieWrite from './movieexam/MovieWrite';

const MovieApp = () => {

  const [movielist, setMovieList] = useState([
    {
      movieId: "movie001",
      title: "어바웃타임",
      url: "https://www.kobis.or.kr/common/mast/movie/2013/11/thumb_x192/thn_a645ccb83f1a42d3a1ad5bf641e9869e.jpg",
      genre: "로맨틱코미디",
      alt: "어바웃타임이미지",
    },
    {
      movieId: "movie002",
      title: "태양은없다.",
      url: "https://www.kobis.or.kr/upload/up_img/cleansing/x00/00/17/thumb_x192/thn_mov_19980003_32876.jpg",
      genre: "드라마액션",
      alt: "태양은없다이미지",
    },
    {
      movieId: "movie003",
      title: "변호인",
      url: "https://www.kobis.or.kr/common/mast/movie/2013/12/thumb_x192/thn_c3dbfe7d478c451e9c55ac42cf1fdd20.jpg",
      genre: "드라마",
      alt: "변호인이미지",
    },
    {
      movieId: "movie004",
      title: "가문의영광",
      url: "https://www.kobis.or.kr/common/mast/movie/2023/09/thumb_x192/thn_4f6f8760de4d484b80898aab4493e920.jpg",
      genre: "코미디",
      alt: "가문의영광이미지",
    },
    {
      movieId: "movie005",
      title: "어바웃타임",
      url: "https://www.kobis.or.kr/common/mast/movie/2013/11/thumb_x192/thn_a645ccb83f1a42d3a1ad5bf641e9869e.jpg",
      genre: "로맨틱코미디",
      alt: "어바웃타임이미지",
    },
    {
      movieId: "movie006",
      title: "태양은없다.",
      url: "https://www.kobis.or.kr/upload/up_img/cleansing/x00/00/17/thumb_x192/thn_mov_19980003_32876.jpg",
      genre: "드라마액션",
      alt: "태양은없다이미지",
    },
    {
      movieId: "movie007",
      title: "변호인",
      url: "https://www.kobis.or.kr/common/mast/movie/2013/12/thumb_x192/thn_c3dbfe7d478c451e9c55ac42cf1fdd20.jpg",
      genre: "드라마",
      alt: "변호인이미지",
    },
    {
      movieId: "movie008",
      title: "가문의영광",
      url: "https://www.kobis.or.kr/common/mast/movie/2023/09/thumb_x192/thn_4f6f8760de4d484b80898aab4493e920.jpg",
      genre: "코미디",
      alt: "가문의영광이미지",
    },
  ]);

  const createMovie = (movieState) => {
    setMovieList([...movielist, {...movieState}])
  }


    return (
        <div>
            <h1>무비로 연습하기</h1>
            <MovieList movielist={movielist}></MovieList>
            <MovieWrite createMovie={createMovie}></MovieWrite>
        </div>
    );
};

export default MovieApp;