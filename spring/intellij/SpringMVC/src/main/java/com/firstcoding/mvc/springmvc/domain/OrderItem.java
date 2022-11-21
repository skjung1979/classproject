package com.firstcoding.mvc.springmvc.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class OrderItem {

    private String itemId;
    private int number;
    private String remark;
}
