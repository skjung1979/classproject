package com.todo.todomybatis.domain.orders;

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
    private String name;
    private int bookid;
    private String bookname;
    private int price;
    private int saleprice;
    private String orderdate;
    private String hap;
    private String total;





}
