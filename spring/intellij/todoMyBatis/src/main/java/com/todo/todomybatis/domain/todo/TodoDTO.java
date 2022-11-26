package com.todo.todomybatis.domain.todo;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class TodoDTO {

    private long tno;
    @NotNull
    @NotBlank
    @NotEmpty
    private String todo;
    private String memo; // 상세설명
    @Future
    private LocalDate dueDate; // 마감일자
    private boolean finished;

}
