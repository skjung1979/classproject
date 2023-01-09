package com.jpa.board.entity.board;

import com.jpa.board.entity.member.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "t_board")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long bidx;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "writer", nullable = false)
    private Member writer;

    @Column
    private Long rcnt;

    @Column
    private Long rpcnt;

    @Column
    private String bphoto;

    @Column(updatable = false)
    private LocalDate regdate;

    @Column(insertable = false)
    private LocalDate updatedate;

}
