import React from 'react';
import styled from "styled-components";

const Wrapper = styled.div`
    padding: 1em;
    background-color: gray;
    /*/!*속성명은 css 형식 그대로 표기한다. backgroundColor(x-이건 자바스크립트 안에서) / background-color(o)*!/*/
    display: flex;
    flex-direction: row;
    align-items: flex-start;
`

const Block = styled.div`
    padding: ${props => props.padding}; /*동적으로 받아서 처리하겠다.*/
    border: 1px solid black;
    border-radius: 1rem;
    background-color: ${props => props.backColor};
    color: white;
    font-size: 2rem;
    font-weight: bold;
    text-align: center;
`

const Title = styled.h1`
    font-size: 150%;
    color: white;
    text-align: center;
`

const Button = styled.button`
    color: ${props => props.dark ? "white" : "black"};
    background-color: ${props => props.dark ? "black" : "white"};
    border: 3px solid black;
    margin: 10px;
    padding: 5px;
`

const RoundedButton = styled(Button)`
    border-radius: 5px;
`

const blockItems = [
    {label: "아메리카노", padding: "1rem", backColor: "red"},
    {label: "바닐라라떼", padding: "2rem", backColor: "pink"},
    {label: "밀크티", padding: "3rem", backColor: "aqua"}
]

function MainPage(props) {
    return (
        <Wrapper>
            {/*<Title>안녕하세요.</Title>
            <Button>ButtonA</Button>
            <Button dark>ButtonB</Button>
            <RoundedButton>ButtonC</RoundedButton>*/}

            {blockItems.map((item, index) => {
                return (
                    <Block
                        padding={item.padding}
                        backColor={item.backColor}
                    >
                        {item.label}
                    </Block>
                )
            })}

        </Wrapper>
    );
}

//export default MainPage;