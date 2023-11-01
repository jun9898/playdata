import React, { useState } from 'react';

const CommentWrite = () => {

    const [commentState,setCommentState] = useState({
        writer:"",
        content:"",
        rank:1
    })

    const createSubmit = (e) => {
        // submit 버튼이 action을 실행하려고 하지 못하게 막기
        e.preventDefault();
        console.log(commentState)
        // Rest 서버에 데이터를 json으로 넘겨주기
        fetch("http://localhost:9000/comment/create", {
            // 통신할때 필요한 정보를 넣어주기
            method:"POST",
            headers:{
                "Content-type":"application/json;charset=utf-8"
            },
            // 자바스크립트 객체를 json으로 변환해서 넣기
            body:JSON.stringify(commentState)
        }).then(res => res.json())
          .then(res => {
                console.log(res)
            })
        window.location.href="/list"
    }

    const changeState = (e) => {
        console.log(e)
        setCommentState({
            ...commentState,
            [e.target.name]:e.target.value
        })
    }
   
    return (
        <form onSubmit={createSubmit}>
        <div className="commentEditor">
            <h2>댓글</h2>
            <div>
                <input
                name="writer"
                placeholder="작성자"
                type="text"
                value={commentState.writer}
                onChange={changeState}
                // onChange={function(e){
                //     setCommentState({
                //         writer:e.target.value,
                //         content:commentState.content
                //     })
                // }}
                />
            </div>
            <div>
                <textarea
                value={commentState.content}
                onChange={changeState}
                name="content"
                placeholder="내용"
                type="text"
                />
            </div>
            <div>
                <span>별점평가 : </span>
                <select
                name="rank"
                value={commentState.rank}
                onChange={changeState}
                >
                <option value={1}>1</option>
                <option value={2}>2</option>
                <option value={3}>3</option>
                <option value={4}>4</option>
                <option value={5}>5</option>
                </select>
            </div>
            <div>
                <button onClick={createSubmit}>저장하기</button>
            </div> 
        </div>
        </form>
    );
};

export default CommentWrite;