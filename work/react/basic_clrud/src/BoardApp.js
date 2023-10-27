import { useEffect, useRef, useState } from 'react';
import './App.css';
import CommentList from './CommentList';
import CommentWrite from './CommentWrite';


function BoardApp() {
    //발생되는 데이터를 보관하기 위해서 dummy데이터를 사용하지 않는다.
    //이 댓글목록에 있는 값들이 변경되면 랜더링을 해야 하므로 상태값으로 관리해야 한다.
    const [datalist, setDataList] = useState([]);

    //CommentWrite컴포넌트에서 발생한 값을 전달받을 함수를 정의
    //저장공간이나 DOM요소를 접근하기 위해 사용되는 리액트 함수
    //데이터가 변경되어도 랜더링이 발생되지 않음
    //current속성을 이용해서 값을 사용
    const dataId = useRef(0);

    const getData = async () => {
        let resdata = await fetch("http://localhost:9001/erp/ajax/exam02")
                                    .then((res) => res.json())
        console.log(resdata)
        let resdata2 = resdata.dailyBoxOfficeList;
        // 외부서버에서 받아온 데이터를 가공
        // 1. 20개만 받아오기

        const initdata = resdata2.map((comment) => {
            return {
            //     // 2. 우리 데이터에 맞게 수정
                writer : comment.id,
                content : comment.content,
                rank : 5,
                write_date : comment.write_date,
                id : comment.board_no
            }
        })
        // 3. state 변경
        setDataList(initdata);
    }

    // 컴포넌트가 마운트될때 호출
    useEffect(() => {
        getData()
    }, [])
    const createData = (writer, content, rank) => {
        const write_date = new Date().getTime(); //밀리세컨드가 전달
        const newComment = {
            writer,
            content,
            rank,
            write_date,
            id: dataId.current,
        };
        dataId.current = dataId.current + 1;
        setDataList([...datalist, newComment]);
        console.log({...datalist})
    };
    //삭제를 위한 함수를 정의
    const commentDelete = (targetId) => {
        //삭제를 하면 해당 게시글이 제외된 나머지 게시글로 다시 렌더링
        //filter를 이용해서 조건에 만족하는 배열로 state값을 변경
        const newCommentlist = datalist.filter(comment => comment.id !== targetId )
        console.log(newCommentlist)
        // 조건에 만족하는 배열로 state값 변경
        setDataList(newCommentlist)
    };
    //정의한 함수를 CommentWrite의 props로 전달
    return (
        <div>
            <CommentWrite createData={createData}></CommentWrite>
            {/* 배열을 CommentList의 프로퍼티로 전달 */}
            <CommentList dataList={datalist} deleteRun={commentDelete}></CommentList>
        </div>
    );
}

export default BoardApp;