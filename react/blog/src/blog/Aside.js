import React from 'react';
import Category from "./Category";
import Latest from "./Latest";

function Aside({categoryDatas, articleDatas}) {
    return (
        <aside>
            <Category categoryDatas={categoryDatas}/>
            <Latest articleDatas={articleDatas}/>
        </aside>
    );
}

export default Aside;