package com.hziee.util;

import com.hziee.po.Tutor;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ExcelUtil {
    /* 读取Excel获取辅导员list */
    public static List<Tutor> readExcel(String path) throws IOException {
        FileInputStream fis = new FileInputStream(new File(path));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        // 读取工作表，从0开始
        XSSFSheet sheet = workbook.getSheetAt(0);
        List<Tutor> tutorList = new LinkedList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            // 读取行
            XSSFRow row = sheet.getRow(i);
            // 读取单元格
            XSSFCell cell = row.getCell(0);
            cell.setCellType(CellType.STRING);
            String tutor_id = cell.getStringCellValue();
            cell = row.getCell(1);
            String tutor_name = cell.getStringCellValue();
            cell = row.getCell(2);
            cell.setCellType(CellType.STRING);
            String pwd = cell.getStringCellValue();

            Tutor tutor = new Tutor();
            tutor.setTutor_id(tutor_id);
            tutor.setName(tutor_name);
            tutor.setPwd(pwd);
            tutor.setEdu_id("3001");
            tutorList.add(tutor);
        }
        workbook.close();
        fis.close();
        return tutorList;
    }

    public static void writeExcel() throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("D:\\poiTest.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        XSSFCell cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("HelloWorld");
        workbook.write(fos);
        workbook.close();
    }
}
