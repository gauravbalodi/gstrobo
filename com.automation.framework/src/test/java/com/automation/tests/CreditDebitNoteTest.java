package com.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.Base.BaseTest;

public class CreditDebitNoteTest extends BaseTest {

	@BeforeMethod
	public void reload() {

		driver.navigate().refresh();
	}

	@Test(priority = 0)
	public void navigateToCreditDebitPage() throws InterruptedException {

		globalNavigation.navigateToInvoiceCreationPage();
		Thread.sleep(2000);
		WebElement CreditDebitNoteMenu = driver.findElement(By.xpath("//body/div[@id='mainSectionLayout']/div[1]/aside[1]/section[1]/ul[1]/li[3]/ul[1]/li[1]/ul[1]/li[2]"));
		
		System.out.println(CreditDebitNoteMenu.isDisplayed());
		WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(CreditDebitNoteMenu));
        CreditDebitNoteMenu.click();
        
		
		
    
		

	}
}
