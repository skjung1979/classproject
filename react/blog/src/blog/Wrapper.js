import React from 'react';
import Section from "./Section";
import Aside from "./Aside";

function Wrapper(props) {
    return (
        <div id="wrap">
            <Section/>
            <Aside/>
        </div>
    );
}

export default Wrapper;