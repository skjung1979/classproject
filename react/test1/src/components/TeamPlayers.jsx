import React from "react";

function TeamPlayers(props) {

    const players = [
        {id:1, name: '손흥민'},
        {id:2, name: '이강인'},
        {id:3, name: '조규성'},
        {id:4, name: '황희찬'},
        {id:5, name: '김민재'}
    ]

    return (
        <ul>
            {
                players.map((player, index) => { // index는 사용하든 안하든 이렇게 포함시켜야 한다.
                    return <li key={player.id}>{player.name}</li>
                })
            }
        </ul>
    )
}

export default TeamPlayers