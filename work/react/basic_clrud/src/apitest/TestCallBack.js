import React from 'react';

// 전달받은 숫자를 평가해서 양수인지 음수인지 평가
// => 비동기 통신으로 작업
// => setTimeout을 이용해서 5초 후에 평가할것임
// => 숫자타입이면 성공이고 양수인지 음수인지 평가해서 리턴할것
// => 숫자이외의 타입이 입력되면 에러메시지를 출력
// 숫자인지 문자인지 값을 입력받아서 평가하는 함수를 정의 (numberCheck(매개변수))
// => 숫자를 평가해야 하므로 값을 입력
// => 성공시에 실행될 함수와 실패시에 실행될 함수를 전달받아야 함
// numberCheck 함수는 버튼이 눌러질때 호출(이벤트 핸들러명 : test)

const TestCallback = () => {
    function numberCheck(num, resolve, reject) {     // (num, 성공 했을 때 함수, 실패 했을 때 함수)
        // 자바 스크립트가 지원해주는 비동기함수를 호출
        setTimeout(() => {
            // 숫자와 그 외의 타입인지 체크
            if (typeof num === "number") {
                // 성공
                resolve(num)
            } else {
                // 실패
                reject("숫자를 입력하세요")
            }
        }, 5000);
    }

    function test() {
        // 버튼이 눌려지면 numberCheck를 호출
        numberCheck(10,
            (val) => {       // resolve 함수를 콜백하는 함수
                // let result = val >= 0 ? "양수" : "음수"
                console.log(val, ":", val >= 0 ? "양수" : "음수")
            },

            (err) => {
                console.log("실패", err)
            })
    }

    // 위의 작업을 Promise 객체를 이용해서 변경
    // Promise 객체는 비동기통신에서 콜백함수 사용하는 부분을 분리해서 사용할 수 있다.
    // Promise 객체를 사용하는 경우 비동기통신을 실행하는 부분을 함수로 내부에서 정의하고 사용
    function myusePromise(num) {
        // 1. 비동기통신을 실행할 수 있는 함수를 별도로 정의
        const run = (resolve, reject) => {
            setTimeout(() => {
                // 숫자와 그 외의 타입인지 체크
                if (typeof num === "number") {
                    // 성공
                    console.log("성공")
                    resolve(num)
                } else {
                    // 실패
                    console.log("실패")
                    reject("숫자를 입력하세요")
                }
            }, 5000);
        }
        // 2. Promise 객체를 만들어서 리턴 - Promise 객체를 만들 때 실제 비동기통신을 하는 함수를 매개변수로 넘긴다.
        // => 어떤 함수를 정의할 때 Promise 객체를 반환한다는 것은 이 함수가 비동기통신을 하는 함수라는 의미
        //    비동기통신의 결과를 Promise로 만들어서 리턴
        //    Promise 객체에 전달하면 자동으로 run이 실행
        const asyncObj = new Promise(run);
        return asyncObj;
    }

    let test2 = () => {
        // Promise 객체를 반환받았음
        let resultObj = myusePromise(1000)
        // Promise 객체가 성공이 경우 실패인 경우 사용할 수 있는 기능을 제공
        // 작업이 성공하는 경우 실행
        resultObj.then((res) => {
            console.log("작업성공 => ", res)
        })
        // 작업이 실패하는 경우 실행
        resultObj.catch((err) => {
            console.log("작업실패 => ", err)
        })
    }

    return (
        <div>
            <h1>숫자 양수/음수 평가</h1>
            <button onClick={test}>Promise 객체를 사용하지 않고 작업</button>
            <button onClick={test2}>Promise 객체를 사용해서 작업</button>
        </div>
    );
}

export default TestCallback;