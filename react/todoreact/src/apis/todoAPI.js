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

// todo 한개 데이터 조회
export const getTodo = async (id) => {
    const res = await axios.get(`http://localhost:81/todos/${id}`)
    return res.data
}

// todo 삭제
export const deleteTodo = async (id) => {
    const res = await axios.delete(`http://localhost:81/todos/${id}`)
    return res.data
}

// todo 수정
export const putTodo = async (todo) => {
    const res = await axios.put(`http://localhost:81/todos/${todo.id}`, todo)
    return res.data
}