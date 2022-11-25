package com.app.manager.service.emp;

import com.app.manager.domain.emp.EmpDTO;
import com.app.manager.domain.emp.EmpSearchOption;
import com.app.manager.mapper.EmpMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class EmpListService {

    @Autowired(required = false)
    private EmpMapper empMapper;

    public List<EmpDTO> getSearchList(EmpSearchOption empSearchOption){
        return empMapper.selectSearchOption(empSearchOption);
    }

    public EmpDTO getListBy(int empno){
        return empMapper.selectByEmpno(empno);
    }

}
