import React from 'react';

const AsyncAwaitTest = () => {

    function hello() {
        return "처리결과"
    }

    // async를 함수 옆에 추가하면 이 함수는 자동으로 Promise를 리턴하는 비동기함수가 된다.
    // async를 추가한 함수의 리턴값을 Promise객체의 resolve의 결과값
    // http 통신을 하는 비동기 처리 명령문 앞에 await를 추가한다.
    async function asyncHello() {
        return "async 처리결과"
    }

    console.log(hello())
    console.log(asyncHello())

    return (
        <div>
            
        </div>
    );
};

export default AsyncAwaitTest;