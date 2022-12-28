import React from "react";

function NumberList(props) {

    const numbers = [11, 22, 33, 44, 55]

    // 배열의 map(callback이 반환하는 값들로) => 새로운 배열을 만든다.
    const listItems = numbers.map((number, index) => <li key={index} aa={index}>{number}</li>)
    // 결과는 [{}, {}, {}, {}, {}] 이렇게 들어간다.
    // map은 새로운 배열을 만든다
    // callback의 반환값이 새로운 요소가 된다.
    // <li>{number}</li> 이것은 리액트 엘리먼트이다.

    return (
        <ul>
            {listItems}
        </ul>
    )
}

export default NumberList