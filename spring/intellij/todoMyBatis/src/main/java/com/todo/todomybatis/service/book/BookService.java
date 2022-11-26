package com.todo.todomybatis.service.book;

import com.todo.todomybatis.domain.book.Book;
import com.todo.todomybatis.domain.customer.Customer;
import com.todo.todomybatis.domain.orders.Orders;
import com.todo.todomybatis.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

//    private final BookDao bookDao;
//    public BookService(BookDao bookDao) {
//        this.bookDao = bookDao;
//    }

    @Autowired
    private BookMapper bookMapper;

    public List<Book> selectAll() throws Exception {

        List<Book> list = new ArrayList<>();

//        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return bookMapper.selectAll();
    }

    public Book selectBy(int bookId) throws Exception {

        Book result = new Book();

//        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return bookMapper.selectBy(bookId);
    }

    public int updateBook(Book book) throws Exception {

        int result = 0;

//        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return bookMapper.updateBook(book);
    }

    public List<Customer> custSelectAll() throws Exception {

        List<Customer> clist = new ArrayList<>();

//        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return bookMapper.custSelectAll();
    }

    public int ordersInsert(Orders ord) throws Exception {

        int result = 0;

//        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        System.out.println("BookService에서 ord.getSaleprice : " + ord.getSaleprice());

        return bookMapper.ordersInsert(ord);
    }
}
