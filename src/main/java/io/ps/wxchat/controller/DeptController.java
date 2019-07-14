package io.ps.wxchat.controller;

import io.ps.wxchat.dto.DeptDto;
import io.ps.wxchat.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
@CrossOrigin
public class DeptController {
    @Autowired
    private DeptService deptService;
    @GetMapping("/getChildren")
    public List<DeptDto> getChildren(@RequestParam(required = false,defaultValue = "0") Integer pid){
        List<DeptDto> deptDtos = deptService.selectChildren(pid);
        return deptDtos;
    }
}
