package com.todo.todo.Dao;

import com.todo.todo.domain.Orders;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface OrdersDao {

    public List<Orders> ordersSelectAll(Connection conn) throws SQLException;

    public List<Orders> ordersSelectBy(Connection conn, int custid) throws SQLException;
}
