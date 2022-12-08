package com.potato.nedonado.controller.board;

import com.potato.nedonado.model.board.ItemEntity;
import com.potato.nedonado.model.board.ItemViewListInfo;
import com.potato.nedonado.model.user.LoginInfo;
import com.potato.nedonado.service.board.*;
import com.potato.nedonado.service.comment.CommentDeleteService;
import com.potato.nedonado.service.comment.CommentListService;
import com.potato.nedonado.util.CategoryUtil;
import com.potato.nedonado.util.ConfigUtil;
import com.potato.nedonado.util.Util;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/app/v1/item")
public class ItemRestController {

    @Autowired
    private ItemViewService itemViewService;

    @Autowired
    private ItemUpdateService itemUpdateService;

    @Autowired
    private ItemWriteService itemWriteService;

    @Autowired
    private ItemDeleteService itemDeleteService;

    @Autowired
    private ItemListService itemListService;

    @Autowired
    private CommentListService commentListService;

    @Autowired
    private CommentDeleteService commentDeleteService;

    @GetMapping("/list")
    public ModelAndView getBoardList(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("itemList", itemListService.selectBoardListByPage(0));
        mav.setViewName("/board/itemlist");
        return mav;
    }

    public ResponseEntity<List<ItemViewListInfo>> getBoardList(
            @PathVariable("idx") long boardIdx
    ){
        List<ItemViewListInfo> itemList = itemListService.selectBoardListByListIdx(boardIdx);

        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(itemList, httpHeaders, HttpStatus.OK);
    }

    @GetMapping
    public ModelAndView writeItemViewPage(
            HttpServletRequest request
    ){
        ModelAndView mav = new ModelAndView();
        mav.clear();
        mav.addObject("itemCategory", CategoryUtil.categoryNames);
        mav.setViewName("/board/itemwrite");
        return mav;
    }

    @GetMapping("/{idx}")
    public ModelAndView viewItem(
            @PathVariable("idx") long boardIdx,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ModelAndView mav = new ModelAndView();
        mav.clear();
        mav.addObject("item", itemViewService.selectItemByIdx(boardIdx));
        mav.addObject("commentList", commentListService.selectBoardCommentLimit(boardIdx, 0));
        mav.setViewName("/board/itemview");
        return mav;
    }

    @GetMapping("/{idx}/{userIdx}")
    public ModelAndView updateItemPage(
            @PathVariable("idx") long boardIdx,
            @PathVariable("userIdx") long userIdx,
            HttpServletRequest request
    ){
        ModelAndView mav = new ModelAndView();
        mav.clear();

        LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute("loginInfo");
        if (loginInfo == null || userIdx != loginInfo.getUserIdx()){
            mav.setViewName("/login");
            return mav;
        }

        ItemEntity itemEntity = itemViewService.selectItemByIdxAndUserIdx(boardIdx, userIdx);
        if (itemEntity == null){
            mav.setViewName("/login");
            return mav;
        }

        mav.addObject("itemCategory", CategoryUtil.categoryNames);
        mav.addObject("item", itemEntity);
        mav.setViewName("/board/itemUpdate");
        return mav;
    }

