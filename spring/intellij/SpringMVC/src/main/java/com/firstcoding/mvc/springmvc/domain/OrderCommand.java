package com.firstcoding.mvc.springmvc.domain;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderCommand {
    // 해당 클래스는 주문 상품과 배송지 주소 정보를 담고 있다.
    // 이 클래스를 생성하기 전에 OrderItem(상품)와 Address(배송지) 클래스를 먼저 생성한다.

    private List<OrderItem> orderItems;
    private Address address;

}
