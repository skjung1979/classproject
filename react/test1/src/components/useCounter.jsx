import React from "react";
import { useState } from "react";

function useCounter(initVal) {
    
    const [count, setCount] = useState(initVal)

    // 증가
    const incrementCount = () => setCount((count) => count + 1)

    // 감소
    const decrementCount = () => setCount((count) => Math.max(count - 1, 0)) // 마이너스의 최대값은 0으로한다.

    return [count, incrementCount, decrementCount]

}

export default useCounter