import React, {useState} from 'react';
import WordInput from "./WordInput";
import WordList from "./WordList";

const style = {
    wrapper: {
        padding: 20,
        display: "flex",
        flexDirection: "row",
        justifyContent: "space-around"
    }
}

function WordContainerSk(props) {

    const [words, setWords] = useState(['AAA', 'BBB', 'CCC'])

    const addWord = (word) => {
        setWords([...words, word])
    }

    const removeWord = (word) => {
        const filteredWords = words.filter(w => w != word)
        setWords([...filteredWords])
    }

    return (
        <div style={style.wrapper}>
            <WordInput addWord={addWord}/>
            <WordList words={words} removeWord={removeWord}/>
        </div>
    );
}

export default WordContainerSk;