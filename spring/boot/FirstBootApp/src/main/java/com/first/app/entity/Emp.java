package com.first.app.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "emp")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Emp {

    @Id // 필수 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empno;

    @Column
    private String ename;
    @Column
    private String job;
    @Column
    private Integer mgr; // 상사의 사원번호 wrapper 클래스로 선언하면 null인 경우 0으로 들어온다.
    @Column
    private LocalDate hiredate;
    @Column
    private Double sal;
    @Column
    private Double comm;
//    @Column
//    private Integer deptno;

    @JoinColumn(name = "deptno") // 다른 테이블과 조인할때 사용되므로!
    @ManyToOne // 외래키는 이렇게 설정한다.
    private Dept dept; // 데이터 타입은 Dept엔티티이어야 한다.




}
