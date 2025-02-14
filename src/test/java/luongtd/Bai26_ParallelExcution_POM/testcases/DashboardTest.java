package luongtd.Bai26_ParallelExcution_POM.testcases;

import luongtd.Bai26_ParallelExcution_POM.pages.CustomerPage;
import luongtd.Bai26_ParallelExcution_POM.pages.DashboardPage;
import luongtd.Bai26_ParallelExcution_POM.pages.LoginPage;
import luongtd.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    private void openCustomerPage() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

        // dashboardPage = new DashboardPage(driver);

        customerPage = dashboardPage.clickMenuCustomers();

    }

    @Test
    private void ClickProfile() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

        dashboardPage.clickOptionProfile();

    }

    @Test
    private void logOut() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

        loginPage = dashboardPage.logOut();
        loginPage.verifyRedirectLoginPage();
    }


}
