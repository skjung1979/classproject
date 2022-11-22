package com.todo.todo.book;

import com.todo.todo.customer.Customer;
import com.todo.todo.orders.Orders;
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

    public List<Customer> custSelectAll() throws Exception {

        List<Customer> clist = new ArrayList<>();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        clist = dao.custSelectAll(conn);

        return clist;
    }

    public int ordersInsert(Orders ord) throws Exception {

        int result = 0;

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        System.out.println("BookService에서 ord.getSaleprice : " + ord.getSaleprice());

        result = dao.ordersInsert(conn, ord);

        return result;
    }
}
