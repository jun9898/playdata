import './App.css';

function App() {

  let myNum = 1;
  const add = () => {
    myNum++;
    console.log(myNum);
  }

  return (
    <div>
      <h1>숫자 : {myNum}</h1>
      <button onClick={add}>확인</button>
    </div>
  );
}

export default App;
