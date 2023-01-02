import React from 'react';
import {Grid, Paper} from "@mui/material";
import PageLayout from "../../layout/PageLayout";
import {useParams} from "react-router-dom";
import Typography from "@mui/material/Typography";

function TodoReadPage(props) {
// 하나의 데이터를 가져와서 읽어야 하고, 삭제 처리도 함께 하려함.

    const {cmd, id} = useParams()

    const getComponent = () => {
        if (cmd === 'read') {
            return
        } else if (cmd === 'modify') {
            return null
        }
        return <></>
    }

    return (
        <PageLayout title={'Todo Read Page'}>
            <Grid item xs={12} md={12} lg={12}>
                <Paper sx={{p: 2, display: 'flex', flexDirection: 'column'}}>
                    <h1>Todo Read Page</h1>
                    <Typography variant={'h3'}>{id}</Typography>
                </Paper>
            </Grid>
        </PageLayout>
    );
}

export default TodoReadPage;