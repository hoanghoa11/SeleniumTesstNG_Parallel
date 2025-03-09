package com.hoa.Bai30_TakeScreenshot_RecordVideo;

import com.hoa.Bai26_ParallelExecutorPOM.Page.LoginPage;
import com.hoa.common.BaseTest;
import com.hoa.helpers.CaptureHelper;
import com.hoa.helpers.ExcelHelper;
import com.hoa.keywords.WebUI;
import org.testng.annotations.Test;

public class DemoTakeScreenShot extends BaseTest {
    //Khai báo đối tượng toan cục
    LoginPage loginPage;

    @Test
    public void testLoginCRM_Success() {
        System.out.println("=====testLoginCRM_Success=====");
        //Khởi tại đối tượng class LoginPage để truyền giá trị driver từ BaseTest
        //Để class LoginPage nhận được giá trị driver thì mới thực thi các hàm trong class page được
        loginPage = new LoginPage();
        CaptureHelper.startRecord("testLoginCRM_Success");
        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/testdata/logindata.xlsx", "Sheet1");

        loginPage.loginCRM(
                excel.getCellData("email", 1),
                excel.getCellData("password", 1)
        );
        WebUI.sleep(2);
        CaptureHelper.stopRecord();
        loginPage.verifyLoginSuccess();
// Tạo tham chiếu của TakesScreenshot
//        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
//// Gọi hàm để chụp ảnh màn hình - getScreenshotAs
//        File source = ts.getScreenshotAs(OutputType.FILE);
//// Kiểm tra folder tồn tại. Nếu không thì tạo mới folder theo đường dẫn
//        File theDir = new File("./screenshots/");
//        if (!theDir.exists()) {
//            theDir.mkdirs();
//        }
////Lưu file ảnh với tên cụ thể vào đường dẫn
//        try {
//            FileHandler.copy(source, new File("./screenshots/testHomePage1.png"));
//            System.out.println("Take screenshot successfully");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        CaptureHelper.captureScreenshot("testLoginCRMsuccess");

    }


}
