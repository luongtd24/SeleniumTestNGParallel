package luongtd.Bai31_TestListener.testcases;

import luongtd.Bai31_TestListener.pages.LoginPage;
import luongtd.common.BaseTest;
import luongtd.helper.ExcelHelper;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    //Khai bao doi tuong class LoginPage toan cuc
    LoginPage loginPage;

    @Test
    public void testLoginCRM_Success() {
        //Khoi tao doi tuong class LoginPage de truyen gia tri driver tu BaseTest
        //De class LoginPage nhan duoc gia tri driver thi moi thuc thi cac ham trong class page duoc
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Sheet1");
        loginPage.loginCRM(excelHelper.getCellData("email", 2), excelHelper.getCellData("password", 2));
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginCRM_EmailInvalid() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Sheet2");

        loginPage.loginCRM(excelHelper.getCellData("email", 1), excelHelper.getCellData("password", 1));
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginCRM_PasswordInvalid() {
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Sheet2");
        loginPage.loginCRM(excelHelper.getCellData("email", 2), excelHelper.getCellData("password", 2));
        loginPage.verifyLoginFail();
    }
}
