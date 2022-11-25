package com.todo.todo.domain.book;

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

    private int bookId;
    private String bookName;
    private String publisher;
    private int price;

}
