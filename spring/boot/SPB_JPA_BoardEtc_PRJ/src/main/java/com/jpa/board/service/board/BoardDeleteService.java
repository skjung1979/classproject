package com.jpa.board.service.board;

import com.jpa.board.entity.board.Board;
import com.jpa.board.repository.board.BoardRepository;
import com.jpa.board.repository.reply.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Log4j2
public class BoardDeleteService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    public int delete(Long bidx) {

        // 삭제 하려는 게시물의 데이터 조회
        Board board = boardRepository.findById(bidx).get();

        // 게시물에 등록된 댓글 삭제
//        replyRepository.deleteByBidx(bidx);


        // 해당 게시물이 DB에서 삭제하고, 해당 게시물의 사진 이름이 있다면 파일을 삭제해야 한다.
        // 게시물 삭제
        int result = boardRepository.deleteByBidx(bidx);

        // 파일 삭제 로직
        if (result>0 && board.getBphoto() != null){

            File delFile = new File(new File("").getAbsolutePath(), "bphoto" + File.separator + board.getBphoto());

            log.info(delFile.getAbsolutePath());

            if (delFile.exists()){
                log.info("파일 존재 시 진입..............");
                if (delFile.delete()){
                    log.info("게시물 파일 삭제 완료!!!");
                }
            }
        }

        return result;
    }
}
