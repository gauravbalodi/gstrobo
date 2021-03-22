package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaxInvoice {
	
	@FindBy(xpath="//label[@class='radio-inline']")
	WebElement regularRadioButton;
	
	@FindBy(css="input[name='GstinNo']")
	WebElement gstinNo;
	
	@FindBy(xpath="//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ng-form[1]/div[1]/label[1]")
	WebElement outsideElement;
	
	@FindBy(css="#EcomGSTIN")
	WebElement ecomGstin;
	
	@FindBy(xpath="//h1[contains(text(),'Add Tax Invoice')]")
	WebElement addtaxInvoiceText;
	
	@FindBy(xpath="//body/div[@id='mainSectionLayout']/div[1]/aside[1]/section[1]/ul[1]/li[3]/ul[1]/li[1]/ul[1]/li[1]/a[1]")
	WebElement taxInvoiceMenu;
	
	@FindBy(xpath="//h1[contains(text(),'Tax Invoice')]")
	WebElement taxInvoiceText;
	
	@FindBy(xpath="//a[contains(text(),'New Invoice')]")
	WebElement newInvoiceButton;
	
	@FindBy(xpath="//label[@class='radio-inline'][2]")
	WebElement exportRadioButton;
	
	
	public void clickOnRegularRadioButton() {
		regularRadioButton.click();
	}
	
	public void sendGstinNo(String gstin) {
		gstinNo.sendKeys(gstin);
	}
	
	public String getaddtaxInvoiceText() {
		return addtaxInvoiceText.getText();
		
	}
	
	public void clivkOnTaxInvoiceMenu() {
		taxInvoiceMenu.click();
		
	}

	public String getTaxInvoiceText() {
		return taxInvoiceText.getText();

	}
	
	public void clickOnNewTaxInvoiceButton() {
		
		newInvoiceButton.click();
	}

	public void clickOnExportRadioButton() {
		exportRadioButton.click();
	}







}








