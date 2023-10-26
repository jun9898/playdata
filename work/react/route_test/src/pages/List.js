import React from 'react';
import { useNavigate, useSearchParams } from 'react-router-dom';

const List = () => {
    let [myparams, setMyParams] = useSearchParams();
    // history 객체를 내부에서 처리해주는 함수
    let navigate = useNavigate();
    let id = myparams.get("id");
    let cmd = myparams.get("cmd");
    console.log(id, "      " , cmd)
    return (
        <div>
            <h1>목록보기</h1>
            <p>이곳은 목록을 확인할 수 있는 페이지입니다.</p>
            <button onClick={() => {
                setMyParams({data : "all"}) // 파라미터 변경
            }}>파라미터 변경</button>
            <button onClick={() => {
                navigate("/")
            }}>홈으로</button>
            <button onClick={() => {
                navigate(-1)
            }}>이전페이지</button>
        </div>
    );
};

export default List;