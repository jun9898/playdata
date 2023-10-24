const Menu = function(props) {
  // 자바스크립트 코드를 이용해서 새로운 배열을 만들어서 연결
  const li_data = []
  // for문을 이용해서 li_data에 properties로 전달받은 값을 출력
  // for (let i=0; i < props.userlist.length; i++) {
  //   let data = props.userlist[i]
  //   li_data.push(<li key={data.id}>{data.name}</li>)
  // }
    return (
    <nav>
        {props.userlist.map((row) => 
        <ol key={row.id}>
              {row.id} {row.name} {row.addr}
        </ol>
        )}
    </nav>
    // <nav>
    //     <ol>
    //       {li_data}
    //     </ol>
    // </nav>
    )
}
export default Menu