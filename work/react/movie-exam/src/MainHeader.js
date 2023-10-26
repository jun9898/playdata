import React from 'react';
import { Link } from 'react-router-dom';

const MainHeader = () => {
    return (
        <>
            <hr/>
                <Link to={"/"} >[      Home     ]</Link> 
                <Link to={"/moviewrite"} >[      Write     ]</Link>
                <Link to={"/movielist"} >[      List     ]</Link>
                <Link to={"/app"}>[      게시판     ]</Link>
            <hr/>
            
        </>
    );
};

export default MainHeader;