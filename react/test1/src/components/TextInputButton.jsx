import React from "react";
import { useRef } from "react";

function TextInputButton(props) {

    const inputEl = useRef(null);

    const onButtonClick = () => {
        // current는 연결되어 있는 객체 input을 가리킨다.
        inputEl.current.focus();
        inputEl.current.value='new Message';
    }

    return (
        <div>
            <input ref={inputEl} type="text" />
            <button onClick={onButtonClick}>Click!!</button>
        </div>
    )

}

export default TextInputButton;