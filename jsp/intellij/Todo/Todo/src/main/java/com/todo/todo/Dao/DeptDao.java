package com.todo.todo.Dao;

import com.todo.todo.domain.Dept;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface DeptDao {

    public List<Dept> selectAll(Connection conn) throws SQLException;

}
