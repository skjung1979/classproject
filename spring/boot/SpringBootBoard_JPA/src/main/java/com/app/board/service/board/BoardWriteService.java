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
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class BoardWriteService {

    @Autowired
    private BoardMapper boardMapper;

    public int write(BoardWriteRequest boardWriteRequest) {

        // 파일 유무 확인, 디렉토리 유무 확인, 저장 확인

        // 원본 MultipartFile file = boardWriteRequest.getFormFile();
        List<MultipartFile> files = boardWriteRequest.getFormFile(); //////////////////////////////// 여기 변경함

        int result = 0;



        for (MultipartFile file : files) {

            File saveDir = null;
            String newFileName = null;


            // 파일 유무에 확인을 하고(null이 아니고 비어있지 않고, 사이즈가 0보다 커야) 디렉토리를 만들고 파일을 저장한다.
            if (file != null && !file.isEmpty() && file.getSize() > 0) {

                // 프로젝트의 절대 경로를 absolutePath에 담는다. 왜냐하면 이 절대 경로를 기준으로 폴더를 생성하고 파일을 저장해야하기 때문에.
                String absolutePath = new File("").getAbsolutePath();
                log.info("absolutPath............ => " + absolutePath);

                // 만들고자하는 새로운 경로 photo를 담는 path 변수 선언 및 생성
                String path = "photo";
                saveDir = new File(absolutePath, path); // 절대 경로에 photo경로를 추가하여 saveDir 선언, 생성

                // photo폴더 존재 여부 체크 후 존재하지 않으면 생성
                if (!saveDir.exists()) {
                    saveDir.mkdir();
                    log.info("photo 디렉토리 생성 완료!");
                }

                //String uuid = UUID.randomUUID().toString(); // 실제 파일명을 유니크하게 만들기 위해 uuid를 생성해서 파일명에 덧붙인다. 나노초로 만들어도 된다.
                long nano = System.nanoTime();

                newFileName = nano + "_" + file.getOriginalFilename(); // 새롭게 세팅된 파일명으로 DB에 파일명을 저장할 때 사용.

                // 새로운 저장 파일의 경로 저장경로(saveDir)에 실제 파일이름이 들어간 경로
                File newFile = new File(saveDir, newFileName); // 기존 saveDir 경로에 새롭게 세팅된 파일명도 추가하여 newFile객체를 선언, 생성한다.

                // 파일 저장
                try {
                    file.transferTo(newFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            BoardDTO boardDTO = boardWriteRequest.toBoardDTO();

            // 문제없이 저장 되었는지 확인하고 되었다면, boradDTO의 Photo변수에 새로운 파일이름(newFileName)을 세팅한다.
            if (newFileName != null) {
                boardDTO.setPhoto(newFileName);
            }


                // 그렇게 세팅된 최동 boardDTO를 가지고 insert를 진행한다.
                try {
                    // DB insert
                    result = boardMapper.insert(boardDTO);
                } catch (SQLException e) {
                    // 오류 나면 파일을 다시 지워줘야 한다.
                    if (newFileName != null) {
                        File delFile = new File(saveDir, newFileName);
                        if (delFile.exists()) {
                            // 존재하면 삭제
                            delFile.delete();
                        }
                    }
                }

        } //////////////////////////// 반복 종료 / 여기 추가함

        return result;
    }
}
