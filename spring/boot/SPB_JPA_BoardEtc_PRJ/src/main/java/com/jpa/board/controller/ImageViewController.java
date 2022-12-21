package com.jpa.board.controller;

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

    @GetMapping(value = "/upload/{dirName}/{fileName}", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public ResponseEntity<byte[]> viewImage(
            @PathVariable("dirName") String dirName,
            @PathVariable("fileName") String fileName
    ) throws IOException {

        byte[] imageByteArray = null;
        HttpStatus status = HttpStatus.NOT_FOUND;

        // 파일 찾기
        File saveFile = new File(new File("").getAbsolutePath(), dirName + "\\" + fileName);

        if (saveFile.exists()){
            @Cleanup InputStream is = new FileInputStream(saveFile);
            imageByteArray = is.readAllBytes();
            status = HttpStatus.OK;
        }

        return new ResponseEntity<byte[]>(imageByteArray, status);
    }
}
