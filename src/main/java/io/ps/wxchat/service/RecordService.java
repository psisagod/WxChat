package io.ps.wxchat.service;

import com.github.pagehelper.Page;
import io.ps.wxchat.dto.RecordListDto;

import java.util.List;

public interface RecordService {


    List<RecordListDto> selectRecordList(String oppenid);

    Page<RecordListDto> selectSreach(String sreach, String oppenid);
}
