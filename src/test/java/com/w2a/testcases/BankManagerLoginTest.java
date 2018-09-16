package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase {
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
	//	System.setProperty("org.uncommons.reportng.escape-output","false");
		driver.findElement(By.cssSelector(or.getProperty("bmlBtn"))).click();
		log.debug("Clicked  on the BankManager Login button !!!");
		
		Assert.assertTrue(isElementPresent(By.cssSelector(or.getProperty("addCustBtn"))), "Login Not SuccessFUL!!!");
		
	//	log.debug("Log in successfully Executed!!!");
		Assert.fail("Log in Not Successful");
		
	}

}
