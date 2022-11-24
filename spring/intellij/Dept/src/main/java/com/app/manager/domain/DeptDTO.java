package com.app.manager.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DeptDTO {

    private int deptno;
    private String dname;
    private String loc;

}
