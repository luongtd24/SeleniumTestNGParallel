package luongtd.common;

import luongtd.drives.DriverManager;
import luongtd.helper.PropertiHelper;
import luongtd.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeMethod
    @Parameters({"browser"})
    public void createBrowser(@Optional("chrome") String browserName) {
        //WebDriver driver = setBrowser(browserName);
        //lay gia tri tu file Propertie
        PropertiHelper.loadAllFiles();
        WebDriver driver = setBrowser(PropertiHelper.getValue("browser"));
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
    public void closeBrowser(ITestResult result) {
//        if (ITestResult.FAILURE == result.getStatus()) {
//            CaptureHelper.captureScreenshot(result.getName());
//        }
//        //Stop record video
//        CaptureHelper.stopRecord();
        DriverManager.quit();
    }
}
