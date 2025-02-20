package luongtd.Bai28_ReadExcelFile;

import luongtd.helper.ExcelHelper;

public class DemoReadExcelFile {
    public static void main(String[] args) {
        ExcelHelper excelHelper = new ExcelHelper();
        excelHelper.setExcelFile("src/test/resources/testdata/DataTest.xlsx", "Sheet1");
        System.out.println(excelHelper.getCellData(0, 1));
        System.out.println(excelHelper.getCellData(1, 1));
    }
}
