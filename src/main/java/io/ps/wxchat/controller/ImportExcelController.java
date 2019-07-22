package io.ps.wxchat.controller;

import io.ps.wxchat.po.Import;
import io.ps.wxchat.service.ImportExcelService;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

@RestController
@RequestMapping("/imporexcel")
@CrossOrigin
public class ImportExcelController {

    @Autowired
    private ImportExcelService importExcelService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/input")
    public String input(@RequestParam(required = false) String filename){

        String sata = importExcelService.input(filename);

        return sata;
    }
}
