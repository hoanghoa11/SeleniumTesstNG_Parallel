package com.hoa.handle_components;

import com.hoa.common.BaseTest;
import com.hoa.constants.ConfigData;
import com.hoa.handle_components.Page.CustomerPage;
import com.hoa.handle_components.Page.DashBoardPage;
import com.hoa.handle_components.Page.LoginPage;
import org.testng.annotations.Test;

public class Handle_Table_CustomerCRM extends BaseTest {
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    CustomerPage customerPage;


    @Test
    public void testCheckDataOnTable() {
        loginPage = new LoginPage();
        dashBoardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        customerPage = dashBoardPage.clickMenuCustomers();
        customerPage.searchCustomerOnTable("VIP"); //Tra ra 25 records /page
        customerPage.checkPageTotal(5);
        customerPage.checkSearchTableByColumn(8, "VIP"); //So sanh contains
    }


}


