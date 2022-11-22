package com.todo.todo.book;

import com.todo.todo.customer.Customer;
import com.todo.todo.orders.Orders;
import lombok.Cleanup;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDao implements Dao {
    public List<Book> selectAll(Connection conn) throws SQLException {

        String sql = "select * from book";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        List<Book> list = new ArrayList<>();

        while (rs.next()){

            list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));

        }
        return list;
    }

    public Book selectBy(Connection conn, int bookId) throws SQLException {

        String sql = "select * from book where bookid=?";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, bookId);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        Book book = null;

        if (rs.next()){
            book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
        }

        return book;
    }

    public int updateBook(Connection conn, Book book) throws SQLException {

        int result = 0;

        String sql = "update book set bookname=?, publisher=?, price=? where bookid=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, book.getBookName());
        pstmt.setString(2, book.getPublisher());
        pstmt.setInt(3, book.getPrice());
        pstmt.setInt(4, book.getBookId());

        result = pstmt.executeUpdate();

        return result;
    }

    public List<Customer> custSelectAll(Connection conn) throws SQLException {

        List<Customer> list = new ArrayList<>();
        String sql = "select * from customer";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        while (rs.next()){

            list.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        return list;
    }

    public int ordersInsert(Connection conn, Orders ord) throws SQLException {

        System.out.println("BookDao에서 ord.getSaleprice "+ ord.getSaleprice());

        int result = 0;
        String sql = "insert into orders (custid, bookid, saleprice, orderdate) values (?, ?, ?, ?)";
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,ord.getCustid());
        pstmt.setInt(2,ord.getBookid());
        pstmt.setInt(3, ord.getSaleprice());
        pstmt.setString(4,ord.getOrderdate());

        result = pstmt.executeUpdate();

        return result;
    }
}
