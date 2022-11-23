package com.todo.todo.orders.service;

import com.todo.todo.orders.Dao.Dao;
import com.todo.todo.orders.domain.Orders;
import com.todo.todo.util.ConnectionUtil;
import lombok.Cleanup;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {

    private final Dao dao;

    public OrdersService(Dao dao) {
        this.dao = dao;
    }

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
