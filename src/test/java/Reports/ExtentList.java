package Reports;
import BaseFramework.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class ExtentList  implements ITestListener {
    public static ExtentTest test;
   static ExtentReports	extent =ExtentMaster.createInstance();

    public void onTestStart(ITestResult result) {
        test= extent.createTest(result.getMethod().getMethodName());
    }
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Success");
       String base64Screenshot = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.BASE64);
        test.addScreenCaptureFromBase64String(base64Screenshot);
    }
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        String base64Screenshot = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.BASE64);
        test.addScreenCaptureFromBase64String(base64Screenshot);
    }
    public void onTestSkipped(ITestResult result) {
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }
    public void onStart(ITestContext context) {
    }
    public void onFinish(ITestContext context) {
        extent.flush();
    }



}
