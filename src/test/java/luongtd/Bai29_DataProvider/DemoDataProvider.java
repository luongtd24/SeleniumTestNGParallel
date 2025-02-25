package luongtd.Bai29_DataProvider;

import org.testng.annotations.Test;

import java.util.Hashtable;

public class DemoDataProvider {

    //Truyen noi cung cap du lieu vao trong testcase @Test
    //goi dataProvider trong @Test thi goi name cua DataProvider la dataLogin
    @Test(dataProvider = "dataLogin", dataProviderClass = DataProviderFactory.class)
    public void testLoginSuccess(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    @Test(dataProvider = "dataAddNewCustomer", dataProviderClass = DataProviderFactory.class)
    public void testAddNewCustomer(String name, String sex, String birthday, String address, String phone) {
        System.out.println("Name: " + name);
        System.out.println("Sex: " + sex);
        System.out.println("Birthday: " + birthday);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
    }

    @Test(dataProvider = "dataFromExcel", dataProviderClass = DataProviderFactory.class)
    public void testLoginfromExcel(String username, String password) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    @Test(dataProvider = "dataFromExcelMultipleRow", dataProviderClass = DataProviderFactory.class)
    public void testLoginFromExcelMultipleRow(Hashtable<String, String> data) {
        System.out.println("Username: " + data.get("email"));   //email la ten cot trong file excel
        System.out.println("Password: " + data.get("password"));    //password la ten cot trong file excel
    }

}