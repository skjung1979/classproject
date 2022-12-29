import React, {useState} from 'react';
import Displays from "./Displays";
import Details from "./Details";

const menus = [
    {mno: 1, name: '아메리카노', price: 1000},
    {mno: 2, name: '꿀아메리카노', price: 2000},
    {mno: 3, name: '흑당라떼', price: 2000},
    {mno: 4, name: '바닐라라떼', price: 3000},
    {mno: 5, name: '밀크쉐이크', price: 4000},
]

const style = {
    wrapper: {
        padding: 20,
        display: "flex",
        flexDirection: "row",
        justifyContent: "space-around"
    }
}

function ContainerSk(props) {

    const [selectedMenu, setSelectedMenu] = useState()

    const changeMenu = (mno) => {
        // menus에서 상품번호로 검색 => 1개의 상품 객체 반환
        const menu = menus.find(menu => menu.mno === mno)

        setSelectedMenu(menu)

    }

    return (
        <div>
            <Displays arr={menus} changeMenu={changeMenu}/>
            <Details menu={selectedMenu}/>
        </div>
    );
}

export default ContainerSk;