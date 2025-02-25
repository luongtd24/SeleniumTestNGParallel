package luongtd.Bai26_ParallelExcution_POM.testcases;

import luongtd.Bai26_ParallelExcution_POM.pages.CustomerPage;
import luongtd.Bai26_ParallelExcution_POM.pages.DashboardPage;
import luongtd.Bai26_ParallelExcution_POM.pages.LoginPage;
import luongtd.common.BaseTest;
import luongtd.helper.ExcelHelper;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    private void openCustomerPage() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Sheet1");
        loginPage.loginCRM(excelHelper.getCellData("email", 2), excelHelper.getCellData("password", 1));
        //dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

        // dashboardPage = new DashboardPage(driver);

        customerPage = dashboardPage.clickMenuCustomers();

    }

    @Test
    private void ClickProfile() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Sheet1");
        loginPage.loginCRM(excelHelper.getCellData("email", 2), excelHelper.getCellData("password", 1));
        loginPage.verifyLoginSuccess();
        dashboardPage.clickOptionProfile();

    }

    @Test
    private void logOut() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("/src/test/resources/testdata/DataTest.xlsx", "Sheet1");
        loginPage.loginCRM(excelHelper.getCellData("email", 2), excelHelper.getCellData("password", 1));
        loginPage.verifyLoginSuccess();

        loginPage = dashboardPage.logOut();
        loginPage.verifyRedirectLoginPage();
    }


}
