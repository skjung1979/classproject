package com.todo.todo.dept.domain;

import lombok.*;

// 롬복을 통해 생성자, 게터/세터 등을 간단히 만들 수 있다.
@AllArgsConstructor // 모든 매개 변수를 포함한 생성자
@NoArgsConstructor // 기본 생성자
@Getter
@Setter
@ToString
@Builder

public class Dept {

    private int deptno;
    private String dname;
    private String loc;


}
