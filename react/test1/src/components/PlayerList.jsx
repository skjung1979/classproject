import React from "react";
import Player from "./Player";

function Team(props) {

    return (
        <div>
            <Player playerName='SON' playerNumber='7'></Player>
            <Player playerName='KANE' playerNumber='10'></Player>
            <Player playerName='JO' playerNumber='11'></Player>
        </div>
    )
}

export default Team;