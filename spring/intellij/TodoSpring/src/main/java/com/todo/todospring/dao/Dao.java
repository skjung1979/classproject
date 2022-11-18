package com.todo.todospring.dao;

import com.todo.todospring.domain.TodoDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Dao {

    public int insertTodo(Connection conn, String todo, String dueDate, boolean finished) throws SQLException;

    public List<TodoDTO> selectAll(Connection conn) throws SQLException;

    public TodoDTO selectBy(Connection conn, int tno) throws SQLException;

    public int updateTodo(Connection conn, TodoDTO dto) throws SQLException;

    public int deleteTodo(Connection conn, int tno) throws SQLException;


}
