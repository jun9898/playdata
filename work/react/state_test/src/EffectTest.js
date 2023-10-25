import React, {useState, useEffect} from 'react';

const EffectTest = () => {

    let [data, setData] = useState(0)
    // 실행시점
    // 1. 함수가 최초 실행되어 랜더림 될때
    // 2. state가 변경되는 시점
    // useEffect
    // 매개변수1 : useEffect가 호출될때 실행내용을 정의한 함수
    // 매개변수2 : useEffect가 어떤 상태변수에 의존적인지 명시
    //            생략하면 모든state가 바뀔때마다 계속 호출
    useEffect(() => {
        console.log("useEffect 실행")
        // connectServer()
    }, [data])

    function connectServer() {
        // 서버에 접속해서 데이터 가져오기
        // 가져온 값으로 state 변경하기
        setData(1000)
        console.log("데이터 가져오기 완료")

    }

    return (
        <div>
            <h1>데이터{data}</h1>
            <button onClick={() => {
                setData(data+1)
            }
            }>상태값 변경하기</button>
        </div>
    );
};

export default EffectTest;