function InnerHeader(props) {
  console.log(props)
    return (
      <header>
        <h1>{props.title} {props.name}</h1>
      </header>
    )
  }
const InnerMenu = function(content) {
    return (
    <nav>
        <ol>
          <li>{content.sub} JSX문법 {content.no}</li>
          <li>{content.sub} 컴포넌트만들기 {content.no}</li>
          <li>{content.sub} props {content.no}</li>
        </ol>
    </nav>
    )
}

const InnerBoard = function() {
    return(
      <div>
        <table width={500} border={1}>
        <thead>
          <tr>
            <th>번호</th><th>제목</th><th>작성자1</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td><td>리액트 JSX문법</td><td>뷔1</td>
          </tr>
          <tr>
            <td>2</td><td>리액트 컴포넌트만들기</td><td>슈가1</td>
          </tr>
          <tr>
            <td>3</td><td>리액트 props</td><td>RM1</td>
          </tr>
        </tbody>
        </table>
      </div>
    )
}

function App3() {
    return (
        <div>
            <InnerHeader title="Board" name="test1"/>
            <InnerHeader title="Erp" name="test2"/>
            <InnerHeader title="Test" name="test3"/>
            <InnerMenu sub="리엑트" no="1"/>
            <InnerBoard/>
        </div>
    )
}
export default App3