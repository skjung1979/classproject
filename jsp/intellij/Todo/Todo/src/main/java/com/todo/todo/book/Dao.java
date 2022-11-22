package com.todo.todo.book;

import com.todo.todo.customer.Customer;
import com.todo.todo.orders.Orders;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface Dao {

    public List<Book> selectAll(Connection conn) throws SQLException;

    public Book selectBy(Connection conn, int bookId) throws SQLException;

    public int updateBook(Connection conn, Book book) throws SQLException;

    public List<Customer> custSelectAll(Connection conn) throws SQLException;

    public int ordersInsert(Connection conn, Orders ord) throws SQLException;

}
