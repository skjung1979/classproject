import React from "react";

function MailBox(props) {

    const unReadMessage = props.unReadMessage;

    return (
        <div>
            <h1>Mail Box</h1>
            
            {unReadMessage.length > 0 && <h3>현재 {unReadMessage.length}개의 읽지 않은 메시지가 있습니다.</h3>} {/* // 앞에가 참이면 뒤에도 실행된다. 앞에가 거짓이면 뒤에도 실행안된다. */}

        </div>
    )
}

export default MailBox