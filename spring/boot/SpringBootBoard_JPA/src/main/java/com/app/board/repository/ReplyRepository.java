package com.app.board.repository;

import com.app.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    // 전체 리스트 : findAll
    // 입력 : save
    // 수정 : save

    // 삭제 : delete
    @Transactional
    @Modifying
    @Query("delete from Reply r where r.rno = :rno")
    int deleteByRno(Integer rno);

    @Query("select r from Reply r where r.bno = :bno order by r.rno")
    List<Reply> findByBno(@Param("bno") Integer bno);

    // 게시글 삭제시 모든 댓글이 삭제 되어야 게시글이 삭제 가능함! 왜냐? 외래키 설정 때문에

    // 해당 게시글의 모든 댓글을 삭제하는 메소드
    @Transactional
    @Modifying // ==> DML을 의미한다.
    @Query("delete from Reply r where r.bno = ?1")
    int deleteByBno(Integer bno);










}
