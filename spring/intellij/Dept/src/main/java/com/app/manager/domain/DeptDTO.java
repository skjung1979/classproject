package com.app.manager.domain;

import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DeptDTO {

    @Min(value = 1) // 숫자의 경우 최소값, 최대값 정의 가능!
    @Max(value = 99)
    @Positive // 양수값만 들어오도록 or @Negative // 음수값만 들어오도록
    private int deptno;

    @NotEmpty // 문자열이 비어있지 않은지 상태 확인, List의 경우 요소의 개수가 비어 있는지 체킹
    private String dname;

    @NotEmpty
    private String loc;
}
// validation annotation
// @Future : 현재 시간보다 미래이어야 한다. ex) ToDo리스트 입력 시 날짜 항목에서 현재 보다 미래이어야 하는 경우
// @Email : 이메일 체크, @부분 외에 전체 형식 체킹
// @NotBlank : null이 아닌 상태에서, 공백 문자열 체크 " " 이것은 허용 안됨!
// @NotNull: null값이 아니어야 한다
