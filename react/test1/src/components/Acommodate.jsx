import React, { useState } from "react";
import { useEffect } from "react";
import useCounter from "./useCounter";

const MAX_CAPACITY = 10;

function Accommodate(props){
    
    const [isFull, setIsFull] = useState(false);

    const [count, incrementCount, decrementCount] = useCounter(0);

/*     useEffect(() => {
        console.log('####################');
        console.log('useEffect isFull => ', isFull);
    })
 */
    useEffect(() => {
        console.log('++++++++++++++++++++');
        console.log('useEffect isFull => ', isFull);

        // 비교를 해서 isFull 여부를 확인한다.
        if (count >= MAX_CAPACITY) {
            setIsFull(true);
        } else {
            setIsFull(false);
        }

        // 위 if문은 이렇게 처리도 가능하다.setIsFull(count >= MAX_CAPACITY)

        console.log('접속 인원', count)

    }, [count])

    return (
        <div style={{padding:16, margin:5}}>
            <p>{`총 ${count}명이 입장했습니다.`}</p>
            <button onClick={incrementCount} disabled={isFull}>입장</button>
            <button onClick={decrementCount}>퇴장</button>
            {isFull && <p style={{color:'red'}}>정원이 가득 찼습니다.</p>}
        </div>
    )
}

export default Accommodate;