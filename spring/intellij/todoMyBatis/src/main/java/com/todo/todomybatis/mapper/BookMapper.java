package com.todo.todomybatis.mapper;

import com.todo.todomybatis.domain.book.Book;
import com.todo.todomybatis.domain.customer.Customer;
import com.todo.todomybatis.domain.orders.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@Mapper
public interface BookMapper {

    @Sql("select * from book")
    List<Book> selectAll();

    @Sql("select * from customer")
    List<Customer> custSelectAll();

    Book selectBy(int bookId);

    int updateBook(Book book);

    int ordersInsert(Orders ord);
}