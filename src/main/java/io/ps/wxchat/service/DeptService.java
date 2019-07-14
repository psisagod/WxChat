package io.ps.wxchat.service;

import io.ps.wxchat.dto.DeptDto;

import java.util.List;

public interface DeptService {
    List<DeptDto> selectChildren(Integer pid);
}
