import React from 'react';

const PromiseExam = () => {

    const test1 = (num1, num2) => {
        const run1 = (resolve,reject) => {
            setTimeout(() => {
                let result = num1 + num2
                resolve(result)
            }, 3000)
        }
        const obj = new Promise(run1)
        return obj
    }

    const test2 = (result) => {
        return new Promise((resolve,reject) => {
            setTimeout(() => {
                let test2_result = result*1000;
                resolve(test2_result) // 매개변수로 전달받은 test1의 결과를 콜백함수에 전달
            }, 5000)
        })
    }

    const test3 = (result) => {
        const run3 = (resolve,reject) => {
            setTimeout(() => {
                let test3_result = result/2;
                resolve(test3_result) // 매개변수로 전달받은 test2의 결과를 콜백함수에 전달
            }, 2000)
        }
        const asyncObj3 = new Promise(run3)
        return asyncObj3
    }

    const run = () => {
        test1(1000,2000)
            .then((a_result) => {
                console.log("test1이 실행되고 실행결과를 test2에 넘겨주기 ", a_result)
                return test2(a_result)
            })
            .then((b_result) => {
                console.log("test2이 실행되고 실행결과를 test3에 넘겨주기 ", b_result)
                return test3(b_result)
            })
            .then((c_result) => {
                console.log("test3이 실행", c_result)
            })



    }

    return (
        <div>
            <button onClick={run}> 프로미스 </button>
        </div>
    );
};

export default PromiseExam;