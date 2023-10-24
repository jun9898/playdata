const MapTest = function() {
    // 스프링에서 응답받은 데이터를 출력하기
    // 리스트(배열)
    // 자바스크립트 객체
    let data = {
        id : "Jun9898",
        name : "JBJ",
        age : 26
    }
    let list = [1,2,3]
    // 리엑트는 자동으로 만들어지는 컴포넌트에 key 속성을 정의하고 중복되지 않는 값을 value로 정의해야 한다.
    return (
        <div>
            <h1>{list[0]}</h1>
            <h1>{data.id}</h1>
            <div>
                {list.map(function(n) {
                return <h1 key={n}>{n}</h1>
                })}
                {list.map( n => <h3 key={n}>{n}</h3>)}
                {list.map( (n) => <h3 key={n}>{n}</h3>)}
            </div>
        </div>
    )
}
export default MapTest