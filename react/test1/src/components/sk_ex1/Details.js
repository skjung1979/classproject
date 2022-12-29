import React from 'react';

function Details({menu}) {

    if (!menu) {
        return (
            <div>선택된 메뉴가 없습니다.</div>
        )
    }

    return (
        <div>
            <h3>상품 번호: {menu.mno}</h3>
            <h3>상품명: {menu.name}</h3>
            <h3>상품 가격: {menu.price}</h3>
        </div>
    );
}

export default Details;