package io.ps.wxchat.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ps.wxchat.dao.StudentMapper;
import io.ps.wxchat.po.Student;
import io.ps.wxchat.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@EnableAutoConfiguration
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping("/search")
    public PageInfo<Student> search(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false) String name,
                                           @RequestParam(required = false) Integer deptid){
        PageHelper.startPage(pageNum,5);
        Page<Student> page = studentService.search(name,deptid);
        PageInfo<Student> userPageInfo = page.toPageInfo();
        return userPageInfo;
    }
    @PostMapping("/add")
    private void add(@RequestBody Student student){
        studentService.add(student);
    }
    @PostMapping("/update")
    private void update(@RequestBody Student student){
        studentService.update(student);
    }
    @PostMapping("/delete")
    private void delete(@RequestParam Integer studentId){
        studentService.delete(studentId);
    }
    @PostMapping("/ps")
    private void ps(@RequestParam List<Integer> studentIds){
        studentService.ps(studentIds);
    }
}
