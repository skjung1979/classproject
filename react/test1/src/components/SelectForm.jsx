import React from "react";
import { useState } from "react";

function SelectForm(props) {

    const [value, setValue] = useState(props.init) // 초기값을 props에서 받아서 넣어도 된다.
    //const [value, setValue] = useState('orange') 

    const handleChange = (event) => {
        setValue(event.target.value)
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        alert('선택한 과일: ' + value)
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>
                과일 선택:
                <select value={value} onChange={handleChange}>
                    <option value="apple">사과</option>
                    <option value="banana">바나나</option>
                    <option value="grape">포도</option>
                    <option value="orange">오렌지</option>
                </select>
            </label>
            <br/>
            <button type="submit">제출</button>
        </form>

    )
}

export default SelectForm