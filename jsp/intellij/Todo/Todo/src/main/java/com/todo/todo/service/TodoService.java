package com.todo.todo.service;

import com.todo.todo.Dao.TodoDao;
import com.todo.todo.domain.TodoDTO;
import com.todo.todo.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class TodoService {

    TodoDao dao = new TodoDao();

    public List<TodoDTO> getTodoList(){

        List<TodoDTO> list = new ArrayList<>();

        for (int i=0; i<10; i++){
            list.add(new TodoDTO(i+1, "todo "+i, "자세한 설명들", "2022-11-26", false));
        }

        return list;
    }


    public int insertTodo(String todo, String memo, String dueDate, boolean finished) throws Exception {
        int result = 0;

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        result = dao.insertTodo(conn, todo, memo, dueDate, finished);

        return result;
    }

    public List<TodoDTO> selectAll() throws Exception {

        List<TodoDTO> list = new ArrayList<>();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        list = dao.selectAll(conn);

        return list;
    }

    public TodoDTO selectBy(int tno) throws Exception {
        TodoDTO tododto = new TodoDTO();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        tododto = dao.selectBy(conn, tno);

        return tododto;
    }

    public int updateTodo(TodoDTO dto) throws Exception {

        int result = 0;

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        result = dao.updateTodo(conn, dto);

      return result;
    }

    public int deletTodo(int tno) throws Exception {

        int result = 0;

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        result = dao.deleteTodo(conn, tno);

        return result;
    }
}
