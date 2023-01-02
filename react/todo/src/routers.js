import {createBrowserRouter} from "react-router-dom";
import MainPage from "./page/MainPage.js"
import AboutPage from "./page/AboutPage.js"

const routers = createBrowserRouter([
    {
        path: "",
        element: <MainPage></MainPage>
    },
    {
        path: "about",
        element: <AboutPage></AboutPage>
    },
    {
        path: "todo",
        children: [
            {
                path: "list",
                element: <TodoListPage></TodoListPage>
            },
            {
                path: "register",
                element: <TodoRegisterPage></TodoRegisterPage>
            },
            {
                path: "",
                element: <Navigate to={"/todo/list" replace={true}></Navigate>
            }
        ]
    }
    ])

export default routers