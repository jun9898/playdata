//영화데이터의 갯수만큼 영화 카드를 출력하는 역할 담당
import { useState } from "react";

import Movie from "./Movie";

//출력과 관련된 페이징, 검색,.... 뷰를 담을 수 있다.
const MovieList = function () {
  const movielist = [
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
  ];
  const [searchMovieList,setSearchMovieList] = useState(movielist)

    function search(e){
        const keyword = document.getElementById("text").value
        if (keyword === ""){
          setSearchMovieList(movielist)
        } else {
          const result = movielist.filter((movielist) => movielist.title.indexOf(keyword) !== -1)
          setSearchMovieList(result)
        }
    }
  return (
    <div className="row text-center">
            <h1>영화 목록</h1>
            <h1>
                <input type='text' id="text"></input>
                <button onClick={search}>검색</button>
            </h1>
      {searchMovieList.map((movie) => (
        <Movie
          key={movie.movieId}
          title={movie.title}
          url={movie.url}
          alt={movie.alt}
          genre={movie.genre}
        />
      ))}
    </div>
  );
};
export default MovieList;