package io.ps.wxchat.dto;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public class RecordDto {

    private PageInfo<RecordListDto> recordListDtoList;
    private String url;
    private String opendid;

    public PageInfo<RecordListDto> getRecordListDtoList() {
        return recordListDtoList;
    }

    public void setRecordListDtoList(PageInfo<RecordListDto> recordListDtoList) {
        this.recordListDtoList = recordListDtoList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOpendid() {
        return opendid;
    }

    public void setOpendid(String opendid) {
        this.opendid = opendid;
    }
}
