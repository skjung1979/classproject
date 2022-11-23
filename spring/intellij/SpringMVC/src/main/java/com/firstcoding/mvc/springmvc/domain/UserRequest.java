package com.firstcoding.mvc.springmvc.domain;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserRequest {

    private LocalDate date;

    // 세터는 롬복으로 자동생성하지 않고 아래와 같이 메소드 선언함. 형변환을 위해서. => 이런 불편함을 해소하기 위해 formatter를 사용함
//    public void setDate(String date){
//        this.date = LocalDate.parse(date);
//    }

}
