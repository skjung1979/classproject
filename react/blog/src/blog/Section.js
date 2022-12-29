import React from 'react';
import Article from "./Article";

function Section(props) {
    return (
        <section>
            <Article/>
            <Article/>
            <Article/>
        </section>
    );
}

export default Section;