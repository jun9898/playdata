import React from 'react';
import {useState} from 'react';

const ArrayState = () => {
    const [myList, setMyList] = useState([{id : 10, name : "전콜라"}]);
    function getdata() {
        // 임의의 데이터를 정의하고 생태값을 변경
        let myArrData = [
            { id : 1, name : "전병준"},
            { id : 2, name : "전병준1"},
            { id : 3, name : "전병준2"},
            { id : 4, name : "전병준3"}
        ]
        setMyList([...myList,...myArrData])
    }
    console.log("랜더링")
    return (
        <div>
            <button onClick={getdata}>값 가져오기</button>
            <hr/>
            {
                myList.map((row, index)  => 
                    <h1 key={index}>{row.id} : {row.name}</h1>
                    ) 
            }
        </div>
    );
};

export default ArrayState;