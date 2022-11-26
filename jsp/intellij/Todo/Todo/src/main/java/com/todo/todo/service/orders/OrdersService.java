package com.todo.todo.service.orders;

import com.todo.todo.Dao.orders.OrdersDao;
import com.todo.todo.domain.orders.Orders;
import com.todo.todo.mapper.OrdersMapper;
import com.todo.todo.util.ConnectionUtil;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    public List<Orders> ordersSelectAll() throws Exception {

        return ordersMapper.ordersSelectAll();
    }

    public List<Orders> ordersSelectBy(int custid) throws Exception {

        return ordersMapper.ordersSelectBy(custid);
    }
}
