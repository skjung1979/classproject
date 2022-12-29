import React from 'react';
import '../default.css';

function Nav(props) {
    return (
        <nav>
            <ul>
                <li>HTML5</li>
                <li>CSS3</li>
                <li>JavaScript</li>
            </ul>
            <div>
                <input type="text"/>
                <input type="button" value="검색"/>
            </div>
        </nav>
    );
}

export default Nav;