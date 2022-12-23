package com.jpa.board.repository;

import com.jpa.board.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member m where m.memid = ?1 and m.password = ?2")
    Optional<Member> findByMemid(String memid, String password);

    @Query("select m from Member m where m.memid = :memid")
    Optional<Member> findByMemberId(@Param("memid") String memid);


}
