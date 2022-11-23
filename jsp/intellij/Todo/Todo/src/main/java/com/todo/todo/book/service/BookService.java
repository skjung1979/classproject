package com.todo.todo.book.service;

import com.todo.todo.book.domain.Book;
import com.todo.todo.book.Dao.Dao;
import com.todo.todo.customer.Customer;
import com.todo.todo.orders.domain.Orders;
import com.todo.todo.util.ConnectionUtil;
import lombok.Cleanup;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final Dao dao;

    public BookService(Dao dao) {
        this.dao = dao;
    }

    public List<Book> selectAll() throws Exception {

        List<Book> list = new ArrayList<>();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.selectAll(conn);
    }

    public Book selectBy(int bookId) throws Exception {

        Book result = new Book();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.selectBy(conn, bookId);
    }

    public int updateBook(Book book) throws Exception {

        int result = 0;

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.updateBook(conn, book);
    }

    public List<Customer> custSelectAll() throws Exception {

        List<Customer> clist = new ArrayList<>();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();


        return dao.custSelectAll(conn);
    }

    public int ordersInsert(Orders ord) throws Exception {

        int result = 0;

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        System.out.println("BookService에서 ord.getSaleprice : " + ord.getSaleprice());

        return dao.ordersInsert(conn, ord);
    }
}
