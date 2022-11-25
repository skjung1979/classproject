package com.todo.todo.service.orders;

import com.todo.todo.Dao.orders.OrdersDao;
import com.todo.todo.domain.orders.Orders;
import com.todo.todo.util.ConnectionUtil;
import lombok.Cleanup;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {

    private final OrdersDao ordersDao;

    public OrdersService(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    public List<Orders> ordersSelectAll() throws Exception {

        List<Orders> list =  new ArrayList<>();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        list = ordersDao.ordersSelectAll(conn);

        return list;
    }

    public List<Orders> ordersSelectBy(int custid) throws Exception {

        List<Orders> list = new ArrayList<>();

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        list = ordersDao.ordersSelectBy(conn, custid);

        return list;
    }
}
