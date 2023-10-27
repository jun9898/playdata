import React from 'react';

const AsyncTest2 = () => {

    const test1 = (num1, num2, callbackfunc) => {
        // setTimeout은 자바스크립트에서 제공되는 비동기 통신 함수
        // setTimeout(콜백함수, 지연시간) 해당 시간이 초과되었을때 콜백함수를 실행시킨다
        // 2초 후에 콜백함수를 실행시킨다
        setTimeout(() => {
            // 해당 작업을 수행한 뒤 콜백펑션을 작동시킨다
            let result = num1 + num2;
            callbackfunc(result);
            console.log("테스트 1 작업");
        }, 2000); 
    }
    
    const callbackfunc = (result) => {
        console.log("비동기통신의 실행결과 => ", result)
    }

    const asyncTest = () => {
        test1(100, 200, callbackfunc);
        console.log("작업 완료")
    }

    return (
        <div>
            <button onClick={asyncTest}>자바스크립트 비동기방식 처리</button>
        </div>
    );
};

export default AsyncTest2;