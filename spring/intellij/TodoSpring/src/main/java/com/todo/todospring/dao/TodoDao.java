package com.todo.todospring.dao;

import com.todo.todospring.domain.TodoDTO;
import lombok.Cleanup;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "dotoDao")
public class TodoDao implements Dao {


    public int insertTodo(Connection conn, String todo, String dueDate, boolean finished) throws SQLException {

        int result = 0;
        String sql = "insert into tododto (todo, dueDates, finished) values(?, ?, ?)";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, todo);
        pstmt.setString(2, dueDate);
        pstmt.setBoolean(3, finished);
        result = pstmt.executeUpdate();

        return result;
    }

    public List<TodoDTO> selectAll(Connection conn) throws SQLException {

        List<TodoDTO> list = new ArrayList<>();
        String sql = "select tno, todo, duDates, finished from tododto;";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        while (rs.next()){
            list.add(new TodoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
        }
    return list;
    }

    public TodoDTO selectBy(Connection conn, int tno) throws SQLException {
        TodoDTO tododto = null;
        String sql = "select tno, todo, duDates, finished from tododto where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, tno);
        @Cleanup ResultSet rs = pstmt.executeQuery();

//        tno	int
//        todo	varchar(20)
//        memo	varchar(50)
//        dueDates	varchar(20)
//        finished	tinyint(1)

        while (rs.next()){
            tododto = new TodoDTO(rs.getInt("tno"), rs.getString("todo"), rs.getString("duDates"), rs.getBoolean("finished"));
        }

        return tododto;
    }

    public int updateTodo(Connection conn, TodoDTO dto) throws SQLException {
        int result = 0;
        String sql = "update tododto set todo=?, duedates=?, finished=? where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,dto.getTodo());
        pstmt.setString(3,dto.getDueDate());
        pstmt.setBoolean(4,dto.isFinished());
        pstmt.setLong(5,dto.getTno());

        result = pstmt.executeUpdate();

        return result;
    }

    public int deleteTodo(Connection conn, int tno) throws SQLException {

        int result = 0;
        String sql = "delete from tododto where tno=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, tno);

        result = pstmt.executeUpdate();

        return result;
    }
}
