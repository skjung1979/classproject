package com.todo.todo.mapper;

import com.todo.todo.domain.dept.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;

@Mapper
public interface DeptMapper {
    @Sql("select * from dept")
    List<Dept> selectAll();
}
