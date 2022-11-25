package com.app.manager.mapper;

import com.app.manager.domain.dept.DeptDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper2 {

    // 간단한 것은 mapper.xml만들 필요없이 어노테이션을 사용해도 된다.
    // 단, 잘 바뀌지 않는 간단한 코드들만 왜냐하면 빌드 및 컴파일을 다시해야 하므로
    @Select("select * from dept")

    // 전체 부서 리스트
    List<DeptDTO> selectAll();

    // 수정 or 상세페이지
    @Select("select * from dept where deptno=#{no}")
    DeptDTO selectByDeptno(int deptno);

    // 수정(변경) 처리
    @Update("update dept set dname=#{dname}, loc=#{loc} where deptno=#{deptno}")
    int updateDept(DeptDTO deptDTO);

    // 삭제
    @Delete("delete from dept where deptno=#{no}")
    int deleteByDeptno(int deptno);

    // 입력
    @Insert("insert into dept values(#{deptno}, #{dname}, #{loc})")
    int insertDept(DeptDTO deptDTO);

}
