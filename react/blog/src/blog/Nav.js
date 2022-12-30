import React from 'react';
import '../default.css';

function Nav({datas, onChangeMode}) {

    const list = [
        datas.map(item=>{
            return <li key={item.nid}><a id={item.nid} href={'/read/' + item.nid } onClick={(e)=>{
            e.preventDefault();
            onChangeMode(Number(e.target.id));}
            }>{item.title}</a></li>
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