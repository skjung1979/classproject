package com.app.springsecurity.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity // 스키마에 해당 테이블이 없다면 엔티티의 설정대로 테이블이 자동으로 생성된다.
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Member {

    @Id
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @ElementCollection(fetch = FetchType.EAGER) // 엔티티를 구성하지 않아도 엔티티처럼 사용 가능하다. / fetchType.lazy는 천천히 마지막 순간에 실행하라.
    private Set<MemberRole> roleSet;

    public void addMemberRole(MemberRole role){
        roleSet.add(role);
    }
}
