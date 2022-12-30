import React from 'react';

const Wrapper = styled.div`
padding: 1em;
background-color: black;
` // 속성명은 css 형식 그대로 표기한다. backgroundColor(x-이건 자바스크립트 안에서) / background-color(o)

const Title = styled.h1`
font-size: 150%;
color: white;
text-align: center;
`

function MainPage(props) {
    return (
        <Wrapper>
            <Title>안녕하세요.</Title>
        </Wrapper>
    );
}

export default MainPage;