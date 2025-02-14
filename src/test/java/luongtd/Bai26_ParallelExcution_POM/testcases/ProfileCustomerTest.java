package luongtd.Bai26_ParallelExcution_POM.testcases;

import luongtd.Bai26_ParallelExcution_POM.pages.CustomerPage;
import luongtd.Bai26_ParallelExcution_POM.pages.DashboardPage;
import luongtd.Bai26_ParallelExcution_POM.pages.LoginPage;
import luongtd.Bai26_ParallelExcution_POM.pages.ProfileCustomerPage;
import luongtd.common.BaseTest;
import luongtd.constant.ConfigurationLogin;
import org.testng.annotations.Test;

public class ProfileCustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    ProfileCustomerPage profileCustomerPage;

    @Test
    public void verifyContactCustomer() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigurationLogin.email, ConfigurationLogin.password);
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomers();
        profileCustomerPage = customerPage.searchInfoCompany("LTD");    //Đặt profileCustomerPage gán giá trị trả về để khởi tạo profileCustomerPage thay cho lệnh khởi tạo bên dưới
        //profileCustomerPage = new ProfileCustomerPage(driver); //Khởi tạo profileCustomerPage
        profileCustomerPage.verifyRedirectContactCustomerSuccess();
        profileCustomerPage.clickButtonContactsCustomer();
    }

    @Test
    public void addNewContactCustomer() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigurationLogin.email, ConfigurationLogin.password);
        loginPage.verifyLoginSuccess();
        customerPage = dashboardPage.clickMenuCustomers();
        profileCustomerPage = customerPage.searchInfoCompany("LTD");
        profileCustomerPage.clickButtonContactsCustomer();
        profileCustomerPage.addNewContactCustomer();
    }

}
