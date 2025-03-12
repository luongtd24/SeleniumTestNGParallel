package luongtd.Bai31_TestListener.pages;

import luongtd.WebUI;
import luongtd.common.BaseTest;
import luongtd.drives.DriverManager;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProfileCustomerPage extends BaseTest {


    private By headerProfileCustomer = By.xpath("(//h4[normalize-space()='Profile'])[1]");
    private By headerCustomerDetails = By.xpath("//a[normalize-space()='Customer Details']");
    private By buttonContactsCustomer = By.xpath("//a[normalize-space()='Contacts']");
    private By addNewContactsCustomer = By.xpath("//a[normalize-space()='New Contact']");
    private By inputFirstName = By.xpath("//div[@app-field-wrapper='firstname']//input[@type='text']");
    private By inputLastname = By.xpath("//div[@app-field-wrapper='lastname']//input[@type='text']");
    private By inputPosition = By.xpath("//div[@app-field-wrapper='title']//input[@type='text']");
    private By inputEmail = By.xpath("//input[@type='email']");
    private By inputPhone = By.xpath("//div[@app-field-wrapper='phonenumber']//input[@type='text']");
    private By dropDownDirection = By.xpath("//button[@title='System Default']");
    private By inputDirection = By.xpath("//div[@role='listbox']//span[normalize-space()='LTR']");
    private By inputPassword = By.xpath("//input[@autocomplete='false']");
    private By checkPassword = By.xpath("//a[@href='#password']//i");
    private By checkboxPrimaryContact = By.xpath("//label[normalize-space()='Primary Contact']");
    private By buttonPermissionsInvoices = By.xpath("//label[@for='1']");
    private By buttonSave = By.xpath("//button[normalize-space()='Save']");


    public void verifyRedirectContactCustomerSuccess() {
        Assert.assertTrue(DriverManager.getDriver().findElement(headerProfileCustomer).isDisplayed(), "da vao dung trang Contact");
        Assert.assertTrue(DriverManager.getDriver().findElement(headerCustomerDetails).isDisplayed(), "da vao dung trang DetailCustomer");
        Assert.assertEquals(WebUI.getElementText(headerCustomerDetails), "Customer Details", "");
        Assert.assertEquals(WebUI.getElementText(headerProfileCustomer), "Profile", "da vao dung trang Contact");
    }

    public void clickButtonContactsCustomer() {
        WebUI.clickElement(buttonContactsCustomer);
    }

    public void addNewContactCustomer() {
        WebUI.clickElement(addNewContactsCustomer);
        WebUI.setText(inputFirstName, "Nguyen Van");
        WebUI.setText(inputLastname, "Binh");
        WebUI.setText(inputPosition, "Manager");
        WebUI.setText(inputEmail, "lancsnet@gmail.com");
        WebUI.setText(inputPhone, "0987654321");
        WebUI.clickElement(dropDownDirection);
        WebUI.clickElement(inputDirection);
        WebUI.setText(inputPassword, "147258369");
        WebUI.clickElement(checkPassword);
        WebUI.clickElement(buttonPermissionsInvoices);
        WebUI.clickElement(buttonSave);
    }
}
