package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.Base.BasePage;

public class GlobalNavigation extends BasePage{
	
	
	@FindBy(xpath="//header/nav[1]/a[1]")
	WebElement leftSideMenu;
	
	
	@FindBy(xpath="//body/div[@id='mainSectionLayout']/div[1]/aside[1]/section[1]/ul[1]/li[3]/a[1]/span[2]/i[1]")
	WebElement invoicesMenu;
	
	@FindBy(xpath="//span[contains(text(),'Sale Invoices')]")
	WebElement saleInvoiceMenu;
	

	public void navigateToSalesInvoiceMenu() throws InterruptedException {
		leftSideMenu.click();
		invoicesMenu.click();
		Thread.sleep(500);
		saleInvoiceMenu.click();
		Thread.sleep(500);
	}
}
