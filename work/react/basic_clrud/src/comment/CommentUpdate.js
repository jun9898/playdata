import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

const CommentUpdate = () => {
    const {commentNo} = useParams();
    const [comment, setComment] = useState({
        commentNo : "",
        writer : "",
        content : "",
        rank : "",
        writeData : ""
    });
    console.log(commentNo, "===================================")

    useEffect(() => {
        fetch("http://127.0.0.1:9000/comment/read/" + commentNo)
            .then(res => res.json())
            .then(res => {
                setComment(res);
            })
    },[])

    const changeState = (e) => {
        console.log(e)
        setComment({
            ...comment,
            [e.target.name]:e.target.value
        })
    }


    const updateSubmit = (e) => {
        e.preventDefault();
        fetch("http://127.0.0.1:9000/comment/update/" + commentNo, {
            method:"PUT",
            headers:{
                "Content-Type" : "application/json;charset=utf-8"
            },
            body:JSON.stringify(comment)
        }).then(res => res.json())
          .then(res => console.log(res))
        window.location.href="/list"
    }
    return (
        <div>
            <h1>수정하기</h1>
            <hr/>
            <div>
                <h2>번호:{comment.commentNo}</h2>
                <h2>작성자:{comment.writer}</h2>
                <h2>내용:</h2><input type="text" 
                            value={comment.content}
                            name="content"
                            onChange={changeState}/>
                <h2>날짜:{comment.writeDate}</h2>
                <h2>별점:</h2><input type="text" 
                                value={comment.rank}
                                name="rank"
                                onChange={changeState}/>
            </div>
            <div>
                <button onClick={updateSubmit}>수정하기</button>
            </div> 
        </div>
    );
};

export default CommentUpdate;