package com.firstcoding.mvc.springmvc.controller;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Log4j2
@RequestMapping("/report")
public class FileUploadController {
    // 컨셉: 리포트 파일을 올리는 것!

    @GetMapping
    public String getReportForm(){ // 리포트폼: 데이터 입력받기

        return "/report/reportForm";
    }

    // 1. @RequestParam
    // 2. MultipartHttpServletRequest
    // 3. 커맨드 객체

    @PostMapping("/submit1") // 리포트 제출
    public String result1(
            @RequestParam("snum") String snum,
            @RequestParam("sname") String sname,
            @RequestParam("report") MultipartFile report, // 파일 타입의 객체 가져올 때
            HttpServletRequest request
    ){

        log.info("snum => " + snum);
        log.info("snanme => " + sname);
        log.info("리포트 파일 => " + report.getOriginalFilename());
        
        // web 경로: 파일 업로드 경로를 변수에 담는다. /webapp 밑에 uploadfile 밑에 report 폴더를 생성함
        String uploadURI = "/uploadfile/report"; // http://localhost:8080/uploadfile/report

        // 시스템 경로를 찾아서 변수에 넣는다.
        String dirRealPath = request.getSession().getServletContext().getRealPath(uploadURI); // 변수uploadURI에 담긴 web경로의 실제 경로를 받아온다.

        log.info("dirRealpath => " + dirRealPath);

        return "report/submit1";
    }

}
