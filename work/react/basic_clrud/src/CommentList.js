import React from 'react';
import Comment from './Comment';

const CommentList = ({dataList, deleteRun}) => {
    console.log("list로 넘어온 데이터 = ")
    console.log(dataList)
    return (
        <div className='commentList'>
            {console.log("댓글 갯수" + dataList.length)}
            <h1>댓글 리스트({dataList.length}개)</h1>
            <div>
                {dataList.map((comment) => (
                    <Comment key={comment.id} {...comment} 
                    deleteRun = {deleteRun}></Comment>
                ))}

            </div>
        </div>
    );
};

// 속성이 전달되지 않는 경우 기본속성을 정의할 수 있다
CommentList.defaultProps= {
    dataList : []
}
export default CommentList;