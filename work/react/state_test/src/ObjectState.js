/* eslint-disable react-hooks/exhaustive-deps */
import React from 'react';
import {useState, useEffect} from 'react';
// [] - 배열
// {} - 객체
const ObjectState = () => {

    const [result, setResult] = useState({count:0, price:0, totalPrice:0})

    useEffect(() => {
        setResult({...result, totalPrice : result.count * result.price})
        console.log("응애")
    }, [result.price, result.count])

    function inputPrice(event) {
        // setResult({...result, price : event.target.value, totalPrice : result.count * result.price})
        setResult({...result, price : event.target.value})
    }

    function inputCount(event) {
        setResult({...result, count : event.target.value})
    }

    console.log(result)
    return (
        <div>
            <h1>수량 : </h1>
            <input type='number' onChange={inputPrice}/>
            <h1>가격 : </h1>
            <input type='number' onChange={inputCount}/>
            <h1>결과 : {result.totalPrice}</h1>
        </div>
    );
};

export default ObjectState;