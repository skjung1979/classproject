import React from "react";
import { useState } from "react";

function NameForm(props) {

    const [value, setValue] = useState(''); // ''안에는 DB의 초기값을 넣어준다.

    const handleChange = (event) => {
        setValue(event.target.value) // event.target --> 이벤트가 발생하는 개체
    }

    const handleSubmit = (event) => {
        event.preventDefault()
        alert('입력한 이름은 ' + value)
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>
                이름 :
                <input type="text" value={value} onChange={handleChange}/>
            </label>
            <button type="submit">제출</button>
        </form>
    )
}

export default NameForm