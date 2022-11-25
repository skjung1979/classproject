package com.app.manager.mapper;

import com.app.manager.domain.dept.DeptDTO;
import com.app.manager.domain.dept.DeptSearchOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    // 전체 부서 리스트
    List<DeptDTO> selectAll();

    // 검색 타입과 키워드를 받아서 검색 결과를 반환 => 검색 타입과 키워드를 갖는 별도 객체 생성, 도메인에 클래스로 생성
    List<DeptDTO> selectByOption(DeptSearchOption searchOption);

    List<DeptDTO> selectByDeptnos(List<Integer> deptnos); // 여러개의 deptno를 받아오는 리스트 변수 deptnos

    // 수정 or 상세페이지
    DeptDTO selectByDeptno(int deptno);

    // 수정(변경) 처리
    int updateDept(DeptDTO deptDTO);

    // 삭제
    int deleteByDeptno(int deptno);

    // 입력
    int insertDept(DeptDTO deptDTO);

}
