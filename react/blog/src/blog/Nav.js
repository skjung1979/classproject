import React from 'react';
import '../default.css';

function Nav({datas}) {

    const list = [
        datas.map(item=>{
            return <li key={item.nid}><a href={'/read/' + item.nid }>{item.title}</a></li>
        })
    ]

    return (
        <nav>
            <ul>
                {list}
            </ul>
            <div>
                <input type="text"/>
                <input type="button" value="검색"/>
            </div>
        </nav>
    );
}

export default Nav;