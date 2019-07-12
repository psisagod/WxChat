package io.ps.wxchat.dao;

import com.github.pagehelper.Page;
import io.ps.wxchat.po.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentMapper {
    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Page<Student> search(@Param("name") String name,@Param("deptid") Integer deptid);

    void ps(@Param("studentIds")List<Integer> studentIds);
}