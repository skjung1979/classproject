package com.jpa.board.entity.reply;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jpa.board.entity.member.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_reply")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
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

    @JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
    @Column(updatable = false)
    private LocalDateTime regdate;

    @JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
    @Column(insertable = false)
    private LocalDateTime updatedate;
}
