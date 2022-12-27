import React from "react";
import { useState } from "react";

function Toggle(props) {

    const [isToggleOn, setisToggleOn] = useState(true);

    function handleClick1() {
        setisToggleOn(isToggleOn => !isToggleOn)
    }    

    const handleClick2 = () => {
        setisToggleOn(isToggleOn => !isToggleOn)
    }

    return (
        <button onClick={handleClick1}>
            {isToggleOn ? '켜짐' : '꺼짐'}
        </button>
    )
}

export default Toggle