package luongtd.Bai31_TestListener.testcases;

import luongtd.Bai31_TestListener.pages.CustomerPage;
import luongtd.Bai31_TestListener.pages.DashboardPage;
import luongtd.Bai31_TestListener.pages.LoginPage;
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
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "addNewCustomer");
        dashboardPage = loginPage.loginCRM(ConfigurationLogin.email, ConfigurationLogin.password);
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.verifyRedirectCustomerPageSuccess();
        customerPage.clickButtonAddNewCustomer();
        customerPage.inputDataCustomer(
                excelHelper.getCellData("companyName", 3),
                excelHelper.getCellData("vatNumber", 3),
                excelHelper.getCellData("phone", 3),
                excelHelper.getCellData("website", 3),
                excelHelper.getCellData("groups", 3),
                excelHelper.getCellData("address", 3),
                excelHelper.getCellData("city", 3),
                excelHelper.getCellData("state", 3),
                excelHelper.getCellData("zipCode", 3)
        );

    }

    @Test()
    public void searchAndClickCompanyName() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigurationLogin.email, ConfigurationLogin.password);
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomers();
        //customerPage.searchInfoCompany("LTD");
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "addNewCustomer");
        customerPage.searchInfoCompany(excelHelper.getCellData("companyName", 3));
        System.out.println("Excel file path: " + "src/test/resources/testdata/DataTest.xlsx");
        System.out.println("Sheet name: " + "Sheet3");
        System.out.println("Company name: " + excelHelper.getCellData("companyName", 3));
    }

}
