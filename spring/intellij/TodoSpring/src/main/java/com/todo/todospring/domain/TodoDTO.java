package com.todo.todospring.domain;

import lombok.*;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class TodoDTO {

    private long tno;
    @NotEmpty(message = "필수 입력 항목")
    private String todo;
    @FutureOrPresent
    private LocalDate duedates;
    private boolean finished;

}
