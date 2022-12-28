import React from "react";
import FancyBorder from "./FancyBorder";

function WelcomeMessage(props) {

    return (

        <FancyBorder color="blue">
            <h1>안녕하세요.</h1>
            <p>방문해주셔서 감사합니다.</p>
        </FancyBorder>

    )
}

export default WelcomeMessage