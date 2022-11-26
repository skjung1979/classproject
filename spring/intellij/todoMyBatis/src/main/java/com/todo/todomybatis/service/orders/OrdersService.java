package com.todo.todomybatis.service.orders;

import com.todo.todomybatis.domain.orders.Orders;
import com.todo.todomybatis.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
