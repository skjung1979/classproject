import axios from "axios";

// todo 등록
export const postTodo = async (todo) => {
    /* todo => {id: , title: '청소', writer: '날강두', complete: false}*/
    const res = await axios.post('http://localhost:81/todos', todo)
    return res.data
}