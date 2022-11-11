package com.firstcoding.firstapp.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDao {

    public List<Dept> selectAll(Connection conn) throws Exception {

        String sql = "select * from dept";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Dept> result = null;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            result = new ArrayList<>();

            while (rs.next()){

                result.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (pstmt != null){
                pstmt.close();
            }
            if (rs != null){
                rs.close();
            }
        }

        return result;
    }

}
