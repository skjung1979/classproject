package com.todo.todomybatis.mapper;

import com.todo.todomybatis.domain.book.Book;
import com.todo.todomybatis.domain.book.BookSearchOption;
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

    // 검색 타입과 키워드를 받아서 검색 결과를 반환
    List<Book> selectBookSearchOption(BookSearchOption bookSearchOption);

    // 여러개 선택해서 조회 진행 예정
    List<Book> selectBybookids(List<Integer> bookids);
}
