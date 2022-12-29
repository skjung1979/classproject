import React from 'react';
import Section from "./Section";
import Aside from "./Aside";

function Wrapper({articleDatas, categoryDatas}) {
    return (
        <div id="wrap">
            <Section articleDatas={articleDatas}/>
            <Aside categoryDatas={categoryDatas} articleDatas={articleDatas}/>
        </div>
    );
}

export default Wrapper;