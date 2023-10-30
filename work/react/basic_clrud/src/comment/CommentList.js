import React, { useEffect, useState } from 'react';
import Commet from './Commet';
const CommentList = () => {

    // 디비에서 조회한 데이터를 받아서 저장할 배열
    const [datalist,setDataList] = useState([])
    useEffect(() => {
        // 비동기함수
        fetch("http://localhost:9000/comment/list")
                .then(res => res.json())
                .then(res => {
                    console.log("test=================================")
                    console.log(res)
                    setDataList(res)
                })
    },[])
    return (
        <div>
            <h1>댓글리스트({datalist.length}개)</h1>
            <div>
                {datalist.map(comment => 
                        <Commet key={comment.commentNo} {...comment} ></Commet>
                    )}
            </div>
        </div>
          
    );
};
//속성이 전달되지 않는 경우 기본속성을 정의할 수 있다.
CommentList.defaultProps={
    commnetlist:[]
}
export default CommentList;