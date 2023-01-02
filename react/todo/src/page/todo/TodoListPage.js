import React from 'react';
import {Grid, Paper} from "@mui/material";
import PageLayout from "../../layout/PageLayout";

function TodoListPage(props) {
    return (
        <PageLayout title={'Todo List Page'}>
            <Grid item xs={12} md={12} lg={12}>
                <Paper sx={{p:2, display:'flex',flexDirection: 'column'}}>
                    <h1>Todo List Page</h1>
                </Paper>
            </Grid>
        </PageLayout>
    );
}

export default TodoListPage;