package com.todo.todo.service.book;

import com.todo.todo.domain.book.Book;
import com.todo.todo.Dao.book.BookDao;
import com.todo.todo.domain.customer.Customer;
import com.todo.todo.domain.orders.Orders;
import com.todo.todo.util.ConnectionUtil;
import lombok.Cleanup;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> selectAll() throws Exception {

        List<Book> list = new ArrayList<>();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return bookDao.selectAll(conn);
    }

    public Book selectBy(int bookId) throws Exception {

        Book result = new Book();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return bookDao.selectBy(conn, bookId);
    }

    public int updateBook(Book book) throws Exception {

        int result = 0;

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return bookDao.updateBook(conn, book);
    }

    public List<Customer> custSelectAll() throws Exception {

        List<Customer> clist = new ArrayList<>();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();


        return bookDao.custSelectAll(conn);
    }

    public int ordersInsert(Orders ord) throws Exception {

        int result = 0;

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        System.out.println("BookService에서 ord.getSaleprice : " + ord.getSaleprice());

        return bookDao.ordersInsert(conn, ord);
    }
}
