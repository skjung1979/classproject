import axios from "axios";

// todo 등록
export const postTodo = async (todo) => {
    /* todo => {id: , title: '청소', writer: '날강두', complete: false}*/
    const res = await axios.post('http://localhost:81/todos', todo)
    return res.data
}

// todo 전체 리스트 조회
export const getTodoList = async () => {
    const res = await axios.get('http://localhost:81/todos')
    return res.data
}