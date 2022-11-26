package com.todo.todomybatis.domain.book;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Book {

/*    bookid	int	NO	PRI
    bookname	varchar(40)	YES
    publisher	varchar(40)	YES
    price	int	YES*/

    private int bookid;
    private String bookname;
    private String publisher;
    private int price;

}
