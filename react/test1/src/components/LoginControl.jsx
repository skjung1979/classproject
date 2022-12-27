import React from "react";
import { useState } from "react";

function LoginButton(props) {
    return (
        <button onClick={props.onClick}> {/* props.onClick의 onClick은 이벤트가 아닌 속성 이름이다. // 이 컴포넌트는 단순 UI이다! 속성을 통해서 이벤트를 받아온다 */}
            로그인
        </button>
    )
}

function LogoutButton(props) {
    return (
        <button onClick={props.onClick}>
            로그아웃
        </button>
    )
}

function LoginControl(props) {
    
    const [isLogin, setIsLogin] = useState(false);

    const handleLoginClick = () => {
        setIsLogin(true)
    }

    const handleLogoutClick = () => {
        setIsLogin(false)
    }

    let button;

    if (isLogin) {

        button = <LogoutButton onClick={handleLogoutClick}/>

    } else {

        button = <LoginButton onClick={handleLoginClick}/>

    }

    return (
        <>
        {button}
        </>
    )
}

export default LoginControl