const Board = function() {
    return(
      <div>
        <table width={500} border={1}>
        <thead>
          <tr>
            <th>번호</th><th>제목</th><th>작성자</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td><td>리액트 JSX문법</td><td>뷔</td>
          </tr>
          <tr>
            <td>2</td><td>리액트 컴포넌트만들기</td><td>슈가</td>
          </tr>
          <tr>
            <td>3</td><td>리액트 props</td><td>RM</td>
          </tr>
        </tbody>
        </table>
      </div>
    )
}

export default Board