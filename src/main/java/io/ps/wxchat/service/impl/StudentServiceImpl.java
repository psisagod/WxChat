package io.ps.wxchat.service.impl;

import com.github.pagehelper.Page;
import io.ps.wxchat.dao.StudentMapper;
import io.ps.wxchat.po.Student;
import io.ps.wxchat.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Page<Student> search(String name, Integer deptid) {
        return studentMapper.search(name,deptid);
    }

    @Override
    public void add(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void update(Student student) {
        studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public void delete(Integer studentId) {
        studentMapper.deleteByPrimaryKey(studentId);
    }

    @Override
    public void ps(List<Integer> studentIds) {
        studentMapper.ps(studentIds);
    }
}
