import React from 'react';
import { Link } from 'react-router-dom';

const Menu = () => {
    return (
        <>
            &nbsp; &nbsp; <Link to={"/"} >Home</Link>&nbsp;  &nbsp;  
            <Link to={"/write"} >등록</Link>&nbsp;   &nbsp;   
            <Link to={"/list"} >목록보기</Link>&nbsp;  &nbsp; 
            
        </>
    );
};

export default Menu;