    @PostMapping("/{idx}")
    public ResponseEntity<Map<String, String>> updateItem(
            HttpServletRequest request,
            @PathVariable("idx") long boardIdx,
            @RequestBody ItemEntity itemEntity
    ){
        log.info(itemEntity);

        HttpHeaders httpHeaders = new HttpHeaders();
        Map<String, String> result = new HashMap<>();

        if ((itemEntity.getTitle() == null || itemEntity.getTitle().isEmpty()) || (itemEntity.getContent() == null || itemEntity.getContent().isEmpty()) || (itemEntity.getPrice() <= 0)){
            result.put("msg", "입력 데이터를 다시 확인해주세요.");
            return new ResponseEntity<>(result, httpHeaders, HttpStatus.OK);
        }

        LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute("loginInfo");
        if (loginInfo == null){
            result.put("msg", "세션이 만료되었습니다.");
            result.put("url", "/login");
            return new ResponseEntity<>(result, httpHeaders, HttpStatus.OK);
        }
        log.info(loginInfo);

        itemEntity.setUserIdx(loginInfo.getUserIdx());
        log.info(itemEntity);
        int r = itemUpdateService.updateItemByitemEntity(itemEntity);

        result.put("url", "/board/view/"+itemEntity.getBoardIdx());
        return new ResponseEntity<>(result, httpHeaders, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> writeItem(
            HttpServletRequest request,
            @RequestBody ItemEntity itemEntity
    ){
        log.info(itemEntity);

        HttpHeaders httpHeaders = new HttpHeaders();

        if ((itemEntity.getTitle() == null || itemEntity.getTitle().isEmpty()) || (itemEntity.getContent() == null || itemEntity.getContent().isEmpty()) || (itemEntity.getPrice() <= 0)){
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
        }

        LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute("loginInfo");
        if (loginInfo == null){
            return new ResponseEntity<>("/login", httpHeaders, HttpStatus.BAD_REQUEST);
        }
        log.info(loginInfo);

        itemEntity.setUserIdx(loginInfo.getUserIdx());
        itemEntity.setWriteDate(Util.getCurrentTimestamp());

        log.info(itemEntity);
        int result = itemWriteService.writeItem(itemEntity);

        return new ResponseEntity<>("/app/v1/item/list", httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<Map<String, List<String>>> writeItem(
            MultipartHttpServletRequest multipartRequest,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        HttpHeaders httpHeaders = new HttpHeaders();
        Map<String, List<String>> nameList = null;

        try{
            multipartRequest.setCharacterEncoding("utf-8");
            // 파일을 업로드한 후 반환된 파일 이름이 저장되는 fileList를 다시 map에 저장할 것이다.
            nameList = fileProcess(multipartRequest);
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error(e.getStackTrace());
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.EXPECTATION_FAILED);
        }
        httpHeaders.set("some-header", "some-value");
        return new ResponseEntity<>(nameList, httpHeaders, HttpStatus.OK);
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<String> deleteItem(
            @PathVariable("idx") long boardIdx,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute("loginInfo");
        if (loginInfo == null) {
            return new ResponseEntity<>("/login", new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
        int result = itemDeleteService.deleteItemByBoardIdx(boardIdx, loginInfo.getUserIdx());
        String body = "";
        if (result > 0){
            body = "/app/v1/item/list";
            commentDeleteService.deleteCommentByBoardIdx(boardIdx);
        }
        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.OK);
    }

    private Map<String, List<String>> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception{
        String CURR_IMAGE_REPO_PATH = (String) ConfigUtil.getConfig("fileSaveDir");

        List<String> fileList = new ArrayList<String>();
        List<String> thumbnailName = null;

        // 첨부된 파일 이름을 가져올 것이다.
        Iterator<String> fileNames = multipartRequest.getFileNames();
        int count = 0;

        while(fileNames.hasNext()){
            String fileName = fileNames.next();

            log.info(fileName);

            // 파일 이름에 대한 MultipartFile 객체 가져오기
            MultipartFile mFile = multipartRequest.getFile(fileName);
            // 실제 파일 이름 가져오기
            String originalFileName = "T" + Util.getCurrentTimestamp() + "." + mFile.getContentType().split("/")[1];
            // 파일 이름을 하나씩 fileList에 저장하기
            fileList.add(originalFileName);

            File file = new File(CURR_IMAGE_REPO_PATH + "\\" + fileName);

            // 첨부된 파일이 존재하는지 체크
            if (mFile.getSize() != 0){
                // 경로상에 파일이 존재하지 않을 경우
                if ( !file.exists()){
                    // 경로에 해당하는 디렉토리를 만들어라.
                    if (file.getParentFile().mkdirs()){
                        // 그 후에 파일을 생성해라
                        file.createNewFile();
                    }
                }
                // 임시로 저장된 multipartFile을 실제 파일로 저장
                mFile.transferTo(new File(CURR_IMAGE_REPO_PATH + "\\" + originalFileName)); // 임시로 저장된 multipartFile을 실제 파일로 전송
                if (count++ == 0){
                    thumbnailName = thumbnailFile(CURR_IMAGE_REPO_PATH + "\\" + originalFileName);
                }
            }
        }
        // 첨부한 파일 이름이 저장된 fileList 반환해줘라
        Map<String, List<String>> map = new HashMap<>();
        map.put("fileList", fileList);
        map.put("thumbnail", thumbnailName);
        return map;
    }

    private List<String> thumbnailFile(
            String oPath // 원본 패스
    ){
        List<String> list = new ArrayList<>();
        File oFile = new File(oPath);

        int index = oPath.lastIndexOf(".");
        String ext = oPath.substring(index + 1); // 파일 확장자

        String tPath = (String) ConfigUtil.getConfig("fileSaveDir") + "/thumbnail/" + oFile.getName(); // 썸네일 저장 경로
        log.info(tPath);
        File tFile = new File(tPath);

        try{
            BufferedImage oImage = ImageIO.read(oFile); // 원본이미지
            int tWidth = 128; // 생성할 썸네일 이미지의 너비
            int tHeight = 128; // 생성할 썸네일 이미지의 높이

            BufferedImage tImage = new BufferedImage(tWidth, tHeight, BufferedImage.TYPE_3BYTE_BGR); // 썸네일 이미지
            Graphics2D graphic = tImage.createGraphics();
            Image image = oImage.getScaledInstance(tWidth, tHeight, Image.SCALE_SMOOTH);
            graphic.drawImage(image, 0, 0, tWidth, tHeight, null);
            graphic.dispose(); // 리소스를 모두 해제

            ImageIO.write(tImage, ext, tFile);
            list.add(oFile.getName());
        } catch (IOException e){
            e.printStackTrace();
            log.error(e.getMessage());
            log.error(e.getStackTrace());
        }
        return list;
    }
}
