package com.todo.todo.orders.Dao;

import com.todo.todo.orders.domain.Orders;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface Dao {

    public List<Orders> ordersSelectAll(Connection conn) throws SQLException;

    public List<Orders> ordersSelectBy(Connection conn, int custid) throws SQLException;
}
