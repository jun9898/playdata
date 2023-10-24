import Board from "./component/Board";
import Header from "./component/Header";
import Menu from "./component/Menu";

function App2() {
  let userlist = [
    { id: 1, name: "뷔", addr: "서울" },
    { id: 2, name: "슈가", addr: "대구" },
    { id: 3, name: "남준", addr: "일산" },
  ];
  return (
    <div>
      <Header></Header>
      <Menu userlist={userlist}></Menu>
      <Board></Board>
    </div>
  );
}
export default App2;