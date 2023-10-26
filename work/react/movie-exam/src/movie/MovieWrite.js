import React from 'react';
import {useState} from 'react';

const MovieWrite = ({createMovie}) => {

    const [movieState, setMovieState] = useState({movieId : "", title : "", url : "", genre : "", alt : ""});

    const changeState = (e) => {
        setMovieState({
            ...movieState,
            [e.target.name] : e.target.value
        })
    }
    const createSubmit = () => {
        console.log("저장하기 버튼이 눌러질때 호출되는 함수 = "+{...movieState})
        createMovie(movieState)
    }
    return (
        <div>
            <h2>영화 등록</h2>
            <div>
                <input
                name="movieId"
                placeholder="영화 번호"
                type="text"
                value={movieState.movieId}
                onChange={changeState}
                />
            </div>
            <div>
                <input
                name="title"
                placeholder="영화 이름"
                type="text"
                value={movieState.title}
                onChange={changeState}
                />
            </div>
            <div>
                <input
                name="url"
                placeholder="영화 url"
                type="text"
                value={movieState.url}
                onChange={changeState}
                />
            </div>
            <div>
                <input
                name="genre"
                placeholder="영화 genre"
                type="text"
                value={movieState.genre}
                onChange={changeState}
                />
            </div>
            <div>
                <input
                name="alt"
                placeholder="영화 alt"
                type="text"
                value={movieState.alt}
                onChange={changeState}
                />
            </div>
            <div>
                <button onClick={createSubmit}>일기 저장하기</button>
            </div> 
        </div>
    );
};

export default MovieWrite;