const UserList = function() {
    let userlist = [
        {
            id : 1,
            name : "전병준",
            addr : "독산동"
        },
        {
            id : 2,
            name : "전콜라",
            addr : "삼동"
        },
        {
            id : 3,
            name : "전낙타",
            addr : "인계동"
        }
    ]
    return (
        <div>
            {userlist.map((row, index) => 
            <h3 key={index}>
                id : {row.id} &nbsp;
                name : {row.name} &nbsp;
                addr : {row.addr} &nbsp;
            </h3>)}
        </div>
    )
}

export default UserList