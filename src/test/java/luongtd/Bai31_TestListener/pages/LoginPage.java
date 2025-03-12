package luongtd.Bai31_TestListener.pages;

import luongtd.WebUI;
import luongtd.drives.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {

    private String url = "https://crm.anhtester.com/admin/authentication";

    //Khai bao tat ca object (element) tren page nay
    // Thuoc kieu doi tuong By (thuoc selenium )
    By headerLoginPage = By.xpath("//h1[normalize-space()='Login']");
    By inputEmail = By.xpath("//input[@id='email']");
    By inputPassword = By.xpath("//input[@id='password']");
    By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    By errorMessage = By.xpath("//div[@class='text-center alert alert-danger']");
    By menuDashboard = By.xpath("//ul[@id='side-menu']//span[normalize-space()='Dashboard']");


    //Xay dung cac ham xu ly tren chinh Page nay
    private void setInputEmail(String email) {
        WebUI.setText(inputEmail, email);
    }

    private void setInputPassword(String password) {
        WebUI.setText(inputPassword, password);
    }

    private void clickButtonLogin() {
        WebUI.waitForElementVisible(buttonLogin);
        WebUI.clickElement(buttonLogin);
    }

    public DashboardPage loginCRM(String email, String password) {
        // driver.get(url);
        WebUI.openURL(url);
        WebUI.waitForPageLoaded();
        setInputEmail(email);
        setInputPassword(password);
        clickButtonLogin();
        WebUI.waitForPageLoaded();
        return new DashboardPage();
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(menuDashboard).isDisplayed(), "Menu Dashboard not Displayed");
    }

    public void verifyLoginFail() {
        Assert.assertTrue(DriverManager.getDriver().findElement(errorMessage).isDisplayed(), "Error Message not Displayed");
        Assert.assertEquals(WebUI.getElementText(errorMessage), "Invalid email or password123", "Content of Error Message not Displayed");
    }

    public void verifyRedirectLoginPage() {
        System.out.println("Verify redirect to Login Page");
        Assert.assertTrue(DriverManager.getDriver().findElement(headerLoginPage).isDisplayed(), "Header of login page not Displayed");
        Assert.assertEquals(WebUI.getElementText(headerLoginPage), "Login", "Content of header Login page not match");
    }

}
