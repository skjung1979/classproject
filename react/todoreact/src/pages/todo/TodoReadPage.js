import React, {useState} from 'react';
import {Dialog, DialogTitle, Grid, Paper} from "@mui/material";
import PageLayout from "../../layout/PageLayout";
import {useNavigate, useParams, useSearchParams} from "react-router-dom";
import Typography from "@mui/material/Typography";
import TodoReadComponent from "../../components/todo/TodoReadComponent";
import TodoModifyComponent from "../../components/todo/TodoModifyComponent";

function TodoReadPage(props) {

    const {cmd, id} = useParams()
    const [msg, setMsg] = useState(null)
    const navigate = useNavigate()
    const [searchParams, setSearchParams] = useSearchParams()

    const page = searchParams.get("page")
    const size = searchParams.get("size")

    const moveToList = () => {
        const pageNum = page || 1
        const sizeNum = size || 10

        navigate({
            pathname: `/todo/list`,
            search: `?page=${pageNum}&size=${sizeNum}`
        })
    }

    const moveToModify = () => {
        const pageNum = page || 1
        const sizeNum = size || 10

        navigate({
            pathname: `/todo/modify/${id}`,
            search: `?page=${pageNum}&size=${sizeNum}`
        })
    }

    const moveToBack = () => {
        const pageNum = page || 1
        const sizeNum = size || 10

        navigate({
            pathname: `/todo/read/${id}`,
            search: `?page=${pageNum}&size=${sizeNum}`
        })
    }

    const setResult = (result) => {
        setMsg(result)
    }

    const closeAndMove = () => {
        setMsg(null)

        navigate("/todo/list")
    }

    const getComponent = () => {

        console.log('id >>>> ', id)

        if (cmd === 'read') {
            return <TodoReadComponent id={id} moveToList={moveToList} setResult={setResult}
                                      moveToModify={moveToModify}></TodoReadComponent>
        } else if (cmd === 'modify') {
            return <TodoModifyComponent id={id} setResult={setResult} moveToList={moveToList}
                                        moveToBack={moveToBack}></TodoModifyComponent>
        }
        return <></>
    }

    return (
        <PageLayout title={'Todo Read Page'}>
            <Grid item xs={12} md={12} lg={12}>
                <Paper sx={{p: 2, display: 'flex', flexDirection: 'column'}}>
                    {getComponent()}
                </Paper>
            </Grid>

            <Dialog open={msg !== null}
                    onClose={closeAndMove}
                    aria-labelledby="alert-dialog-title"
                    aria-describedby="alert-dialog-description"
                    id="alert-dialog-title"
            >
                <DialogTitle>처리 결과</DialogTitle>
                <Typography variant={'h6'}>{msg}</Typography>
            </Dialog>

        </PageLayout>
    );
}

export default TodoReadPage;