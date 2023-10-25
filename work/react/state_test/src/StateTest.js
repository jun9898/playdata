import React from 'react';
import {useState} from 'react'

const StateTest = () => {
    // 숫자형식의 상태값
    // const data = useState(1)
    const [mynum, setMyNum] = useState(1)
    // console.log(data)
    // 문자형식의 상태값
    const [mytext, setMyText] = useState("")
    // boolean값에 대한 상태값
    const [myBooleanVal, setMyBooleanVal] = useState(false)

    return (
        <div>
            <h1>상태값 체크</h1>
            <input type='number' 
                onChange={(event) => setMyNum(event.target.value)}/>
            <input type='number' value={mynum}/>
            <input type='text'
                onChange={(event) => setMyText(event.target.value)}/>
            <input type='checkbox'
                onChange={(event) => setMyBooleanVal(event.target.checked)}/>
            {myBooleanVal ? <span>체크</span> : <span>체크해제</span>}
            <div>{mynum}</div>
            <div>{mytext}</div>
        </div>
    );
};

export default StateTest;
