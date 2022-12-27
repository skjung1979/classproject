import React from "react";

function UserGreeting(props) {
    return <h1>다시 오셨군요! 반갑습니다. ^^</h1>
}

function GuestGreeting(props) {
    return (
        <h1>처음 오셨군요! 회원 가입 해 주세요.</h1>
    )
}

function Greeting(props) {

    const isLogin = props.isLogin

    if(isLogin) {
        return <UserGreeting/>
    }

    return <GuestGreeting/>
}

export default Greeting