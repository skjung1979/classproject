package com.todo.todospring.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class TodoDTO {

    private long tno;
    private String todo;
    private String dueDate;
    private boolean finished;

}
