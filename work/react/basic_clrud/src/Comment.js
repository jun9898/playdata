import React from 'react';

const Comment = ({id,writer,content,rank,write_date, deleteRun}) => {
    return (
        <div className='comment'>
            <div className='info'>
                <span>작성자 : {writer} --------------------- 좋아요 : {rank} </span>
                <span className='date'>[작성시간 : {new Date(write_date).toLocaleString()}]</span>
                <div>
                    내용 : {content}
                </div>
            </div>
            <button onClick={() => {
                console.log(id, "===============================")
                if(window.confirm(`${id} 의 댓글을 삭제하시겟습니까?`)) {
                    deleteRun(id)
                }
            }}
            >삭제</button>
            <button>수정</button>
            <button>상세보기</button>
        </div>
    );
};

export default Comment;