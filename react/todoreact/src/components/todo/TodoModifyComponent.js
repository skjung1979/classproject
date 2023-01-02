import React, {useEffect, useState} from 'react';
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";
import {Button, Checkbox, FormControlLabel, Stack, TextField} from "@mui/material";
import {getTodo, putTodo} from "../../apis/todoAPI";

function TodoModifyComponent({id, setResult, moveToList, moveToBack}) {

    const [todo, setTodo] = useState({}) /*폼을 수정해야하기 때문에 상태 값을 갖고 있어야 한다.*/

    // todo를 가져와야 한다.
    useEffect(() => {
        getTodo(id).then(result => {
            setTodo(result)
        })
    }, [])

    const changeTodo = (e) => {
        todo[e.target.name] = e.target.value
        setTodo({...todo})
    }

    const changeTodoComplete = (e) => {
        todo['complete'] = e.target.checked
        setTodo({...todo})
    }

    const clickModify = async () => {
        const result = await putTodo(todo)
        setResult('수정되었습니다!')
    }

    return (
        <>
            <Typography variant={'h4'} sx={{p: 3}}>Todo Modify Page</Typography>
            <Box sx={{p: 1}}>
                <TextField
                    variant="outlined"
                    fullWidth
                    name={'id'}
                    label={'ID'}
                    value={String.todo.id}
                ></TextField>
            </Box>
            <Box sx={{p: 1}}>
                <TextField
                    variant="outlined"
                    fullWidth
                    name={'title'}
                    label={'title'}
                    value={String.todo.title}
                    onChange={(e) => changeTodo(e)}
                ></TextField>
            </Box>
            <Box sx={{p: 1}}>
                <TextField
                    variant="outlined"
                    fullWidth
                    name="writer"
                    label="writer"
                    value={String.todo.writer}
                    onChange={(e) => changeTodo(e)}
                ></TextField>
            </Box>
            <Box sx={{p: 1}}>
                <FormControlLabel
                    control={<Checkbox checked={Boolean(todo.complete)}/>}
                    onChange={(e) => changeTodoComplete(e)}
                    label='Complete'/>
            </Box>
            <Box sx={{p: 1}} display={"flex"} justifyContent={"right"}>
                <Stack spacing={2} direction="row">
                    <Button variant={"contained"} onClick={() => clickModify()}>Modify</Button>
                    <Button variant={"contained"} onClick={() => moveToBack()}>취소(이전페이지로!)</Button>
                    <Button variant={"contained"} onClick={() => moveToList()}>List</Button>
                </Stack>
            </Box>
        </>
    );
}

export default TodoModifyComponent;