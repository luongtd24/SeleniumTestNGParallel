package luongtd.Bai31_TestListener.pages;

import luongtd.WebUI;
import org.openqa.selenium.By;

public class DashboardPage {

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuCustomers = By.xpath("//span[normalize-space()='Customers']");
    private By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    private By dropDownProfile = By.xpath("(//a[@class='dropdown-toggle profile tw-block rtl:!tw-px-0.5 !tw-py-1'])[1]");
    private By optionLogout = By.xpath("(//a[.='Logout'])[1]");
    private By optionProfile = By.xpath("(//a[normalize-space()='My Profile'])[2]");


    public CustomerPage clickMenuCustomers() {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(menuCustomers);
        System.out.println("click on menu Customers");
        return new CustomerPage();
    }

    public void clickMenuProject() {
        WebUI.clickElement(menuProjects);
        System.out.println("click on menu Projects");
    }

    public void clickOptionProfile() {
        WebUI.clickElement(dropDownProfile);
        WebUI.sleep(1);
        WebUI.clickElement(optionProfile);
    }

    public LoginPage logOut() {
        WebUI.clickElement(dropDownProfile);
        System.out.println("click on dropdown Profile");

        WebUI.sleep(1);
        WebUI.clickElement(optionLogout);
        System.out.println("click on option Logout");

        return new LoginPage();
    }
}
