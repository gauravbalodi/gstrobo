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
		
	// Verify User is able to redirect to Tax Invoice page.
	@Test(priority=0)
	public void navigateToTaxInvoicePage() {
	
		globalNavigation.navigateToInvoiceCreationPage();
        taxInvoice.clivkOnTaxInvoiceMenu();
		Assert.assertEquals("Tax Invoice",taxInvoice.getTaxInvoiceText());
	    driver.navigate().back();	
	
	}
	
	// Verify User is able to redirect to Add tax Invoice Page.
	@Test(priority=1)
	public void navigateToAddTaxInvoicePage() {
		globalNavigation.navigateToInvoiceCreationPage();
        taxInvoice.clivkOnTaxInvoiceMenu();
        taxInvoice.clickOnNewTaxInvoiceButton();
        Assert.assertEquals("Add Tax Invoice", taxInvoice.getaddtaxInvoiceText());
		
	}
	
	 
	
			
}
