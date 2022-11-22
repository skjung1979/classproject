package com.todo.todo.dept;

import lombok.Cleanup;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface Dao {

    public List<Dept> selectAll(Connection conn) throws SQLException;

}
