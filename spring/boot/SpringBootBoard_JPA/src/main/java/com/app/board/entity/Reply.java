package com.app.board.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_reply")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Reply {

//    rno	int
//    bno	int
//    reply	varchar(1000)
//    replyer	varchar(50)
//    replyDate	date
//    updateDate	date

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rno;
    @Column
    private Integer bno;
    @Column
    private String reply;
    @Column
    private String replyer;
    @Column(insertable = false)
    private LocalDate replydate;
    @Column(insertable = false)
    private LocalDate updatedate;

}
