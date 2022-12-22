package com.jpa.board.service.board;

import com.jpa.board.domain.BoardEditRequest;
import com.jpa.board.entity.board.Board;
import com.jpa.board.repository.board.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@Service
@Log4j2
public class BoardEditService {

    @Autowired
    private BoardRepository boardRepository;

    public Board boardEditView(Long bidx) {

        return boardRepository.findById(bidx).get();
    }

    public Board boardEdit(BoardEditRequest boardEditRequest) {

        // 첨부 파일 등록 처리

        MultipartFile file = boardEditRequest.getBphoto();

        File saveDir = null;
        String newFileName = null;

        if (file != null && !file.isEmpty()) {
            // 새로운 파일 저장
            String absolutePath = new File("").getAbsolutePath();
            log.info("absolutPath..................... ==> " + absolutePath);

            // 만들고자하는 새로운 경로 bphoto객체 선언
            String path = "bphoto";
            saveDir = new File(absolutePath, path);

            // bphoto폴더가 존재하지 않으면 생성
            if (!saveDir.exists()) {
                saveDir.mkdir();
                log.info("bphoto 디렉토리 생성 완료!");
            } else {
                log.info("bphoto 디렉토리 이미 존재함!!!");
            }

            String nano = String.valueOf(System.nanoTime());
            newFileName = nano + "_" + file.getOriginalFilename();

            // 새로운 파일을 담을 file변수 선언 및 생성
            File newFile = new File(saveDir, newFileName);

            // 파일 저장
            try {
                file.transferTo(newFile);
                log.info("newFile 파일 저장 완료............... ==> " + newFileName);
            } catch (IOException e) {
                log.info("IOException..... newFile 저장 실패!!!");
                throw new RuntimeException(e);
            }
        } else {
            newFileName = boardEditRequest.getOldFile();
        }



        // Board DB업데이트 처리
        Board board = boardEditRequest.toBoard();

//        if (file == null || file.isEmpty() || file.getSize() < 0){
//            board.setBphoto(boardEditRequest.getOldFile());
//        }

        Board result = null;

        if (newFileName != null) {
            board.setBphoto(newFileName);
        } else {
            board.setBphoto(null);
        }
        log.info("board에 파일명 세팅 확인.................. ==> " + board);

        try {

            // 수정 시간 세팅
            board.setUpdatedate(LocalDate.now());

            log.info("최종 board 업데이트 전........................ ==> " + board);

            // 최종 board로 DB업데이트 적용
            result = boardRepository.save(board);

            // DB 업데이트 완료되면 아래 로직 실행, 실패하면 catch 구문으로 이동
            // 새로운 파일이 저장되고, 이전 파일이 존재한다면 이전 파일 삭제
            String oldFileName = boardEditRequest.getOldFile();
            if (newFileName != null && oldFileName != null && !oldFileName.trim().isEmpty()) {
                File delOldFile = new File(saveDir, oldFileName);
                if (delOldFile.exists()) {
                    delOldFile.delete();
                }
            }

        } catch (Exception e) {
            log.info("SQLException 발생............................");
            // SQL 업데이트 문제가 발생했으므로, 새롭게 저장된 파일을 다시 삭제 처리한다.

            if (newFileName != null) {
                File delFile = new File(saveDir, newFileName);

                if (delFile.exists()) {
                    delFile.delete();
                }
            }
        }

        return result;
    }
}
