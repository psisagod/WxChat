package io.ps.wxchar.service;

import com.github.pagehelper.Page;
import io.ps.wxchar.dto.RecordListDto;
import io.ps.wxchar.po.Student;

import java.util.List;

public interface RecordService {


    List<RecordListDto> selectRecordList(String oppenid);

    Page<RecordListDto> selectSreach(String sreach, String oppenid);
}
