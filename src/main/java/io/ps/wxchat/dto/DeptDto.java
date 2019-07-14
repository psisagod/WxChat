package io.ps.wxchat.dto;

import io.ps.wxchat.po.Dept;

import java.util.List;

public class DeptDto extends Dept {
    private List<DeptDto> list;

    public List<DeptDto> getList() {
        return list;
    }

    public void setList(List<DeptDto> list) {
        this.list = list;
    }
}
