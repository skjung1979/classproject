package com.first.app.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ListItemDTO {

    // 조인의 결과를 담는 DTO
    private Integer empno;
    private String ename;
    private String mgr;
    private String dname;
    private String loc;

}
