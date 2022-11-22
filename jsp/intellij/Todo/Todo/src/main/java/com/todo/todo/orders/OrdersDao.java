package com.todo.todo.orders;

import lombok.Cleanup;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrdersDao implements Dao{
    public List<Orders> ordersSelectAll(Connection conn) throws SQLException {

        List<Orders> list = new ArrayList<>();

        String sql = "select a.orderid, a.custid, c.name, a.bookid, b.bookname, b.price, a.saleprice, a.orderdate  from orders a, book b, customer c where a.bookid=b.bookid and a.custid=c.custid";

        String sql2= "select a.orderid, a.custid, c.name, a.bookid, b.bookname, b.price, a.saleprice, a.orderdate, d.hap from \n" +
                "orders a, \n" +
                "book b, \n" +
                "customer c, \n" +
                "(select a.custid custid, sum(saleprice) hap from orders a, book b, customer c where a.bookid=b.bookid and a.custid=c.custid group by a.custid) d \n" +
                "where a.bookid=b.bookid and a.custid=c.custid and a.custid=d.custid";

        String sql3 = "select a.orderid, a.custid, c.name, a.bookid, b.bookname, b.price, a.saleprice, a.orderdate, d.hap, e.total\n" +
                "from orders a, book b, customer c, \n" +
                "(select a.custid as custid, sum(saleprice) as hap from orders a, book b, customer c where a.bookid=b.bookid and a.custid=c.custid group by a.custid) d,\n" +
                "(select sum(saleprice) as total from orders) e \n" +
                "where a.bookid=b.bookid and a.custid=c.custid and a.custid=d.custid order by a.orderid";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql3);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        while (rs.next()){

            Orders ord = new Orders();
            ord.setOrderid(rs.getInt(1));
            ord.setCustid(rs.getInt(2));
            ord.setCustnm(rs.getString(3));
            ord.setBookid(rs.getInt(4));
            ord.setBooknm(rs.getString(5));
            ord.setPrice(rs.getInt(6));
            ord.setSaleprice(rs.getInt(7));
            ord.setOrderdate(rs.getString(8));
            ord.setSumprice(rs.getString(9));
            ord.setTotal(rs.getString(10));

            list.add(ord);

/*            list.add(new Orders(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));*/
        }
        return list;
    }

    public List<Orders> ordersSelectBy(Connection conn, int custid) throws SQLException {

        List<Orders> list = new ArrayList<>();
        String sql = "select a.orderid, a.custid, c.name, a.bookid, b.bookname, b.price, a.saleprice, a.orderdate  from orders a, book b, customer c where a.bookid=b.bookid and a.custid=c.custid and c.custid=?";

        String sql2= "select a.orderid, a.custid, c.name, a.bookid, b.bookname, b.price, a.saleprice, a.orderdate, d.hap from \n" +
                "orders a, \n" +
                "book b, \n" +
                "customer c, \n" +
                "(select a.custid custid, sum(saleprice) hap  from orders a, book b, customer c where a.bookid=b.bookid and a.custid=c.custid group by a.custid) d \n" +
                "where a.bookid=b.bookid and a.custid=c.custid and a.custid=d.custid and a.custid=?";

        String sql3 = "select a.orderid, a.custid, c.name, a.bookid, b.bookname, b.price, a.saleprice, a.orderdate, d.hap, e.total\n" +
                "from orders a, book b, customer c, \n" +
                "(select a.custid as custid, sum(saleprice) as hap from orders a, book b, customer c where a.bookid=b.bookid and a.custid=c.custid group by a.custid) d,\n" +
                "(select sum(saleprice) as total from orders) e \n" +
                "where a.bookid=b.bookid and a.custid=c.custid and a.custid=d.custid and a.custid=? order by a.orderid ";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql3);
        pstmt.setInt(1, custid);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        while (rs.next()){

            Orders ord = new Orders();
            ord.setOrderid(rs.getInt(1));
            ord.setCustid(rs.getInt(2));
            ord.setCustnm(rs.getString(3));
            ord.setBookid(rs.getInt(4));
            ord.setBooknm(rs.getString(5));
            ord.setPrice(rs.getInt(6));
            ord.setSaleprice(rs.getInt(7));
            ord.setOrderdate(rs.getString(8));
            ord.setSumprice(rs.getString(9));

            list.add(ord);

            System.out.println(ord);

/*            list.add(new Orders(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getInt(9)));*/

        }


        return list;
    }
}
