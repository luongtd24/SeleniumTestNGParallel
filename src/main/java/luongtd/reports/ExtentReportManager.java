package luongtd.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ExtentReport/ExtentReport.html");
        reporter.config().setReportName("Extent Report | LUONG.TD");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java | LUONG.TD");
        extentReports.setSystemInfo("Author", "LUONG.TD");
        return extentReports;
    }
}
