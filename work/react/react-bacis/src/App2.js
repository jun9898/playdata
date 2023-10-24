import './App.css';

// 리앤트의 컴포넌트에서는 하나의 DOM만 리턴할 수 있다.
let  myval = 1000;
function App2() {
  let  myval2 = 2000;
  // 자동완성이 안되므로 추천하지 않음
  // JSX에서 외부 변수를 사용할 때 {}, 속성값만 정의하는 경우
  // JSX안에서 조건을 평가해서 작업하는 경우 if문을 사용할 수 없다.
  // if는 삼항연산자를 이용
  // {조건 ? 조건을 만족하는 경우 값1 : 조건을 만족하지 않는경우 값2}
  const mystyle = {color:"red"}
  return (
    <div>
      <div style={mystyle}>안녕 리액트</div>
      <div>안녕 리액트</div>
      <div>값1 : {myval}</div>
      <div>값2 : {myval2}</div>
      <div>값3 : { myval >= 1000 ? "합격" : "불합격" }</div>
      <div>값4 : { myval2 === 1000 ? "테스트 성공" : "테스트 실패" }</div>
    </div>
  );
}

export default App2;
