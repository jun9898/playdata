import React from 'react';
import { useParams } from 'react-router-dom';

const Read = () => {
    // PathVariavle 테스트
    // Val변수는 PathVariable로 지정한 변수명과 동일
    let {val} = useParams();
    console.log(val)
    return (
        <div>
            <h1>상세보기페이지</h1>
            <p>이곳은 상세보기 페이지입니다.</p>
        </div>
    );
};

export default Read;