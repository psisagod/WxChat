package io.ps.wxchat.service;

import com.github.pagehelper.Page;
import io.ps.wxchat.dto.RecordDto;
import io.ps.wxchat.dto.RecordListDto;

import java.util.List;

public interface RecordService {


    RecordDto selectRecordList(String oppenid, Integer pageNum);

    Page<RecordListDto> selectSreach(String sreach, String oppenid);
}
