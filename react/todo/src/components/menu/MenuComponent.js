import React from 'react';
import {Dashboard, DashboardCustomizeOutlined, DashboardCustomizeRounded, DashboardTwoTone} from "@mui/icons-material";
import List from "@mui/material/List";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import ListItemText from "@mui/material/ListItemText";

const menuArr = [
    {icon: <Dashboard/>, text: "Todo List"},
    {icon: <DashboardTwoTone/>, text: "Todo Write"},
    {icon: <DashboardCustomizeRounded/>, text: "Login"},
    {icon: <DashboardCustomizeOutlined/>, text: "Member Regist"}
]

function MenuComponent(props) {
    return (
        <List>
            {menuArr.map((menu, index) => {
                return (
                    <ListItemButton key={index}>
                        <ListItemIcon>{menu.icon}</ListItemIcon>
                        <ListItemText primary={menu.text}/>
                    </ListItemButton>
                )
            })}
        </List>
    );
}

export default MenuComponent;