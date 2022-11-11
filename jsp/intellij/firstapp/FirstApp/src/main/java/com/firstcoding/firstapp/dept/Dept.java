package com.firstcoding.firstapp.dept;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder

public class Dept {

    private int deptno;
    private String dname;
    private String loc;

    // 럼벅을 사용하면 게터/세터 자동 생성 가능!




}
