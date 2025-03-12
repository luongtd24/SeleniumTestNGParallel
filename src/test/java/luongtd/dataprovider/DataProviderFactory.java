package luongtd.dataprovider;

import luongtd.helper.ExcelHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {
    @DataProvider(name = "dataLogin", parallel = true)
    public Object[][] dataProvider() {
        return new Object[][]{
                {"Nguyen Van A", "123456"},
                {"Nguyen Van B", "123456"},
                {"Nguyen Van C", "123"},
        };
    }

    @DataProvider(name = "dataAddNewCustomer", parallel = true)
    public Object[][] dataAddNewCustomer() {
        return new Object[][]{
                {"Nguyen Van A", "Nam", "12/12/1990", "Ha Noi", "0123456789"
                },
                {"Nguyen Van B", "Nu", "12/12/1990", "Ha Noi", "0123456789"
                },
                {"Nguyen Van C", "Nam", "12/12/1990", "Ha Noi", "0123456789"
                },
        };
    }

    @DataProvider(name = "dataFromExcel", parallel = true)
    public Object[][] dataFromExcel() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getExcelData("src/test/resources/testdata/DataTest.xlsx", "Sheet1");
        System.out.println("Login data from excel" + data);
        return data;
    }

    @DataProvider(name = "dataFromExcelMultipleRow", parallel = true)
    public Object[][] dataFromExcelMultipleRow() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable("src/test/resources/testdata/DataTest.xlsx", "Sheet3", 1, 3);
        System.out.println("Login data from excel" + data);
        return data;
    }
}
