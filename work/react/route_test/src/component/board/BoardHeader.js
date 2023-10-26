import React from 'react';
import { Link } from 'react-router-dom';

const BoardHeader = () => {
    return (
        <>
           <hr/>
            <Link to={"/"}>Home</Link>&nbsp;
            <Link to={"/write"}>write</Link>&nbsp;
            <Link to={"/list"}>list</Link>&nbsp;
            <Link to={"/read"}>read</Link>&nbsp;
            <Link to={"/update"}>update</Link>&nbsp;
           <hr/>

        </>
    );
};

export default BoardHeader;