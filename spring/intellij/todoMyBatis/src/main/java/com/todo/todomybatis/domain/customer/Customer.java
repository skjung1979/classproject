package com.todo.todomybatis.domain.customer;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Customer {

/*    custid	int	NO	PRI
    name	varchar(40)	YES
    address	varchar(50)	YES
    phone	varchar(20)	YES*/

    private int custid;
    private String name;
    private String address;
    private String phone;

}
