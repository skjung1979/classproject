import React from 'react';

function Header({title, body, onChangeMode}) {
    return (
        <header>
            <h1 className="title" onClick={() => {
                onChangeMode()
            }}>{title}</h1>
            <p>{body}</p>
        </header>
    );
}

export default Header;