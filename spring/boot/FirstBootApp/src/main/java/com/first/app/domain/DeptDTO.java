package com.first.app.domain;

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
// validation annotation
// @Future : 현재 시간보다 미래이어야 한다. ex) ToDo리스트 입력 시 날짜 항목에서 현재 보다 미래이어야 하는 경우
// @Email : 이메일 체크, @부분 외에 전체 형식 체킹
// @NotBlank : null이 아닌 상태에서, 공백 문자열 체크 " " 이것은 허용 안됨!
// @NotNull: null값이 아니어야 한다
