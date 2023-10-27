import React from 'react';
// https://jsonplaceholder.typicode.com/comments

const FetchTest = () => {

    // async를 함수 옆에 추가하면 이 함수는 자동으로 Promise를 리턴하는 비동기함수가 된다.
    // async를 추가한 함수의 리턴값을 Promise객체의 resolve의 결과값
    // http 통신을 하는 비동기 처리 명령문 앞에 await를 추가한다.
    async function getData() {
        // 외부서버에 제공하는 api를 호출
        // Promise 객체 앞에 awati를 추가하면 이 작업이 끝날때까지 기다렸다가 다른 작업으로 넘어간다.
        console.log("test")
        let response = await fetch("http://localhost:9001/erp/ajax/exam02")
                                        .then((res) => res.json())
        console.log(response)

    }
    getData()
    return (
        <div>
            
        </div>
    );
};

export default FetchTest;