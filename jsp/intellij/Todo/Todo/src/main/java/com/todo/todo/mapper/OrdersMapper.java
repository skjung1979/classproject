package com.todo.todo.mapper;

import com.todo.todo.domain.orders.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@Mapper
public interface OrdersMapper {

    @Sql("select a.orderid, a.custid, c.name, a.bookid, b.bookname, b.price, a.saleprice, a.orderdate, d.hap, e.total\n" +
            "from orders a, book b, customer c, \n" +
            "(select a.custid as custid, sum(saleprice) as hap from orders a, book b, customer c where a.bookid=b.bookid and a.custid=c.custid group by a.custid) d,\n" +
            "(select sum(saleprice) as total from orders) e \n" +
            "where a.bookid=b.bookid and a.custid=c.custid and a.custid=d.custid order by a.orderid")
    List<Orders> ordersSelectAll();

    List<Orders> ordersSelectBy(int custid);
}
