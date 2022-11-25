package com.app.manager.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DeptSearchOption {
    
    private String searchType; // 부서이름 또는 부서위치 => 나중에는 페이징에 관한 변수도 추가한다.
    private String keyword;
}
