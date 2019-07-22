package io.ps.wxchat.dao;

import io.ps.wxchat.dto.DeptDto;
import io.ps.wxchat.po.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    String selectByDeptId(@Param("deptid") String deptid);

    List<DeptDto> selectChildren(@Param("pid") Integer pid);

    Integer selectByName(@Param("campus") String campus);
}