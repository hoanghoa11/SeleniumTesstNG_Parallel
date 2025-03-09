package com.hoa.handle_components;

import com.hoa.common.BaseTest;
import com.hoa.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class HandleUploadFile extends BaseTest {
    @Test
    public void testUploadFileWithSendKeys() throws InterruptedException {
        WebUI.openURL("https://the-internet.herokuapp.com/upload");

        Thread.sleep(2000);

        By inputFileUpload = By.xpath("//input[@id='file-upload']");

        WebUI.setText(inputFileUpload, System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\th (2).jpg");

        Thread.sleep(2000);

        WebUI.clickElement(By.xpath("//input[@id='file-submit']"));
        Thread.sleep(2000);
    }

    @Test
    public void testUploadFile2() throws InterruptedException {
        WebUI.openURL("https://files.fm/");

        Thread.sleep(2000);

        By textOnPage = By.xpath("//div[@id='file_select_dragndrop_text']");
        By divFileUpload = By.xpath("//div[@id='uploadifive-file_upload']");
        By inputFileUpload = By.xpath("//div[@id='file_select_button']//input[@id='file_upload']");

        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\th (2).jpg";

        //Click để mở form upload
        WebUI.clickElement(divFileUpload);
        Thread.sleep(3);

        // Khởi tạo Robot class
        Robot rb = null;
        try {
            rb = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        // Copy File path vào Clipboard
        StringSelection str = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        Thread.sleep(1000);

        // Nhấn Control+V để dán
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // Xác nhận Control V trên
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        Thread.sleep(1000);

        // Nhấn Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(4000);
     
    }
}
