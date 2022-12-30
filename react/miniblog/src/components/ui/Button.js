import React from 'react';
import styled from "styled-components";

const StyledButton = styled.button`
    padding: 8px 16px;
    font-size: 16px;
    border-width: 1px; /*보더 두께*/
    border-radius: 8px;
    cursor: pointer;
`

function Button({title, onClick}) {
    return (
        <StyledButton onClick={onClick}>
            {title || "Button"} {/*title값이 없다면 "Button"*/}
        </StyledButton>
    );
}

export default Button;