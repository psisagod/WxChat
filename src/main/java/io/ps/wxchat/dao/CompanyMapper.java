package io.ps.wxchat.dao;

import io.ps.wxchat.po.Company;
import org.apache.ibatis.annotations.Param;

public interface CompanyMapper {
    int deleteByPrimaryKey(Integer companyId);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer companyId);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    String selectByCompanyName(Integer companyid);

    Integer selectByCompanyID(@Param("sreach") String sreach);
}