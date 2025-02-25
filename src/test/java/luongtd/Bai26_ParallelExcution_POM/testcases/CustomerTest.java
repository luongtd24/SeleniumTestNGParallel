package luongtd.Bai26_ParallelExcution_POM.testcases;

import luongtd.Bai26_ParallelExcution_POM.pages.CustomerPage;
import luongtd.Bai26_ParallelExcution_POM.pages.DashboardPage;
import luongtd.Bai26_ParallelExcution_POM.pages.LoginPage;
import luongtd.common.BaseTest;
import luongtd.constant.ConfigurationLogin;
import luongtd.helper.ExcelHelper;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void addNewCuscomerSucces() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigurationLogin.email, ConfigurationLogin.password);
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyRedirectCustomerPageSuccess();
        customerPage.clickButtonAddNewCustomer();
        //customerPage.inputDateCustomer("LTD");

    }

    @Test()
    public void searchAndClickCompanyName() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigurationLogin.email, ConfigurationLogin.password);
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomers();
        //customerPage.searchInfoCompany("LTD");
        ExcelHelper excelHelper = new ExcelHelper();
        //excelHelper.
    }

}
