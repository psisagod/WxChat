package io.ps.wxchat.po;

import java.util.Date;

public class Record {
    private Integer recordId;

    private Integer companyid;

    private Date time;

    private Boolean state;

    private String recordUrl;

    private Integer studentid;

    private Integer count;

    private Integer pcount;

    private Integer dcount;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getRecordUrl() {
        return recordUrl;
    }

    public void setRecordUrl(String recordUrl) {
        this.recordUrl = recordUrl == null ? null : recordUrl.trim();
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPcount() {
        return pcount;
    }

    public void setPcount(Integer pcount) {
        this.pcount = pcount;
    }

    public Integer getDcount() {
        return dcount;
    }

    public void setDcount(Integer dcount) {
        this.dcount = dcount;
    }
}