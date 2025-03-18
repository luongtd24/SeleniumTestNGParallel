package luongtd.listeners;

import com.aventstack.extentreports.Status;
import luongtd.helper.CaptureHelper;
import luongtd.helper.PropertiHelper;
import luongtd.reports.AllureReportManager;
import luongtd.reports.ExtentReportManager;
import luongtd.reports.ExtentTestManager;
import luongtd.utils.LogUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext result) {
        LogUtils.info("onStart: " + result.getName());
        PropertiHelper.loadAllFiles();
        //Khởi tạo report (Extent và Allure)
    }

    @Override
    public void onFinish(ITestContext result) {
        LogUtils.info("onFinish: " + result.getName());
        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        LogUtils.info("onTestStart: " + result.getName());
        CaptureHelper.startRecord(result.getName());
        //Bắt đầu ghi 1 TCs mới vào Extent Report
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogUtils.info("onTestSuccess: " + result.getName());
        // CaptureHelper.captureScreenshot(result.getName());
        //Extent Report
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");
        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogUtils.error("onTestFailure: " + result.getName());
        CaptureHelper.captureScreenshot(result.getName());
        CaptureHelper.stopRecord();
        //Extent Report
        ExtentTestManager.addScreenshot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");

        //Allure Report
        AllureReportManager.saveTextLog(result.getName() + " is failed.");
        AllureReportManager.saveScreenshotPNG();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogUtils.warn("onTestSkipped: " + result.getName());
        //Extent Report
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
        CaptureHelper.stopRecord();
    }
}
