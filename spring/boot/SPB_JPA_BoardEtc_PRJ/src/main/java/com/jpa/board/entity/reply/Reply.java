package com.jpa.board.entity.reply;

import com.jpa.board.entity.member.Member;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_reply")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long ridx;

    @Column
    private Long bidx;

    @Column
    private String reply;

    @ManyToOne
    @JoinColumn(name = "replyer")
    private Member replyer;

    @Column(updatable = false)
    private LocalDateTime regdate;

    @Column(insertable = false)
    private LocalDateTime updatedate;
}
