package com.firstcoding.mvc.springmvc.controller;

import com.firstcoding.mvc.springmvc.domain.Report;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

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

    @PostMapping("/submit3") // // 3. 커맨드 객체로 받는 경우 / 리포트 제출
    public String result2(
            Report report,
            HttpServletRequest request,
            Model model
    ) throws IOException {

        log.info("snum => " + report.getSnum());
        log.info("snanme => " + report.getSname());
        log.info("리포트 파일 => " + report.getReport().getOriginalFilename());
        
        // web 경로: 파일 업로드 경로를 변수에 담는다. /webapp 밑에 uploadfile 밑에 report 폴더를 생성함
        String uploadURI = "/uploadfile/report"; // http://localhost:8080/uploadfile/report

        // 시스템 경로를 찾아서 변수에 넣는다.
        String dirRealPath = request.getSession().getServletContext().getRealPath(uploadURI); // 변수uploadURI에 담긴 web경로의 실제 경로를 받아온다.

        // 파일 저장
        report.getReport().transferTo(new File(dirRealPath, report.getReport().getOriginalFilename())); // (부모 폴더위치, 자식 파일명)

        // 처리 결과를 뿌려주는 화면(report/submit2)에 전달할 내용들이다!
        model.addAttribute("snum", report.getSnum());
        model.addAttribute("sname", report.getSname());
        model.addAttribute("fileName", report.getReport().getOriginalFilename());

        log.info("dirRealpath => " + dirRealPath);

        return "report/submit3";
    }

    @PostMapping("/submit2") // // 2. MultipartHttpServletRequest로 받는 경우 / 리포트 제출
    public String result2(
            MultipartHttpServletRequest request,
            Model model // 데이터 공유
    ) throws IOException {

        String snum = request.getParameter("snum");
        String sname = request.getParameter("sname");
        MultipartFile report = request.getFile("report");

        log.info("snum => " + snum);
        log.info("snanme => " + sname);
        log.info("리포트 파일 => " + report.getOriginalFilename());

        // web 경로: 파일 업로드 경로를 변수에 담는다. /webapp 밑에 uploadfile 밑에 report 폴더를 생성함
        String uploadURI = "/uploadfile/report"; // http://localhost:8080/uploadfile/report

        // 시스템 경로를 찾아서 변수에 넣는다.
        String dirRealPath = request.getSession().getServletContext().getRealPath(uploadURI); // 변수uploadURI에 담긴 web경로의 실제 경로를 받아온다.

        // 파일 저장
        report.transferTo(new File(dirRealPath, report.getOriginalFilename())); // (부모 폴더위치, 자식 파일명)

        // 처리 결과를 뿌려주는 화면(report/submit2)에 전달할 내용들이다!
        model.addAttribute("snum", snum);
        model.addAttribute("sname", sname);
        model.addAttribute("fileName", report.getOriginalFilename());

        log.info("dirRealpath => " + dirRealPath);

        return "report/submit2";
    }

    @PostMapping("/submit") // 1. @RequestParam로 받는 경우 / 리포트 제출
    public String result1(
            @RequestParam("snum") String snum,
            @RequestParam("sname") String sname,
            @RequestParam("report") MultipartFile report, // 파일 타입의 객체 가져올 때
            HttpServletRequest request,
            Model model // 데이터 공유
    ) throws IOException {

        log.info("snum => " + snum);
        log.info("snanme => " + sname);
        log.info("리포트 파일 => " + report.getOriginalFilename());

        // web 경로: 파일 업로드 경로를 변수에 담는다. /webapp 밑에 uploadfile 밑에 report 폴더를 생성함
        String uploadURI = "/uploadfile/report"; // http://localhost:8080/uploadfile/report

        // 시스템 경로를 찾아서 변수에 넣는다.
        String dirRealPath = request.getSession().getServletContext().getRealPath(uploadURI); // 변수uploadURI에 담긴 web경로의 실제 경로를 받아온다.

        // 파일 저장
        report.transferTo(new File(dirRealPath, report.getOriginalFilename())); // (부모 폴더위치, 자식 파일명)

        // 처리 결과를 뿌려주는 화면(report/submit1)에 전달할 내용들이다!
        model.addAttribute("snum", snum);
        model.addAttribute("sname", sname);
        model.addAttribute("fileName", report.getOriginalFilename());


        log.info("dirRealpath => " + dirRealPath);

        return "report/submit1";
    }

}
