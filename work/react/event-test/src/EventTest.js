import React from 'react';
// 이벤트연결 1
// 미리함수를 만들고 연결해서 사용하는 방식

const EventTest = () => {

    function showMsg() {
        alert("이벤트 확인")
    }

    function showData(data) {
        alert("값 = > " + data)
    }

    // 이벤트 핸들러에 연결된 함수는 매개변수에 이벤트 객체를 받을 수 있다.
    function showText(event) {
        // event.target 객체는 이벤트를 발생시킨 객체를 의미하며
        // 객체가 갖는 고유한 속성이나 메소드에 접근할 수 있다.
        console.log(event.target.value)
    }

    return (
        <div>
            <h1>이벤트 테스트</h1>
            <hr/>
            <button onClick={showMsg}>이벤트 버튼 1</button>
            <button onClick={function() {
                alert("직접 이벤트 정의하기")
            }}>이벤트 버튼 2</button>
            <button onClick={function() {
                showData(1000)
            }}>이벤트 버튼 3</button>
            <input type='text' onChange={showText}/>
        </div>
    );
};

export default EventTest;