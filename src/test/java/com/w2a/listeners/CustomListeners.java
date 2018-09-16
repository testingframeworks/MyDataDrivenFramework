package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;


public class CustomListeners extends TestBase implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		test = rep.startTest(result.getName().toUpperCase());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(LogStatus.PASS,result.getName().toUpperCase() + "PASS");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output","false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Adding  the  test Description when test fails
		
		test.log(LogStatus.FAIL, result.getName().toUpperCase(), "Failed With exception :" + result.getThrowable());
		
		//A screenshot should be added when there is a failure 
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		
		Reporter.log("Click to see Screenshot");			
		Reporter.log("<a target=\"_blank\" href="+ TestUtil.screenshotName + ">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+ TestUtil.screenshotName + " ><img src=" + TestUtil.screenshotName + " height=200 width=200></img></a>");
		rep.endTest(test);
		rep.flush();
	
	}
	
	

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
