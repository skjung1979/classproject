package com.todo.todo.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class TodoDTO {

    private long tno;
    private String todo;
    private String memo; // 상세설명
    private String dueDate; // 마감일자
    private boolean finished;

}
