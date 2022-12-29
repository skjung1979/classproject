import React, {useState} from 'react';

function WordInput({addWord}) {

    const [text, setText] = useState()

    const handleAddWord = (e) => {
        addWord(text)
        setText('')
    }

    return (
        <div>
            <input
                value={text}
                onChange={(e) => setText(e.target.value)}
            />
            <button onClick={handleAddWord}>단어 추가</button>
        </div>
    );
}

export default WordInput;