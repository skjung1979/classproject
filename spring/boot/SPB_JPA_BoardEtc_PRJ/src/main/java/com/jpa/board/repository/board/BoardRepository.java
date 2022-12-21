package com.jpa.board.repository.board;

import com.jpa.board.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BoardRepository extends JpaRepository<Board, Long> {


    // 이하 4개 로직은 별도 생성할 필요 없이 service단에서 호출하면 자동 반환값을 준다.
    // 리스트 페이지 : findAll()
    // 뷰 페이지 : findById()
    // 수정  :   save()
    // 입력  :  save()

    //삭제는 별도 메소드를 생성해야 함!!!
    // 삭제  : 별도 메소드 생성 => int, @Transactional 반드시 추가

    @Transactional
    @Modifying // inser, update, delete
    @Query("delete from Board b where b.bidx = :bidx")
    int deleteByBidx(Long bidx);






}
