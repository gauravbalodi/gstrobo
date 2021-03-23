package com.automation.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.Base.BaseTest;

public class TaxInvoiceTest extends BaseTest{

	@BeforeMethod
	public void reload(){
		
		driver.navigate().refresh();
	}
		
	// Verify User is able to redirect to Tax Invoice page.//
	@Test(priority=1)
	public void navigateToTaxInvoicePage() throws InterruptedException {
	
		globalNavigation.navigateToInvoiceCreationPage();
        taxInvoice.clivkOnTaxInvoiceMenu();
		Assert.assertEquals("Tax Invoice",taxInvoice.getTaxInvoiceText());
	    driver.navigate().back();	
	    Thread.sleep(1000);
	}
	
	// Verify User is able to redirect to Add tax Invoice Page.//
	@Test(priority=2)
	public void navigateToAddTaxInvoicePage() throws InterruptedException {
		globalNavigation.navigateToInvoiceCreationPage();
        taxInvoice.clivkOnTaxInvoiceMenu();
        Thread.sleep(1000);
        taxInvoice.clickOnNewTaxInvoiceButton();
        Assert.assertEquals("Add Tax Invoice", taxInvoice.getaddtaxInvoiceText());
		
	}
	
	// Verify that user should redirect to Tax Invoice page after clicking on Cancel Button.//
	@Test(priority=3)
	public void backToTaxInvoicePage() throws InterruptedException {
		Thread.sleep(1000);
		taxInvoice.clickOnCancelButton();
		Assert.assertEquals("Tax Invoice",taxInvoice.getTaxInvoiceText());
	    driver.navigate().forward();
	}
	
			
}
