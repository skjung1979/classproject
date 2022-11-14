package com.todo.todo.book;

import com.todo.todo.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
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
}
