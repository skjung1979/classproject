package com.todo.todo.dept;

import lombok.Cleanup;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDao implements Dao {

    public List<Dept> selectAll(Connection conn) throws SQLException {

        String sql = "select * from dept";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        List<Dept> result = new ArrayList<>();

        while (rs.next()){
            result.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
        }

        return result;
    }
}
