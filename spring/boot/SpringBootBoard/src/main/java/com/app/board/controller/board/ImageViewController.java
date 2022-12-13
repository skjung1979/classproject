package com.app.board.controller.board;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Controller
@Log4j2
public class ImageViewController {

    //@GetMapping(value = "/upload/photo/{fileName}", produces = MediaType.IMAGE_PNG_VALUE)
    @GetMapping(value = "/upload/{dirName}/{fileName}", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> viewImage(
            @PathVariable("dirName") String dirName, // 추가
            @PathVariable("fileName") String fileName
    ) throws IOException {

        log.info("ImageView Controller......... => ");

        byte[] imageByteArray = null;
        HttpStatus status = HttpStatus.NOT_FOUND;

        // 파일을 찾아야 한다.
        //File saveFile = new File(new File("").getAbsolutePath(), "photo\\" + fileName);
        File saveFile = new File(new File("").getAbsolutePath(), dirName + "\\" + fileName);

        if (saveFile.exists()){
            // 응답처리
            @Cleanup InputStream imageStream = new FileInputStream(saveFile); // close를 해줘야 파일 삭제가 제대로 된다!
            imageByteArray = imageStream.readAllBytes();
            status = HttpStatus.OK;
        }

        return new ResponseEntity<byte[]>(imageByteArray, status);
    }
}
