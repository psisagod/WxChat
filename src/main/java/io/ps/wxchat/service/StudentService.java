package io.ps.wxchat.service;

import com.github.pagehelper.Page;
import io.ps.wxchat.po.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    Page<Student> search(String name, Integer deptid);

    void add(Student student);

    void update(Student student);

    void delete(Integer studentId);

    void ps(List<Integer> studentIds);
}
