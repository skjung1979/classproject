package com.todo.todo.orders;

import com.todo.todo.util.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class OrdersService {

    OrdersDao dao = new OrdersDao();
    public List<Orders> ordersSelectAll() throws Exception {

        List<Orders> list =  new ArrayList<>();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        list = dao.ordersSelectAll(conn);

        return list;
    }

    public List<Orders> ordersSelectBy(int custid) throws Exception {

        List<Orders> list = new ArrayList<>();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        list = dao.ordersSelectBy(conn, custid);

        return list;
    }
}
