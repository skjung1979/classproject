package com.app.board.repository;

import com.app.board.entity.BoardMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardMemberRepository extends JpaRepository<BoardMember, Integer> {
    Optional<BoardMember> findByUserid(String userid);



}

