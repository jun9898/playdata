import React from 'react';
// test1, test2, test3
// test1의 실행결과를 test2가 사용
// test2의 실행결과를 test3이 사용
// test3 -> test2 -> test1
// 모두 콜백함수로 처리

const CallBackHellTest = () => {
    const test1 = (num1, num2, callbackfunc) => {
        setTimeout(() => {
            let result = num1 + num2
            callbackfunc(result)
        }, 3000)
    }

    const test2 = (result, callbackfunc) => {
        setTimeout(() => {
            let test2_result = result*1000;
            callbackfunc(test2_result) // 매개변수로 전달받은 test1의 결과를 콜백함수에 전달
        }, 5000)
    }

    const test3 = (result, callbackfunc) => {
        setTimeout(() => {
            let test3_result = result/2;
            callbackfunc(test3_result) // 매개변수로 전달받은 test2의 결과를 콜백함수에 전달
        }, 2000)
    }

    const run = () => {
        // 콜백지옥 시작
        test1(1000,2000,(a_result) => {
            console.log("A가 실행되고 실행결과를 B에 넘겨주기 ", a_result);
            test2(a_result, (b_result) => {
                console.log("B가 실행되고 실행결과를 C에 넘겨주기", b_result)
                test3(b_result, (c_result) => {
                    console.log("C가 실행", c_result)
                })
            })
        })
    }
    return (
        <div>
            <button onClick={run}>콜백 지옥</button>
        </div>
    );
};

export default CallBackHellTest;