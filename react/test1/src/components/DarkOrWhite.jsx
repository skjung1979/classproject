import React from "react";
import { useState } from "react";
import MainContent from "./MainContent";
import ThemeContext from "./ThemeContext";

function DarkOrWhite(props) {

    const [theme, setTheme] = useState('white')

    const toggleTheme = (evnet) => {

    }

    return (

        <ThemeContext.Provider value={{theme, toggleTheme}}>
            <MainContent />
        </ThemeContext.Provider>

    )
}