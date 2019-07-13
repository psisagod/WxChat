package io.ps.wxchar.dao;

import io.ps.wxchar.po.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    String selectByDeptId(@Param("deptid") String deptid);
}