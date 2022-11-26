package com.todo.todomybatis.service.book;

import com.todo.todomybatis.domain.book.Book;
import com.todo.todomybatis.domain.book.BookSearchOption;
import com.todo.todomybatis.domain.customer.Customer;
import com.todo.todomybatis.domain.orders.Orders;
import com.todo.todomybatis.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> selectAll() throws Exception {

        List<Book> list = new ArrayList<>();

        return bookMapper.selectAll();
    }

    public Book selectBy(int bookid) throws Exception {

        Book result = new Book();

        return bookMapper.selectBy(bookid);
    }

    public int updateBook(Book book) throws Exception {

        return bookMapper.updateBook(book);
    }

    public List<Customer> custSelectAll() throws Exception {

        return bookMapper.custSelectAll();
    }

    public int ordersInsert(Orders ord) throws Exception {

        System.out.println("BookService에서 ord.getSaleprice : " + ord.getSaleprice());

        return bookMapper.ordersInsert(ord);
    }

    public List<Book> getSearchList(BookSearchOption bookSearchOption) {

        return bookMapper.selectBookSearchOption(bookSearchOption);
    }

    /*아래는 아직 미 구현*/
    public List<Book> getChoiceList(List<Integer> bookids) {

        return bookMapper.selectBybookids(bookids);
    }
}
