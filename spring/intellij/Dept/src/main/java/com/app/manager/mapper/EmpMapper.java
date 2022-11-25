package com.app.manager.mapper;

import com.app.manager.domain.emp.EmpDTO;
import com.app.manager.domain.emp.EmpSearchOption;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface EmpMapper {
    List<EmpDTO> selectSearchOption(EmpSearchOption empSearchOption);

    int insertEmp(EmpDTO empDTO);

    int selectMaxEmpno();

    List<String> selectJob();

    List<EmpDTO> selectMgr();

    EmpDTO selectByEmpno(int empno);

    void updateEmpDTO(EmpDTO empDTO);

    int deleteEmp(int empno);

}
