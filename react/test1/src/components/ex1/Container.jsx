import React from "react";
import { useState } from "react";
import Details from "./Details";
import Displays from "./Displays";

// 역할: 컨테이너
// 하위 컴포넌트에 전달할 데이터를 가지고 있어야 한다.
// 상태값을 가지고 있고, 하위 컴포넌트에 전달해야 한다.
// 상태값을 변경해주는 함수도 하위 컴포넌트에 전달해야 한다.

const menus = [
    {mno: 1, name: '아메리카노', price: 1000}, 
    {mno: 2, name: '바닐라라떼', price: 1500},
    {mno: 3, name: '유자차', price: 2000},
    {mno: 4, name: '우유', price: 2500},
    {mno: 5, name: '카푸치노', price: 3000}
]

const style = {
    wrapper: {
        padding: 20,
        display: "flex",
        flexDirection: "row",
        justifyContent: "space-around"
    }
}

function Container(props) {

    // 선택(클릭)한 메뉴를 속성으로 저장 한다. <- Detail로 데이터를 전달하기 위해서!!!
    // selectedMenu => {mno: 5, name: '카푸치노', price: 3000} 이렇게 한 행을 선택하게 된다.
    const [selectedMenu, setSelectedMenu] = useState();

    const changeMenu = (mno)=> {
        // 배열에서 상품 번호로 상품 검색 -> 해당 상품의 객체를 반환
        const menu = menus.find(menu=> menu.mno===mno)
        // 선택 메뉴는 속으로 관리하는 선택 메뉴의 값을 변경
        setSelectedMenu(menu) 
    }

    return (
        <div style={style.wrapper}>
            <Displays arr={menus} changeMenu={changeMenu}/>
            <Details menu={selectedMenu}/>
        </div>
    )
}

export default Container