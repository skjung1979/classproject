package com.todo.todo.domain;

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

    private int custId;
    private String custnm;
    private String address;
    private String phone;

}
