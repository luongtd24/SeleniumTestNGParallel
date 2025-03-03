package luongtd.helper;

import luongtd.drives.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class CaptureHelper {
    public void captureScreenshot() {
        // Tạo tham chiếu của TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        // Gọi hàm để chụp ảnh màn hình - getScreenshotAs
        File source = ts.getScreenshotAs(OutputType.FILE);
        // Kiểm tra folder tồn tại. Nếu không thì tạo mới folder theo đường dẫn
        File theDir = new File("./screenshots/");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        //Lưu file ảnh với tên cụ thể vào đường dẫn
        try {
            FileHandler.copy(source, new File("./screenshots/testHomePage1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }    // Capture screenshot
    }
}
