package io.ps.wxchar.dao;

import com.github.pagehelper.Page;
import io.ps.wxchar.po.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Page<Student> selectAllUser(String name, Integer deptid);
}