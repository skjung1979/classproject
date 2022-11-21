package com.firstcoding.mvc.springmvc.controller;

import com.firstcoding.mvc.springmvc.domain.OrderCommand;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/order/order")
public class OrderController {

    @GetMapping
    public String getOrderForm(){

        return "order/orderForm";
    }

    @PostMapping
    public void order(
            // 별도로 클래스를 만들어서 매개변수를 담는 곳으로 사용한다.
            OrderCommand orderCommand
    ){
        // void이므로 자동으로 /WEB-INV/views/order/order.jsp를 찾는다.

        log.info("orderCommand =>" + orderCommand);

    }



}
