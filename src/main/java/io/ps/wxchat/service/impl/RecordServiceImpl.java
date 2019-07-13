package io.ps.wxchar.service.impl;

import com.github.pagehelper.Page;
import io.ps.wxchar.dao.CompanyMapper;
import io.ps.wxchar.dao.DeptMapper;
import io.ps.wxchar.dao.RecordMapper;
import io.ps.wxchar.dao.StudentMapper;
import io.ps.wxchar.dto.RecordListDto;
import io.ps.wxchar.po.Record;
import io.ps.wxchar.po.Student;
import io.ps.wxchar.service.RecordService;
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
    public List<RecordListDto> selectRecordList(String oppenid) {

        List<RecordListDto> recordListDtoList = new ArrayList<RecordListDto>();

        Student student = studentMapper.selectByoppenid(oppenid);
        if(student!=null){
            String classname = deptMapper.selectByDeptId(student.getDeptid());
            List<Integer> depts = studentMapper.selectByDeptIdList(student.getDeptid());
            String studentids = depts.toString();
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
            return null;
        }
    }

    @Override
    public Page<RecordListDto> selectSreach(String sreach, String oppenid) {
        return null;
    }

}
