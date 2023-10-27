import React from 'react';

const AsyncTest = () => {

    const test1 = () => {
        console.log("test1 함수")
    }

    const test2 = () => {
        console.log("test2 함수")
    }

    const test3 = () => {
        console.log("test3 함수")
    }

    const syncTest = () => {
        test1();
        test2();
        test3();
    }

    return (
        <div>
            <button onClick={syncTest}>자바스크립트 동기방식 처리</button>
        </div>
    );
};

export default AsyncTest;