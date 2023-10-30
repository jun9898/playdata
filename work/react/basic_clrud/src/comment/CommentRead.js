import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

const CommentRead = () => {

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

    return (
        <div>
            <h1>상세보기</h1>
            <hr/>
            <div>
                <h2>번호: {comment.commentNo}</h2>
                <h2>작성자:{comment.writer}</h2>
                <h2>내용:{comment.content}</h2>
                <h2>날짜:{comment.writeData}</h2>
                <h2>별점:{comment.rank}</h2>
            </div>
        </div>
    );
};

export default CommentRead;