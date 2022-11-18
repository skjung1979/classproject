package com.todo.todospring.service;

import com.todo.todospring.dao.Dao;
import com.todo.todospring.domain.TodoDTO;
import com.todo.todospring.util.ConnectionUtil;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private Dao dao;

    public List<TodoDTO> getTodoList(){

        List<TodoDTO> list = new ArrayList<>();

        for (int i=0; i<10; i++){
            list.add(new TodoDTO(i+1, "todo "+i, "2022-11-26", false));
        }

        return list;
    }


    public int insertTodo(String todo, String dueDate, boolean finished) throws Exception {
        int result = 0;

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        result = dao.insertTodo(conn, todo, dueDate, finished);

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
