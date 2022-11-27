package com.todo.todomybatis.domain.todo;

import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class TodoDTO {

    private long tno;
    @NotEmpty(message="빈값이면 안됩니다.")
    private String todo;
    private String memo; // 상세설명
    @FutureOrPresent(message = "마감일은 오늘부터 미래 날짜로 입력해주세요.")
    private LocalDate dueDates; // 마감일자
    private boolean finished;

}
