import React from "react";
import { useState } from "react";

function ReservationForm(props) {

    const [haveBreakfast, setHaveBreakfast] = useState(true) // 기본적으로 체크가 되어 있는 상태를 위해서.
    const [guestOfNum, setGuestOfNum] = useState(2)

    const handleSubmit = (event) => {
        event.preventDefault()
        alert(`조식 여부 : ${haveBreakfast}, 방문객 수: ${guestOfNum}명`)
    }

    return (
        <form onSubmit={handleSubmit}>
            <label>
                조식 여부 : 
                <input 
                    type="checkbox" 
                    checked={haveBreakfast} 
                    onChange={(event) => {
                        setHaveBreakfast(event.target.checked)
                    }} />
            </label>
            <br/>
            <label>
                방문객 수 : 
                <input 
                    type="text" 
                    value={guestOfNum}
                    onChange={(event) => {
                        setGuestOfNum(event.target.value)
                    }}
                     />
            </label>
            <br/>
            <button type="submit">제출</button>
        </form>
    )

}

export default ReservationForm