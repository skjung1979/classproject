package com.jpa.board.entity.member;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_member")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long memcd;

    @Column(nullable = false)
    private String memid;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String memname;

    @Column
    private String mphoto;

    @Column
    private String role;

    @Column
    private LocalDateTime regdate;

    @Column
    private LocalDateTime updatedate;


}
