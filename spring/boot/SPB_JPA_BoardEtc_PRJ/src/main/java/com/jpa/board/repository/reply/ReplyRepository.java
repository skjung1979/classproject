package com.jpa.board.repository.reply;

import com.jpa.board.entity.reply.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    // 리스트 페이지 : findAll() => 별도 생성할 필요 없이 service단에서 호출하면 자동 반환값을 준다.
    // 뷰 페이지 : findById() => 별도 생성할 필요 없이 service단에서 호출하면 자동 반환값을 준다.
    // 수정  :   save() => 별도 생성할 필요 없이 service단에서 호출하면 자동 반환값을 준다.
    // 입력  :  save() => 별도 생성할 필요 없이 service단에서 호출하면 자동 반환값을 준다.

    // 삭제  : 별도 메소드 생성 => int, @Transactional 반드시 추가
    @Transactional
    @Modifying
    @Query("delete from Reply r where r.bidx = :bidx")
    int deleteByBidx(Long bidx);




}
