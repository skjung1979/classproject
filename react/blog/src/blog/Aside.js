import React from 'react';
import Category from "./Category";
import Latest from "./Latest";

function Aside(props) {
    return (
        <aside>
            <Category/>
            <Latest/>
        </aside>
    );
}

export default Aside;