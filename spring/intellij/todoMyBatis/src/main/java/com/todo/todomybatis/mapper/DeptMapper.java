package com.todo.todomybatis.mapper;

import com.todo.todomybatis.domain.dept.Dept;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DeptMapper {
    //@Sql("select * from dept")
    List<Dept> selectAll();
}
