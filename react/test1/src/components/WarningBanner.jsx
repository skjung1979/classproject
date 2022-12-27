import React from "react";

function WarningBanner(props) {

    // warning이 true라면 위험! false라면 null(아무것도 표시 안한다)
    if(!props.warning) {
        return null
    }

    return (
        <>
            <h1>경고! 위험!</h1>
        </>
    )
}

export default WarningBanner