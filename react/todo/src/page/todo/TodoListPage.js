import React from 'react';
import Ex1 from "../../components/ex/Ex1";
import PageLayout from "../../layout/PageLayout";
import {Grid, Paper} from "@mui/material";

function TodoListPage(props) {
    return (
        <PageLayout title={'Todo List Page'}>
            <Grid item xs={12} md={12} lg={12}>
                <Paper sx={{p: 2, display: 'flex', flexDirection: 'column'}}>
                    <h1>Todo Page</h1>
                    <Ex1/>
                </Paper>
            </Grid>
        </PageLayout>
    );
}

export default TodoListPage;