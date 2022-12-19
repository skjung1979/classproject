package com.app.board.service.board;

import com.app.board.domain.BoardDTO;
import com.app.board.domain.BoardEditRequest;
import com.app.board.entity.Board;
import com.app.board.mapper.BoardMapper;
import com.app.board.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Log4j2
public class BoardEditService {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private BoardRepository boardRepository;

    public int edit(BoardEditRequest boardEditRequest){

        MultipartFile file = boardEditRequest.getFormFile();

        File saveDir = null;
        String newFileName = null;

        if (file != null && !file.isEmpty()){
            // 새로운 파일 저장

            String absolutePath = new File("").getAbsolutePath();
            log.info("absolutPath............ => " + absolutePath);

            // 만들고자하는 새로운 경로 photo 객체 선언했다.
            String path = "photo";
            saveDir = new File(absolutePath, path);

            // photo폴더가 존재하지 않으면 생성
            if (!saveDir.exists()){
                saveDir.mkdir();
                log.info("photo 디렉토리 생성 완료!");
            }

            String uuid = UUID.randomUUID().toString();
            newFileName = uuid + "_" + file.getOriginalFilename();

            // 새로운 저장 파일의 경로 저장경로(saveDir)에 실제 파일이름이 들어간 경로
            File newFile = new File(saveDir, newFileName);

            // 파일 저장
            try {
                file.transferTo(newFile);
                log.info("newFileName........ => " + newFileName);
            } catch (IOException e) {
                log.info("IOException.............");
                throw new RuntimeException(e);
            }
            ////////////////////////
        }

        // 이제 DB에 파일명을 저장해야 한다.
        
        //BoardDTO boardDTO = boardEditRequest.toBoardDTO();
        Board board = boardEditRequest.toBoardEntity();

        if (newFileName != null){
            //boardDTO.setPhoto(newFileName);
            board.setPhoto(newFileName);
        } else {
            board.setPhoto(null);
        }

        log.info(board);

        int result = 0;

        try {
            // db 업데이트
            // 수정시간 설정
            board.setUpdatedate(LocalDate.now());

            //result = boardMapper.update(boardDTO);
            boardRepository.save(board);

            // (db 업데이트 완료되면 아래 로직 실행됨. 실패하면 catch구문으로 이동) 새로운 파일이 저장 되고, 이전 파일이 존재한다면, 이전 파일을 삭제
            String oldFileName = boardEditRequest.getOldFile();
            if (newFileName != null && oldFileName != null && !oldFileName.trim().isEmpty()){
                File delOldFile = new File(saveDir, oldFileName);
                if (delOldFile.exists()){
                    delOldFile.delete();
                }

            }

        } catch (Exception e) {
            log.info("SQLException ..... ");
            //새롭게 저장되면 기존 파일 삭제
            if (newFileName != null){
                File delFile = new File(saveDir, newFileName);
                if (delFile.exists()){
                    // 존재하면 삭제
                    delFile.delete();
                }
            }
        }

        return result;
    }
}
