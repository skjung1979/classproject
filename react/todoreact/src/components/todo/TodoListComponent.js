import React, {useEffect, useState} from 'react';
import {getTodoList} from "../../apis/todoAPI";
import {Table, TableBody, TableCell, TableHead, TableRow} from "@mui/material";

function TodoListComponent({query, moveToRead}) {

    const [todos, setTodos] = useState([]) // 빈 배열로 초기화

    // 당장 처리되는 것이 아니라, 시간을 두고 처리되는 작업
    // 통신 코드를 안쪽에 넣는다.
    useEffect(() => {
        getTodoList().then(result => {
            setTodos(result)
        })
    }, [query])

    return (
        <>
            <Table sx={{minWidth: 650}} aria-label="simple table">
                <TableHead> {/*// == thead*/}
                    <TableRow> {/*// == tr*/}
                        {/*// == td*/}
                        <TableCell align="center">ID</TableCell>
                        <TableCell align="center">Title</TableCell>
                        <TableCell align="center">Writer</TableCell>
                        <TableCell align="center">Complete</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {todos.map((row)=>( // 괄호는 return 키원 없이 그냥 엘리먼트 반환 / 중괄호를 한다면 'return' 키워드 사용한다.
                        <TableRow key={row.id} onClick={moveToRead(row.id)}>
                            <TableCell align="center">{row.id}</TableCell>
                            <TableCell align="center">{row.title}</TableCell>
                            <TableCell align="center">{row.writer}</TableCell>
                            <TableCell align="center">{row.complete ? '완료' : '진행중'}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </>
    );
}

export default TodoListComponent;