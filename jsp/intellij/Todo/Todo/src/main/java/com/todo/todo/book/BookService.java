package com.todo.todo.book;

import com.todo.todo.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    BookDao dao = new BookDao();
    public List<Book> selectAll() throws Exception {

        List<Book> list = new ArrayList<>();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        list = dao.selectAll(conn);

        return list;
    }

    public Book selectBy(int bookId) throws Exception {

        Book result = new Book();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        result = dao.selectBy(conn, bookId);

        return result;
    }

    public int updateBook(Book book) throws Exception {

        int result = 0;

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        result = dao.updateBook(conn, book);

        return result;
    }
}
