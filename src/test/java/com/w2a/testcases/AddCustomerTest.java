package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddCustomerTest extends TestBase{
	
	@Test(dataProvider = "getData")
	public void addCustomer(String fName, String lName, String pcode,String alertText) throws InterruptedException{
		
		driver.findElement(By.cssSelector(or.getProperty("addCustBtn"))).click();
		
		driver.findElement(By.cssSelector(or.getProperty("firstName"))).sendKeys(fName);
		
		driver.findElement(By.cssSelector(or.getProperty("lastName"))).sendKeys(lName);
		
		driver.findElement(By.cssSelector(or.getProperty("postCode"))).sendKeys(pcode);
		
		driver.findElement(By.cssSelector(or.getProperty("submitBtn"))).click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(alertText));		
		
		alert.accept();
		
		Assert.fail("Customer Not added !!!");
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		//because we will start from row2
		Object[][] data = new Object[rows-1][cols]; 
		
		for (int rowNum=2; rowNum<=rows; rowNum++){
			
			for(int colNum=0 ; colNum<cols; colNum ++){
				
				//data[0][0]
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		
		return data;
	}

}
