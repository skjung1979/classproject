import React from 'react';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import TextField from '@mui/material/TextField';
import Box from '@mui/material/Box';

function TodoRegisterComponent(props) {
    return (
        <>
            <Typography variant={'h4'} sx={{p: 3}}>Todo Register Page</Typography>
            <box sx={{p: 1}}>
                <TextField
                    variant="outlined"
                    fullWidth
                    name={'title'}
                    label={'title'}
                >
                </TextField>
            </box>
            <box sx={{p: 1}}>
                <TextField
                    fullWidth
                    name="writer"
                    label="writer"
                >
                </TextField>

            </box>
            <box sx={{p: 1}} display={"flex"} justifyContent={"right"}>
                <Button variant={"contained"}>등록</Button>
            </box>
        </>
    );
}

export default TodoRegisterComponent;