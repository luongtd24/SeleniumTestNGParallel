package luongtd.Bai30_TakeScreenshot_VideoRecord;

import luongtd.Bai26_ParallelExcution_POM.pages.LoginPage;
import luongtd.common.BaseTest;
import luongtd.helper.ExcelHelper;
import org.testng.annotations.Test;

public class DemoTakeScreenshot extends BaseTest {
    LoginPage loginPage;

    @Test
    public void testLoginCRM_Success() {
        //Khoi tao doi tuong class LoginPage de truyen gia tri driver tu BaseTest
        //De class LoginPage nhan duoc gia tri driver thi moi thuc thi cac ham trong class page duoc
        loginPage = new LoginPage();
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Sheet1");
        loginPage.loginCRM(excelHelper.getCellData("email", 2), excelHelper.getCellData("password", 1));
        loginPage.verifyLoginSuccess();
    }
}
