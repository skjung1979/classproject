package com.todo.todo.Dao.todo;

import com.todo.todo.domain.todo.TodoDTO;
import com.todo.todo.domain.member.Member;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Dao {

    public int insertTodo(Connection conn, TodoDTO todoDTO) throws SQLException;

    public List<TodoDTO> selectAll(Connection conn) throws SQLException;

    public TodoDTO selectBy(Connection conn, int tno) throws SQLException;

    public int updateTodo(Connection conn, TodoDTO dto) throws SQLException;

    public int deleteTodo(Connection conn, int tno) throws SQLException;

    int insertTodoMember(Connection conn, Member member) throws SQLException;

    Member selectByUidPw(Connection conn, String userid, String userpw) throws SQLException;

    int updateUUID(Connection conn, int seq, String toString) throws SQLException;

    Member selectByUUID(Connection conn, String uuid) throws SQLException;
}