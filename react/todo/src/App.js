import './App.css';
import Ex1 from './components/ex/Ex1';
import MainPage from "./page/MainPage.js";
import routers from "./routers"

function App() {
    return (
        <>
            <RouterProvider router={routers}/>
        </>

    );
}

export default App;
