import React, {useState} from 'react';
import {Dialog, DialogTitle, Grid, Paper} from "@mui/material";
import PageLayout from "../../layout/PageLayout";
import {useNavigate, useParams} from "react-router-dom";
import Typography from "@mui/material/Typography";
import TodoRegisterComponent from "../../components/todo/TodoRegisterComponent";

function TodoRegisterPage(props) {

    const [msg, setMsg] = useState(null)
    const navigate = useNavigate()

    const setResult = (result) => {
        setMsg(result)
    }

    const closeAndMove = () => {
        setMsg(null)

        navigate("/todo/list")
    }

    return (
        <PageLayout title={'Todo Register Page'}>
            <Grid item xs={12} md={12} lg={12}>
                <Paper sx={{p: 2, display: 'flex', flexDirection: 'column'}}>
                    <TodoRegisterComponent setResult={setResult}></TodoRegisterComponent>
                </Paper>
            </Grid>

            <Dialog open={msg !== null}
                    onClose={closeAndMove}
                    aria-labelledby="alert-dialog-title"
                    aria-describedby="alert-dialog-description"
                    id="alert-dialog-title"
            >
                <DialogTitle>등록 결과</DialogTitle>
                <Typography variant={'h6'}> 할일 등록 성공</Typography>
            </Dialog>
        </PageLayout>
    );
}

export default TodoRegisterPage;