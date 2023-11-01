import React from 'react';
import { Link } from 'react-router-dom';

const Commnet = ({commentNo,writer,rank,content,writeDate}) => {
    const deleteRun = (commentNo) => {
        console.log(commentNo)
        fetch("http://127.0.0.1:9000/comment/delete/"+commentNo, {
            method:"DELETE"
        }).then(res => res.text())
          .then(res => {
            if (res === "ok"){
                alert("삭제 성공")
                window.location.href="/list"
            }else{
                alert("삭제 실패")
            }
          })
    }
    return (
        <div className='comment'>
            <div className='info'>
                <span>작성자:{writer} ---------------- 좋아요:{rank}</span>
                <span className='date'>[작성시간:{writeDate}]</span>
                <div>
                    내용:{content}
                </div>
            </div>    
            <button onClick={()=>{
                console.log(commentNo,"===============================")
                if(window.confirm(`${commentNo} 의 댓글을 삭제하시겠습니까?`)){
                    //삭제기능을 처리하는 함수를 호출
                    deleteRun(commentNo)
                }
            }}>삭제</button>
            <button><Link to={`/update/${commentNo}`}>수정</Link></button>
            <button><Link to={`/read/${commentNo}`}>상세보기</Link></button>
        </div>
    );
};

export default Commnet;