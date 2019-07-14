package io.ps.wxchat.service.impl;

import io.ps.wxchat.dao.DeptMapper;
import io.ps.wxchat.dto.DeptDto;
import io.ps.wxchat.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<DeptDto> selectChildren(Integer pid) {
        List<DeptDto> list = deptMapper.selectChildren(pid);
        return list;
    }
}
