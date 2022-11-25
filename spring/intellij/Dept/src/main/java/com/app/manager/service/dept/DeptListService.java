package com.app.manager.service.dept;

import com.app.manager.domain.DeptDTO;
import com.app.manager.mapper.DeptMapper;
import com.app.manager.mapper.DeptMapper2;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class DeptListService {

    @Autowired(required = false)
    private DeptMapper deptMapper;

    @Autowired(required = false)
    private DeptMapper2 deptMapper2;

    public List<DeptDTO> getList(){

        return deptMapper2.selectAll();
    }


}
