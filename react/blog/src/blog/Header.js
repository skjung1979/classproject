import React from 'react';

function Header({title, body}) {
    return (
        <header>
            <h1 className="title">{title}</h1>
            <p>{body}</p>
        </header>
    );
}

export default Header;