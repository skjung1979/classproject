package com.jpa.board.service.board;

import com.jpa.board.domain.BoardWriteRequest;
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
public class BoardWriteService {

    @Autowired
    private BoardRepository boardRepository;

    public int writeBoard(BoardWriteRequest boardWriteRequest) {

        MultipartFile file = boardWriteRequest.getBphoto();

        File saveDir = null;
        String newFileName = null;

        if (file != null && !file.isEmpty() && file.getSize() > 0) {

            String absolutePath = new File("").getAbsolutePath();
            log.info(absolutePath);

            String path = "bphoto";
            saveDir = new File(absolutePath, path);

            if (!saveDir.exists()) {
                saveDir.mkdir();
                log.info(">>>>>>>>>>>>>> bphoto dir 생성!!!");
            }

            String nano = String.valueOf(System.nanoTime());
            newFileName = nano + "_" + file.getOriginalFilename();
            File newFile = new File(saveDir, newFileName);

            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Board board = boardWriteRequest.toBoard();

        if (newFileName != null) {
            board.setBphoto(newFileName);
            board.setRegdate(LocalDate.now());
        }

        int result = 0;

        try {

            result = boardRepository.save(board) != null ? 1 : 0;

        } catch (Exception e) {

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
