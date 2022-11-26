package com.todo.todomybatis.mapper;

import com.todo.todomybatis.domain.book.Book;
import com.todo.todomybatis.domain.customer.Customer;
import com.todo.todomybatis.domain.orders.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("select * from book")
    List<Book> selectAll();

    @Select("select * from customer")
    List<Customer> custSelectAll();

    @Select("select * from book where bookid=#{bookid}")
    Book selectBy(int bookid);

    int updateBook(Book book);

    int ordersInsert(Orders ord);
}
