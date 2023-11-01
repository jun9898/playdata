import React from 'react';
import {BrowserRouter, Routes, Route}from 'react-router-dom'
import Menu from './Menu';
import CommentWrite from './CommentWrite';
import CommentList from './CommentList';
import CommentRead from './CommentRead';
import CommentUpdate from './CommentUpdate';

const CommentMain = () => {
    return (
        <BrowserRouter>
            <div className='commentList'>
                <Menu/>
                <Routes>
                    <Route path='/write' element={<CommentWrite/>}/>
                    <Route path='/list' element={<CommentList/>}/>
                    <Route path='/read/:commentNo' element={<CommentRead/>}/>
                    <Route path='/update/:commentNo' element={<CommentUpdate/>}/>
                </Routes>

            </div>
        </BrowserRouter>
    );
};

export default CommentMain;