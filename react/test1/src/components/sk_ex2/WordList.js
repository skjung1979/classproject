import React from 'react';

function WordList({words, removeWord}) {

    const list = words.map((wd, index) => {
        return (
            <li key={index}>{wd}
                <button onClick={() => removeWord(wd)}>삭제</button>
            </li>
        )
    })

    return (
        <div>
            <ul>
                {list}
            </ul>
        </div>
    );
}

export default WordList;