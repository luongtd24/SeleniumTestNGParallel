package luongtd.listeners;

import luongtd.helper.CaptureHelper;
import luongtd.helper.PropertiHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext result) {
        System.out.println("onStart: " + result.getName());
        PropertiHelper.loadAllFiles();
    }

    @Override
    public void onFinish(ITestContext result) {
        System.out.println("onFinish: " + result.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart: " + result.getName());
        CaptureHelper.startRecord(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess: " + result.getName());
        // CaptureHelper.captureScreenshot(result.getName());
        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure: " + result.getName());
        CaptureHelper.captureScreenshot(result.getName());
        CaptureHelper.stopRecord();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped: " + result.getName());
        CaptureHelper.stopRecord();
    }
}
