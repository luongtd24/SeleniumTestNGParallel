package luongtd.Bai27_ReadPropertiFile;

import luongtd.helper.PropertiHelper;
import org.testng.annotations.Test;

public class DemoReadPropertiesFile {
    @Test
    public void testReadFile() {
        //load all properties file
        PropertiHelper.loadAllFiles();
        //Get value
        System.out.println("Browser:" + PropertiHelper.getValue("browser"));
        System.out.println("URL:" + PropertiHelper.getValue("url"));
        System.out.println("EMAIL:" + PropertiHelper.getValue("email"));
        System.out.println("PASSWORD:" + PropertiHelper.getValue("password"));
    }

    @Test
    public void setValueFile() {
        //chi dinh file can set DATA
        PropertiHelper.setFile("src/test/resources/configs/configs.properties");
        //Goi ham set Value
        PropertiHelper.setValue("content", "Security");
    }
}
