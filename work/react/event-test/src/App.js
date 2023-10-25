import "./App.css";

function EventTest(props) {
  return (
    <h1
      onClick={function (event) {
        event.preventDefault();
        props.myevent();
      }}
    >
      이벤트연습
    </h1>
  );
}

//이벤트가 발생되면서 호출되는 함수로 이벤트 객체가 전달
function runEvent(e) {
  e.preventDefault();
  console.log("이벤트가 발생...");
}

function App() {
  return (
    <div>
      <h1>리액트에서 이벤트 연습하기</h1>
      <hr />
      <EventTest
        myevent={function () {
          alert("이벤트가 실행됨");
        }}
      ></EventTest>
      <button onClick={runEvent}>이벤트연습2</button>
    </div>
  );
}

export default App;