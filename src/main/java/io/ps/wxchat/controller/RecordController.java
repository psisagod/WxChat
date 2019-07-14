package io.ps.wxchat.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.ps.wxchat.dto.RecordDto;
import io.ps.wxchat.dto.RecordListDto;
import io.ps.wxchat.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
@EnableAutoConfiguration
@CrossOrigin
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/selectAllUser")
    public PageInfo<RecordListDto> selectAllUser(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                           @RequestParam(required = false) String sreach,
                                           @RequestParam(required = false) String oppenid){
        PageHelper.startPage(pageNum,5);
        if(sreach!=null&&!sreach.equals("")) {
            Page<RecordListDto> page = recordService.selectSreach(sreach, oppenid);
            PageInfo<RecordListDto> userPageInfo = page.toPageInfo();
            return userPageInfo;
        }
        //返回空因为搜索框为空返回全部列表
        return null;
    }

    @GetMapping("/recordList")
    public RecordDto recordList(@RequestParam(required = false,defaultValue = "1") Integer pageNum
                                            , @RequestParam(required = false) String oppenid){

        RecordDto recordDto =recordService.selectRecordList(oppenid,pageNum);


        return recordDto;
    }

}
