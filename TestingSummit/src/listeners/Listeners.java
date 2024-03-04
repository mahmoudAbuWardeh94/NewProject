package listeners;

import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is Pass");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test is Fail");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	@Override
	public void onStart(ITestContext context) {
//		System.out.println("Test is Start");
	}

	@Override
	public void onFinish(ITestContext context) {
//		System.out.println("Test is Finish");

	}
}
