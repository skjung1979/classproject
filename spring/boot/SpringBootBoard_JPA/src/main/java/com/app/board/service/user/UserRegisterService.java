package com.app.board.service.user;

import com.app.board.domain.UserDTO;
import com.app.board.domain.UserRegistRequest;
import com.app.board.mapper.user.UserMapper;
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
public class UserRegisterService {

    @Autowired
    private UserMapper userMapper;

    public int userRegist(UserRegistRequest userRegistRequest) {

        MultipartFile file = userRegistRequest.getUPhoto();

        File saveDir = null;
        String newFileName = null;

        if (file != null && !file.isEmpty() && file.getSize()>0){

            String absolutePath = new File("").getAbsolutePath();

            log.info("absolutePath........... =>" + absolutePath);

            String path = "uphoto";
            saveDir = new File(absolutePath, path);

            if (!saveDir.exists()){
                saveDir.mkdir();
                log.info("uphoto 디렉토리 생성 완료");
            }

            String uuid = UUID.randomUUID().toString();
            newFileName = uuid + "_" + file.getOriginalFilename();

            File newFile = new File(saveDir, newFileName);

            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        UserDTO userDTO = userRegistRequest.toUserDTO();

        if (newFileName != null){
            userDTO.setPhoto(newFileName);
        }

        int result = 0;

        try {
            result = userMapper.insertUser(userDTO);
        } catch (SQLException e){
            if (newFileName != null){
                File delFile = new File(saveDir, newFileName);
                if (delFile.exists()){
                    delFile.delete();
                }
            }
        }

        return result;
    }
}
