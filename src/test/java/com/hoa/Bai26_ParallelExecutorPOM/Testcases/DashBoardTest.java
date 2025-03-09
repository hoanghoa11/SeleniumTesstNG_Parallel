package com.hoa.Bai26_ParallelExecutorPOM.Testcases;

import com.hoa.Bai26_ParallelExecutorPOM.Page.CustomerPage;
import com.hoa.Bai26_ParallelExecutorPOM.Page.DashBoardPage;
import com.hoa.Bai26_ParallelExecutorPOM.Page.LoginPage;
import com.hoa.common.BaseTest;
import org.testng.annotations.Test;

public class DashBoardTest extends BaseTest {

    LoginPage loginPage;
    DashBoardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testOpenCustomerPage() {
        //loginPage = new LoginPage(driver);
        //loginPage.loginCRM("admin@example.com", "123456");
        //loginPage.verifyLoginSuccess();

        //dashboardPage = new DashboardPage(driver);
        //dashboardPage.clickMenuCustomers();

        //customerPage = new CustomerPage(driver);
        //customerPage.verifyRedirectCustomerPageSuccess();

        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyRedirectCustomerPageSuccess();

    }

    @Test
    public void testLogout() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

        //dashboardPage = new DashboardPage(driver);
        loginPage = dashboardPage.logOut();
        loginPage.verifyRedirectLoginPage();

    }
}
