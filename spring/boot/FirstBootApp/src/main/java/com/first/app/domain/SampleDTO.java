package com.first.app.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true) // toBuilder = true로 하면 시간이 고정값으로 나온다.
public class SampleDTO {

    private Long sno;
    private String first;
    private String last;
    private LocalDateTime regTime;
}
