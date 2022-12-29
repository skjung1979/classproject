import React from 'react';

// Container컴포넌트에서 배열을 받아 리스트에 출력
function Displays({arr, changeMenu}) {

    return (
        <div>
            <ul>
                {arr.map(menu => <li key={menu.mno} onClick={() => changeMenu(menu.mno)}>{menu.name}</li>)}
            </ul>
        </div>
    );
}

export default Displays;