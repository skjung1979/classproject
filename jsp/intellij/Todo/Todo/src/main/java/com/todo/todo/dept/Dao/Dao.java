package com.todo.todo.dept.Dao;

import com.todo.todo.dept.domain.Dept;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface Dao {

    public List<Dept> selectAll(Connection conn) throws SQLException;

}
