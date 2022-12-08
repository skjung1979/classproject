package com.app.board.service.board;

import com.app.board.domain.BoardDTO;
import com.app.board.domain.BoardWriteRequest;
import com.app.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@Service
@Log4j2
public class BoardWriteService {

    @Autowired
    private BoardMapper boardMapper;

    public int write(BoardWriteRequest boardWriteRequest){

        // 파일 유무 확인, 디렉토리 유무 확인, 저장 확인

        MultipartFile file = boardWriteRequest.getFormFile();

        File saveDir = null;
        String newFileName = null;


        // 파일 유무에 확인을 하고(null이 아니고 비어있지 않고, 사이즈가 0보다 커야) 디렉토리를 만들고 파일을 저장한다.
        if (file != null && !file.isEmpty() && file.getSize()>0){

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
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        BoardDTO boardDTO = boardWriteRequest.toBoardDTO();

        // 문제없이 저장 되었는지 확인하고 되었다면
        if (newFileName != null){
            boardDTO.setPhoto(newFileName);
        }

        try {
            // DB insert
            boardMapper.insert(boardDTO);
        } catch (SQLException e){
            // 오류 나면 파일을 지워줘야 한다.
            if (newFileName != null){
                File delFile = new File(saveDir, newFileName);
                if (delFile.exists()){
                    // 존재하면 삭제
                    delFile.delete();
                }
            }
        }

        return 0;
    }

}
