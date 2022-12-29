import React from "react";

// 역할: 상위 컴포넌틑에서 배열을 받아 리스트 출력
// 클릭 이벤트에 적용할 핸들러를 받아서 적용한다.
// 하나 하나의 데이터는 {mno: 1, name: '상품1', price: 1000}, {mno: 2, name: '상품2', price: 1500} 이런식으로 들어온다.
// changeMenu의 역할은 상품 번호를 받아서 선택 상품의 상태를 변경시키는 것이다.
function Displays({arr, changeMenu}) {

    return (
        <div>
            <ul>
                {arr.map(menu=> <li key={menu.mno} onClick={()=> changeMenu(menu.mno)}>{menu.name}</li>)}
            </ul>
        </div>
    )
}

export default Displays