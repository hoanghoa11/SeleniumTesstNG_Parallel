package com.hoa.Bai31_TestListener.Testcases;


import com.hoa.Bai31_TestListener.Page.LoginPage;
import com.hoa.common.BaseTest;
import com.hoa.helpers.ExcelHelper;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    //Khai báo đối tượng toan cục
    LoginPage loginPage;

    @Test
    public void testLoginCRM_Success() {
        System.out.println("=====testLoginCRM_Success=====");
        //Khởi tại đối tượng class LoginPage để truyền giá trị driver từ BaseTest
        //Để class LoginPage nhận được giá trị driver thì mới thực thi các hàm trong class page được
        loginPage = new LoginPage();

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/testdata/logindata.xlsx", "Sheet1");

        loginPage.loginCRM(
                excel.getCellData("email", 2),
                excel.getCellData("password", 2)
        );
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginCRM_EmailInvalid() {
        System.out.println("=====testLoginCRM_EmailInvalid=====");
        loginPage = new LoginPage();
        loginPage.loginCRM("admin123@example.com", "123456");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCRM_PasswordInvalid() {
        System.out.println("=====testLoginCRM_PasswordInvalid=====");
        loginPage = new LoginPage();
        loginPage.loginCRM("admin@example.com", "123");
        loginPage.verifyLoginFail();
    }
}
