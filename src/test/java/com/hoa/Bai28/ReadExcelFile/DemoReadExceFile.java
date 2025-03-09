package com.hoa.Bai28.ReadExcelFile;

import com.hoa.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class DemoReadExceFile {

    @Test
    public void testGetDataFromExcelFile() {
        //GỌi ha setExxcel để chỉ định ile
        ExcelHelper excelHelper = new ExcelHelper();

        excelHelper.setExcelFile("src/test/resources/testdata/logindata.xlsx", "Sheet1");

        //Gọi ham getCelldata để đọc dư liệ
        System.out.println(excelHelper.getCellData("email", 1));
        System.out.println(excelHelper.getCellData("email", 2));
        System.out.println(excelHelper.getCellData("password", 1));
        System.out.println(excelHelper.getCellData("role", 2));
        System.out.println(excelHelper.getCellData(0, 2));
    }

    @Test
    public void testSetDataFromExcelFile() {
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/testdata/logindata.xlsx", "Sheet2");

        //Ghi giá trị "pass" vào dòng 1 cột 3 (dòng và cột bắt đầu tính từ 0)
        excel.setCellData("pass", 3, 1);
    }
}
