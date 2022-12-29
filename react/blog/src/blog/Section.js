import React from 'react';
import Article from "./Article";

function Section({articleDatas}) {

    return (
        <section>
            <Article articleDatas={articleDatas}/>
        </section>
    );
}

export default Section;