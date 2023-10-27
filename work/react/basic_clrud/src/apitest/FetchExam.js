import React from 'react';

const FetchExam = () => {
    const API_KEY = "Qsbquzef5Qx%2BG13cFm0uYsiBIn2Svq9eMNUSCQOVyNmJB9dOJGZ%2FS3g%2Flp5pd7TbOzOIOoU0FjjkESnZxzNeeA%3D%3D"
    const getData = async () => {
        let url = `https://api.odcloud.kr/api/15060017/v1/uddi:9be26c73-d883-42cf-ab36-d1a4de6cb092?page=1&perPage=10&serviceKey=${API_KEY}`
        let response = await fetch(url)
        let jsondata = response.json()
        console.log(jsondata)
    }
    return (
        <div>
            <button onClick={getData}>공공데이터 가져오기</button>
        </div>
    );
};

export default FetchExam;