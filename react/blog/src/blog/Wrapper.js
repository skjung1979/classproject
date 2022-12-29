import React from 'react';
import Section from "./Section";
import Aside from "./Aside";

function Wrapper({articleDatas, categoryDatas, navDatas, mode}) {

    let content = null;
    console.log(mode)

    if ({mode} === 'WELCOME') {
        content = <Section articleDatas={articleDatas} mode="WELCOME"/>
    } else if ({mode} === 'READ') {
        content = <Section navDatas={navDatas} mode="READ"/>
    }

    return (
        <div id="wrap">
            {content}
            <Aside categoryDatas={categoryDatas} articleDatas={articleDatas}/>
        </div>
    );
}

export default Wrapper;