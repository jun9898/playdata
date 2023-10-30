import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import CommentApp from './BoardApp';
import MovieApp from './MovieApp';
import LifeCycleTest from './LifeCycleTest';
import AsyncTest from './apitest/AsyncTest';
import AsyncTest2 from './apitest/AsyncTest2';
import TestCallBack from './apitest/TestCallBack';
import CallBackHellTest from './apitest/CallBackHellTest';
import PromiseExam from './apitest/PromiseExam';
import AsyncAwaitTest from './apitest/AsyncAwaitTest';
import FetchTest from './apitest/FetchTest';
import FetchExam from './apitest/FetchExam';
import BoardApp from './BoardApp';
import CommentMain from './comment/CommentMain';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  // StricMode는 개발자 모드에서만 두번씩 빌드된다
  // 이유는 에러를 쉽게 찾으려고
  // <React.StrictMode>
    <CommentMain />
  // </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
