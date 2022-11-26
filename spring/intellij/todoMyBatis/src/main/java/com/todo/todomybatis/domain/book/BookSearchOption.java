package com.todo.todomybatis.domain.book;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BookSearchOption {

    private String searchType;
    private String keyword;

}
