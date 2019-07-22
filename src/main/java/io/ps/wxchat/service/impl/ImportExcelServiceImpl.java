package io.ps.wxchat.service.impl;

import io.ps.wxchat.dao.DeptMapper;
import io.ps.wxchat.dao.StudentMapper;
import io.ps.wxchat.po.Import;
import io.ps.wxchat.po.Student;
import io.ps.wxchat.service.ImportExcelService;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImportExcelServiceImpl implements ImportExcelService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public String input(String filename) {
        ArrayList<Import> imports = new ArrayList<>();
        Student student = new Student();
        // 流读取文件
        FileInputStream is = null;
        try {
            is = new FileInputStream(new File(filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 根据流创建文件
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(is);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        // 获取sheet
        Sheet sheet = wb.getSheetAt(0);
        // 遍历row
        for (Row row : sheet) {
            Import anImport = new Import();
            // 第一行是标题，不需要读取
            if (row.getRowNum() == 0) {
                continue;
            }
            // 当遇到空行，跳过
            if (row.getCell(0) == null || StringUtils.isBlank(row.getCell(1).getStringCellValue())) {
                continue;
            }
            // 打印内容
            anImport.setId((int) row.getCell(0).getNumericCellValue());//学号
            anImport.setName(row.getCell(1).getStringCellValue());//姓名
            anImport.setClazz(row.getCell(2).getStringCellValue());//班级
            anImport.setSchool(row.getCell(3).getStringCellValue());//学院
            anImport.setCampus(row.getCell(4).getStringCellValue());//校区
            anImport.setPhone(String.valueOf(row.getCell(5).getNumericCellValue()));//手机号
            //是否管理员
            anImport.setGender(false);

            imports.add(anImport);
        }

        for (Import i:imports) {

            Integer did= 0 ;
             did = deptMapper.selectByName(i.getClazz());
            if(did==null){
                try {
                    throw new Exception("没有该班级");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            student.setStudentId(i.getId());
            student.setStudentName(i.getName());
            student.setDeptid(String.valueOf(did));
            student.setGender(i.getGender());
            student.setPhone(i.getPhone());
            studentMapper.insert(student);

        }

        return "导入成功";
    }
}
