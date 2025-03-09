package com.hoa.Bai26_ParallelExecutorPOM.Testcases;


import com.hoa.Bai26_ParallelExecutorPOM.Page.CustomerPage;
import com.hoa.Bai26_ParallelExecutorPOM.Page.DashBoardPage;
import com.hoa.Bai26_ParallelExecutorPOM.Page.LoginPage;
import com.hoa.Bai26_ParallelExecutorPOM.Page.ProfilePage;
import com.hoa.common.BaseTest;
import com.hoa.constants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    DashBoardPage dashboardPage;
    CustomerPage customerPage;
    ProfilePage profilePage;

    private String CUSTOMER_NAME = "Viettel A6";

    @Test
    public void testAddNewCustomer() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customerPage = dashboardPage.clickMenuCustomers();

        customerPage.verifyRedirectCustomerPageSuccess();
        customerPage.clickButtonAddNew();
        customerPage.inputDataCustomer(CUSTOMER_NAME);
        dashboardPage.clickMenuCustomers();

        profilePage = customerPage.searchCustomer(CUSTOMER_NAME);
        profilePage.verifyCustomerDetail(CUSTOMER_NAME);

    }
}
