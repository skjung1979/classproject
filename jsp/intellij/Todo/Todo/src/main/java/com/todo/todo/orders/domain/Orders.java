package com.todo.todo.orders.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Orders {

/*    orderid	int	NO	PRI
    custid	int	YES	MUL
    bookid	int	YES	MUL
    saleprice	int	YES
    orderdate	date	YES*/

    private int orderid;
    private int custid;
    private String custnm;
    private int bookid;
    private String booknm;
    private int price;
    private int saleprice;
    private String orderdate;
    private String sumprice;
    private String total;





}
