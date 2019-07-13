package io.ps.wxchat.service.impl;

import com.github.pagehelper.Page;
import io.ps.wxchat.dao.CompanyMapper;
import io.ps.wxchat.dao.DeptMapper;
import io.ps.wxchat.dao.RecordMapper;
import io.ps.wxchat.dao.StudentMapper;
import io.ps.wxchat.dto.RecordListDto;
import io.ps.wxchat.po.Record;
import io.ps.wxchat.po.Student;
import io.ps.wxchat.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private CompanyMapper companyMapper;

    private String states[] = {"通过","复试","拒绝"};

    @Override
    public Page<RecordListDto> selectRecordList(String oppenid) {

        Page<RecordListDto> recordListDtoList = new Page();

        Student student = studentMapper.selectByoppenid(oppenid);

        if(student!=null){
            String classname = deptMapper.selectByDeptId(student.getDeptid());
            List<String> depts = studentMapper.selectByDeptIdList(student.getDeptid());
            String studentids = depts.toString();
            studentids=studentids.substring(1,studentids.length()-1);
            List<Record> records = recordMapper.selectByStudents(studentids);
            for (Record r:records) {
                String companyName = companyMapper.selectByCompanyName(r.getCompanyid());
                RecordListDto recordListDto = new RecordListDto();
                recordListDto.setStudent(student.getStudentName());
                recordListDto.setDept(classname);
                recordListDto.setCompany(companyName);
                recordListDto.setCount(r.getCount());
                recordListDto.setDcount(r.getDcount());
                recordListDto.setPcount(r.getPcount());
                recordListDto.setRecordId(r.getRecordId());
                recordListDto.setRecordUrl(r.getRecordUrl());

                recordListDto.setState(states[r.getState()]);

                recordListDto.setTime(r.getTime());
                recordListDtoList.add(recordListDto);
            }
            return recordListDtoList;
        }else{
            //需要管理员认证
            return null;
        }
    }

    @Override
    public Page<RecordListDto> selectSreach(String sreach, String oppenid) {

        Page<RecordListDto> recordListDtoList = new Page();
        //学生姓名
        Student student = studentMapper.selectByoppenid(oppenid);
        String classname = deptMapper.selectByDeptId(student.getDeptid());
        String studentID = studentMapper.selectByStudentName(sreach,student.getDeptid());
        if(studentID!=null){
            List<Record> records = recordMapper.selectByStudents(studentID);
            for (Record r:records) {
                String companyName = companyMapper.selectByCompanyName(r.getCompanyid());
                RecordListDto recordListDto = new RecordListDto();
                recordListDto.setStudent(student.getStudentName());
                recordListDto.setDept(classname);
                recordListDto.setCompany(companyName);
                recordListDto.setCount(r.getCount());
                recordListDto.setDcount(r.getDcount());
                recordListDto.setPcount(r.getPcount());
                recordListDto.setRecordId(r.getRecordId());
                recordListDto.setRecordUrl(r.getRecordUrl());

                recordListDto.setState(states[r.getState()]);

                recordListDto.setTime(r.getTime());
                recordListDtoList.add(recordListDto);
            }
            return recordListDtoList;
        }else {
            //公司
            Integer companyID = companyMapper.selectByCompanyID(sreach);
            if(companyID!=null){
                List<String> depts = studentMapper.selectByDeptIdList(student.getDeptid());
                String studentids = depts.toString();
                studentids=studentids.substring(1,studentids.length()-1);
                List<Record> records =  recordMapper.selectByCompanyandClass(studentids,companyID);
                for (Record r:records) {
                    String companyName = companyMapper.selectByCompanyName(r.getCompanyid());
                    RecordListDto recordListDto = new RecordListDto();
                    recordListDto.setStudent(student.getStudentName());
                    recordListDto.setDept(classname);
                    recordListDto.setCompany(companyName);
                    recordListDto.setCount(r.getCount());
                    recordListDto.setDcount(r.getDcount());
                    recordListDto.setPcount(r.getPcount());
                    recordListDto.setRecordId(r.getRecordId());
                    recordListDto.setRecordUrl(r.getRecordUrl());

                    recordListDto.setState(states[r.getState()]);

                    recordListDto.setTime(r.getTime());
                    recordListDtoList.add(recordListDto);
                }
                return recordListDtoList;
            }
        }

        //无数据
        return null;
    }

}
