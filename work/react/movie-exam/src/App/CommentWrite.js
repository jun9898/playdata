import React, { useState } from 'react';

const CommentWrite = ({createData}) => {

    // 상태변화를 저장할때는 항상 새로운 객체를 만들어서 변경시켜야 한다
    const [commentState, setCommentState] = useState({writer : "", content : "", rank : 5});

    const changeState = (e) => {
        setCommentState({
            ...commentState,
            [e.target.name] : e.target.value
        })
    }

    // 저장하기 버튼이 눌러질때 호출되는 함수
    const createSubmit = () => {
        console.log("저장하기 버튼이 눌러질때 호출되는 함수 = "+commentState.writer)
        createData(commentState.writer, commentState.content, commentState.rank)
    }

    return (
        <div className="commentEditor">
            <h2>댓글</h2>
            <div>
                <input
                name="writer"
                placeholder="작성자"
                type="text"
                value={commentState.writer}
                onChange={changeState}
                />
            </div>
            <div>
                <textarea
                name="content"
                placeholder="내용"
                type="text"
                value={commentState.content}
                onChange={changeState}
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
                <button onClick={createSubmit}>일기 저장하기</button>
            </div> 
        </div>
    );
};

export default CommentWrite;