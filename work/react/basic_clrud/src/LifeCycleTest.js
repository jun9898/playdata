import React, { useEffect, useState } from 'react';

const MountTest = () => {
    console.log("test");
    useEffect(() => {
        console.log("useEffect")
        return() => {
            // 리턴될때 함수를 실행
            // 언마운트 시점에 실행될 작업이 있는 경우 처리
            console.log("컴포넌트가 화면에서 없어짐")
        }
    })
    return (
        <div>컴포넌트의 라이프사이클 테스트</div>
    )
}

const LifeCycleTest = () => {

    // 상태값을 계속해서 바꿔주는 펑션을 정의
    const [checked, setChecked] = useState(false)
    const toggle = () => setChecked(!checked)

    console.log("리액트 컴포넌트 LifeCycle 리액트")
    return (
        <div>
            <h1>리액트 LifeCycle</h1>
            {/* 해당 버튼을 누르면 컴포넌트를 생성했다가 없애는 작업을 수행하게 할것임 라우터 사용? */}
            <button onClick={toggle}>상태값 변경</button>
            {/* 자바스크립트의 and 연산자를 사용해서 checked가 True일때만 컴포넌트를 출력하도록 설정 */}
            {checked && <MountTest/>}
        </div>
    );
};

export default LifeCycleTest;