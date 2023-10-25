import React from 'react';
import {useState} from 'react';

const CountTest = () => {
    const [num, setState] = useState(1);

    // setState 함수는 기본적으로 num을 포함하고 있으므로 c에 num값이 자동으로 할당
    // const test = () => setState( c => {
    //     console.log(setState)
    //     console.log(num)
    //     console.log(c)
    //     return c+1
    // } )

    console.log("상태값 myval: " + num)
    return (
        <div>
            <h1>출력값</h1>
            <h1>{num}</h1>
            <button 
            onClick={() => setState(num+1)} >
                더하기
            </button>
            <button 
            onClick={() => setState(num-1)} >
                빼기
            </button>
        </div>
    );
};

export default CountTest;