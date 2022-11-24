package com.app.manager.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmpDTO {

//    empno	int	NO	PRI
//    ename	varchar(20)	YES
//    job	varchar(20)	YES
//    mgr	smallint	YES
//    hiredate	date	YES
//    sal	decimal(7,2)	YES
//    comm	decimal(7,2)	YES
//    deptno	int	YES	MUL

    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private String hiredate;
    private int sal;
    private int comm;
    private int deptno;


}
