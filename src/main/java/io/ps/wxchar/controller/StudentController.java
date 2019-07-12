package io.ps.wxchar.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ps.wxchar.dao.StudentMapper;
import io.ps.wxchar.po.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@EnableAutoConfiguration
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;
    @GetMapping("/selectAllUser")
    public PageInfo<Student> selectAllUser(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false) String name,
                                           @RequestParam(required = false) Integer deptid){
        PageHelper.startPage(pageNum,5);
        Page<Student> page = studentMapper.selectAllUser(name,deptid);
        PageInfo<Student> userPageInfo = page.toPageInfo();
        return userPageInfo;
    }

}
