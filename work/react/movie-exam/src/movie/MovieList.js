//영화데이터의 갯수만큼 영화 카드를 출력하는 역할 담당
import { useState, useEffect } from "react";
import Movie from './Movie'

//출력과 관련된 페이징, 검색,.... 뷰를 담을 수 있다.
const MovieList = function ({movielist}) {

  console.log(movielist)
  const [searchMovieList,setSearchMovieList] = useState(movielist)

  useEffect(() => {
    setSearchMovieList(movielist)
      // connectServer()
  }, [movielist])

    function search(e){
        const keyword = document.getElementById("text").value
        if (keyword === ""){
          console.log("빈 문자열 들어옴")
          setSearchMovieList(movielist)
        } else {
          const result = movielist.filter((movielist) => 
                        movielist.title.indexOf(keyword) !== -1)
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
      {searchMovieList.map((movie,index) => (
        <Movie
          key={index}
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