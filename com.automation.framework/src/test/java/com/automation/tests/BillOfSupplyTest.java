package com.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.Base.BaseTest;

public class BillOfSupplyTest extends BaseTest {
	
	
	@BeforeMethod
	public void reload(){
		
		driver.navigate().refresh();
	}
		

	@Test
	
	public void navigateToBillOfSupplyPage() {
		
		globalNavigation.navigateToSalesInvoiceMenu();
		
		driver.findElement(By.xpath("//body/div[@id='mainSectionLayout']/div[1]/aside[1]/section[1]/ul[1]/li[3]/ul[1]/li[1]/ul[1]/li[3]/a[1]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'New Invoice')]")).click();
		
		
		
		
	}
	
}
