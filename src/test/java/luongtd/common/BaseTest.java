package luongtd.common;

import luongtd.drives.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {


    @BeforeMethod
    @Parameters({"browser"})
    public void createBrowser(String browserName) {
        WebDriver driver = setBrowser(browserName);
        DriverManager.setDriver(driver); //gan gia tri driver vao trong ThreadLocal
    }

    public WebDriver setBrowser(String browserName) {
        WebDriver driver = null;

        if (browserName.trim().toLowerCase().equals("chrome")) {
            driver = new ChromeDriver();
        }
        if (browserName.trim().toLowerCase().equals("firefox")) {
            driver = new FirefoxDriver();
        }
        if (browserName.trim().toLowerCase().equals("edge")) {
            driver = new EdgeDriver();
        }

        //2 ham cho doi
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Ham cho tim kiem element trong 10s
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        // 2 ham de maximize/minimine trinh duyet
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public void closeBrowser() {
        DriverManager.quit();
    }
}
