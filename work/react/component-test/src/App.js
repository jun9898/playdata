import './App.css';
import Hello from './component/Hello';
import MapTest from './component/MapTest';
import Test from './component/MyTest';

function App() {
  return (
    <div>
      <hr/><hr/>
      <h1>내 박살나버린 휴대폰</h1>
      <Hello/>
      <hr/><hr/>
      <div className='myclass'>내휴대폰 살려줘</div>
      <Hello/>
      <Test/>
      <hr/><hr/>
      <MapTest/>
    </div>
  );
}

export default App;
