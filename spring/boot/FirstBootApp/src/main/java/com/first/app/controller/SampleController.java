package com.first.app.controller;

import com.first.app.domain.SampleDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Log4j2
//@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/ajax/form")
    public void getForm(){ // void이므로 templatge 밑에 ajax 밑에 form 파일이 있어야 함.

    }

    @GetMapping("/parameter")
    @ResponseBody // 응답처리를 문자열로 하겠다는 의미!
    public String getParameter(
            @RequestParam("name") String name,
            @RequestParam("price") String price
            ){

        String result = name + " : " + price;
        log.info("result ==> " + result);

        return result;
    }


    @GetMapping("/sam2")
    public void sam2(Model model){

        log.info("sam2...........................");

        SampleDTO dto = SampleDTO.builder()
                .regTime(LocalDateTime.now())
                .build();

        List<SampleDTO> list = IntStream.rangeClosed(1,20).asLongStream().mapToObj(i -> dto.toBuilder().sno(i).first("first..." + i).last("last..."+i).build()).collect(Collectors.toList());

        log.info(list);

        model.addAttribute("list", list);

    }

    @GetMapping("/samInLine")
    public String samInLine(RedirectAttributes redirectAttributes){

        log.info("samInLine............");

        SampleDTO dto = SampleDTO.builder()
                .sno(100L)
                .first("First...100")
                .last("Last...100")
                .regTime(LocalDateTime.now())
                .build();

        redirectAttributes.addFlashAttribute("result", "success");
        redirectAttributes.addFlashAttribute("dto", dto);

        return "redirect:/sample/sam3";
    }

    @GetMapping("/sam3")
    public void sam3(){

        log.info("sam3.............");

    }


}
