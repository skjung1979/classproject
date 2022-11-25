package com.app.manager.domain.emp;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmpSearchOption {

    private String searchType;
    private String keyword;

}
