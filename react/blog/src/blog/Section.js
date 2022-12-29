import React from 'react';
import Article from "./Article";

function Section({articleDatas, navDatas, mode}) {

    let content = null;

    if ({mode} === 'WELCOME'){
        content = <Article articleDatas={articleDatas} mode="WELCOME"/>
    } else if ({mode} === 'READ'){
        content = <Article navDatas={navDatas} mode="READ"/>
    }

    return (
        <section>
            {content}
        </section>
    );
}

export default Section;