import React from 'react';
import {useState, useEffect} from 'react';
// useEffect를 사용하지 않고 일반 함수로 useState 변경 작업

const UseEffectExam = () => {

    const [count, setCount] = useState(0);

    useEffect(() => {
        document.title = `클릭횟수 :  ${count}`
        console.log("=========================", count)
    },[count])

    function addCount() {
        setCount(count+1)
        // document.title = `클릭횟수 :  ${count}`
        // console.log("=========================", count)
    }



    return (
        <div>
            <p>버튼을 클릭한 횟수 : {count}</p>
            <button onClick={addCount}>클릭하기</button>
        </div>
    );
};

export default UseEffectExam;