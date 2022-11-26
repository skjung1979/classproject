package com.todo.todomybatis.mapper;

import com.todo.todomybatis.domain.dept.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> selectAll();
}
