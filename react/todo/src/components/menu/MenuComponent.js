import React from 'react';
import {Dashboard, DashboardCustomizeOutlined, DashboardCustomizeRounded, DashboardTwoTone} from "@mui/icons-material";
import List from "@mui/material/List";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import ListItemText from "@mui/material/ListItemText";

const menuArr = [
    {icon: <Dashboard/>, text: "Home", path: "/"},
    {icon: <DashboardTwoTone/>, text: "About", path: "/about"},
    {icon: <DashboardCustomizeRounded/>, text: "ToDo"},
    {icon: <DashboardCustomizeOutlined/>, text: "회원가입"}
]

const navigate = useNavigate();
const movePage = (path) => {
    console.log('movePage => ', path)

    if(path){
        navigate(path)
    }
}

function MenuComponent(props) {
    return (
        <List>
            {menuArr.map((menu, index) => {
                return (
                    <ListItemButton key={index}>
                        <ListItemIcon>{menu.icon}</ListItemIcon>
                        <ListItemText primary={menu.text} onClick={()=> movePage(menu.path)}/>
                    </ListItemButton>
                )
            })}
        </List>
    );
}

export default MenuComponent;