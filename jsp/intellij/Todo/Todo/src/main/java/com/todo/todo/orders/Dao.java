package com.todo.todo.orders;

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

    public List<Orders> ordersSelectAll(Connection conn) throws SQLException;

    public List<Orders> ordersSelectBy(Connection conn, int custid) throws SQLException;
}
