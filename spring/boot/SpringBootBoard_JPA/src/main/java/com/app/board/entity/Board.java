package com.app.board.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_board")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer bno;

    @Column
    private String title;

    @Column
    private String content;

    @Column(updatable = false)
    private String writer;

    @Column
    private String photo;

    @Column(insertable = false, updatable = false) // 인서트나 업데이트 할때 이 컬럼은 작업을 제외한다.
    private LocalDate regdate;

    @Column(insertable = false)
    private LocalDate updatedate;



}
