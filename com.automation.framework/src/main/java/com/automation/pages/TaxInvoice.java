package com.automation.pages;

import java.util.Set;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.automation.Base.BaseTest;

import Utilities.Configuration;

public class TaxInvoice {

	@FindBy(xpath = "//label[@class='radio-inline']")
	WebElement regularRadioButton;

	@FindBy(css = "input[name='GstinNo']")
	WebElement gstinNo;

	@FindBy(xpath = "//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ng-form[1]/div[1]/label[1]")
	WebElement outsideElement;

	@FindBy(css = "#EcomGSTIN")
	WebElement ecomGstin;

	@FindBy(xpath = "//h1[contains(text(),'Add Tax Invoice')]")
	WebElement addtaxInvoiceText;

	@FindBy(xpath = "//body/div[@id='mainSectionLayout']/div[1]/aside[1]/section[1]/ul[1]/li[3]/ul[1]/li[1]/ul[1]/li[1]/a[1]")
	WebElement taxInvoiceMenu;

	@FindBy(xpath = "//h1[contains(text(),'Tax Invoice')]")
	WebElement taxInvoiceText;

	@FindBy(xpath = "//a[contains(text(),'New Invoice')]")
	WebElement newInvoiceButton;

	@FindBy(xpath = "//label[@class='radio-inline'][2]")
	WebElement exportRadioButton;

	@FindBy(css = "input[name='LegalName']")
	WebElement legalNameTradeName;

	@FindBy(xpath = "//select[@id='DeptID']")
	WebElement department;

	@FindBy(xpath = "//select[@id='POS']")
	WebElement placeOfSupply;

	@FindBy(xpath = "//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/label[1]")
	WebElement supplyAttractReverseCharge;

	@FindBy(xpath = "//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[3]/div[1]/div[1]/label[1]")
	WebElement autoPopulateForRefunds;

	@FindBy(xpath = "//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[4]/div[1]/div[1]/label[1]")
	WebElement igstAct;

	@FindBy(xpath = "//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[6]/div[1]/select[1]")
	WebElement differentialPercentage;

	@FindBy(xpath = "//tbody/tr[1]/td[1]/div[1]/div[1]/button[1]/span[1]")
	WebElement itemOrProductName;

	@FindBy(css = "input[title='Rate']")
	WebElement itemRate;

	@FindBy(css = "input[title='Hsn Code']")
	WebElement hsnCode;

	@FindBy(css = "input[title='Quantity']")
	WebElement itemQuantity;

	@FindBy(css = "input[title='Discount']")
	WebElement discountValue;

	@FindBy(css = "input[title='Cess']")
	WebElement cessValue;

	@FindBy(xpath = "//tbody/tr[1]/td[4]/ng-form[1]/div[1]/div[1]/select[1]")
	WebElement unitType;

	@FindBy(xpath = "//tbody/tr[1]/td[4]/ng-form[1]/div[1]/div[1]/select[1]")
	WebElement taxRateValue;

	@FindBy(xpath = "//a[contains(text(),'Confirm')]")
	WebElement confirmButton;

	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	WebElement cancelButton;

	@FindBy(xpath = "//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]")
	WebElement billingAddress;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/ng-form[1]/div[2]/div[1]/div[1]")
	WebElement shippingAddress;

	@FindBy(css = "label[class='sameCheck']")
	WebElement sameAsBillingAddressCheck;

	@FindBy(xpath = "//label[@class='radio-inline'][1]")
	WebElement indiaRadioButton;

	@FindBy(xpath = "//label[@class='radio-inline'][2]/input")
	WebElement internationalRadioButton;

	@FindBy(xpath = "//body/div[1]/form[1]/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/ng-form[1]/div[1]/input[1]")
	WebElement indianAddress1;

	@FindBy(xpath = "//body/div[1]/form[1]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/ng-form[1]/div[1]/input[1]")
	WebElement indianAddress2;

	@FindBy(xpath = "//body/div[1]/form[1]/div[1]/div[2]/div[1]/section[1]/div[2]/div[1]/div[1]/ng-form[1]/div[1]/div[1]/select[1]")
	WebElement indianState;

	@FindBy(xpath = "(//input[@id='City'])[1]")
	WebElement indianCity;

	@FindBy(xpath = "(//input[@id='City'])[2]")
	WebElement internationalCity;

	@FindBy(xpath = "//body/div[1]/form[1]/div[1]/div[2]/div[1]/section[1]/div[3]/div[2]/ng-form[1]/div[1]/div[1]/div[1]/select[1]")
	WebElement indianPincode;

	@FindBy(xpath = "(//input[@id='Addr1'])[2]")
	WebElement internationalAddress1;

	@FindBy(xpath = "(//input[@id='Addr2'])[2]")
	WebElement internationalAddress2;

	@FindBy(xpath = "//body/div[1]/form[1]/div[1]/div[2]/div[1]/section[2]/div[2]/div[1]/div[1]/ng-form[1]/div[1]/div[1]/select[1]")
	WebElement internationalCountry;

	@FindBy(xpath = "//input[@id='State']")
	WebElement internationalState;

	@FindBy(xpath = "//input[@id='PinCode']")
	WebElement internationalPinCode;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement addressSaveButton;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement addressCancelButton;

	@FindBy(xpath = "//div[@id='divAlert']//div[@class='modal-body']/div[1]/div")
	WebElement alertMessages;

	@FindBy(xpath = "//div[@id='divAlert']//div[@class='modal-body']/div[2]//button")
	WebElement okAlertMessages;

	@FindBy(xpath = "//span[contains(text(),'Department required')]")
	WebElement depReqMsg;

	@FindBy(xpath = "//tbody/tr[1]/td[2]/ng-form[1]/div[1]")
	WebElement itemReqDiv;

	@FindBy(xpath = "//tbody/tr[1]/td[2]/ng-form[1]/div[1]/span")
	WebElement itemReqMsg;

	public void checkRequiredFeilds() {
		Assert.assertTrue(depReqMsg.isDisplayed());
		Actions action = new Actions(getDriver());
		action.moveToElement(itemReqDiv);
		Assert.assertTrue(itemReqMsg.isDisplayed());
	}

	public void clickOnOkButton() {
		okAlertMessages.click();
	}

	public String getAlertMessage() {

		return alertMessages.getText();
	}

	public WebDriver getDriver() {
		return BaseTest.getDriver();
	}

	public void indianBillingAddress() throws Exception {
		WebDriver driver = getDriver();
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		clickOnBillingAddressSection();
		Set<String> availableWindows = driver.getWindowHandles();
		Iterator<String> it = availableWindows.iterator();
		it.next();
		String childWindow = it.next();
		System.out.println(childWindow);
		driver.switchTo().window(childWindow);
		clickOnIndiaRadioButton();
		sendIndianAddress1();
		sendIndianAddress2();
		selectIndianState();
		Thread.sleep(2000);
		sendIndianCity();
		selectIndianPincode();
		clickOnAddressSaveButton();
		driver.switchTo().window(parentWindow);
	}

	public void internationalBillingAddress() throws Exception {
		WebDriver driver = getDriver();
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		clickOnBillingAddressSection();
		Set<String> availableWindows = driver.getWindowHandles();
		Iterator<String> it = availableWindows.iterator();
		it.next();
		String childWindow = it.next();
		System.out.println(childWindow);
		driver.switchTo().window(childWindow);
		clickOnInternationalRadioButton();
		sendInternationalAddress1();
		sendInternationalAddress2();
		sendInternationalPinCode();
		sendInternationalState();
		// Thread.sleep(1000);
		selectInternationalCountry();
		sendInternationalCity();
		sendInternationalPinCode();
		clickOnAddressSaveButton();
		driver.switchTo().window(parentWindow);
	}

	public void sendInternationalCity() throws Exception {
		String city = Configuration.getConfig("internationalCity");
		internationalCity.sendKeys(city);
	}

	public void selectInternationalCountry() throws Exception {
		String country = Configuration.getConfig("internationalCountry");
		Select countries = new Select(internationalCountry);
		countries.selectByVisibleText(country);
	}

	public void sendInternationalState() throws Exception {
		String state = Configuration.getConfig("internationalState");
		internationalState.sendKeys(state);
	}

	public void sendInternationalPinCode() throws Exception {
		String pinCode = Configuration.getConfig("internationalPinCode");
		internationalPinCode.sendKeys(pinCode);
	}

	public void clickOnAddressSaveButton() {
		addressSaveButton.click();
	}

	public void sendInternationalAddress2() throws Exception {
		String address2 = Configuration.getConfig("internationalAddress2");

		internationalAddress2.sendKeys(address2);
	}

	public void sendInternationalAddress1() throws Exception {
		String address1 = Configuration.getConfig("internationalAddress1");
		internationalAddress1.sendKeys(address1);
	}

	public void clickOnAddressCancelButton() {
		addressCancelButton.click();
	}

	public void selectIndianPincode() throws Exception {
		String pinCode = Configuration.getConfig("indianPincode");
		Select indiaPincode = new Select(indianPincode);
		indiaPincode.selectByVisibleText(pinCode);
	}

	public void sendIndianCity() throws Exception {
		String city = Configuration.getConfig("indianCity");
		indianCity.sendKeys(city);
	}

	public void selectIndianState() throws Exception {
		String state = Configuration.getConfig("indiaState");

		Select indiaState = new Select(indianState);
		indiaState.selectByVisibleText(state);
	}

	public void sendIndianAddress2() throws Exception {
		String address2 = Configuration.getConfig("indianAddress2");
		indianAddress2.sendKeys(address2);
	}

	public void sendIndianAddress1() throws Exception {
		String address1 = Configuration.getConfig("indianAddress1");
		indianAddress1.sendKeys(address1);
	}

	public void clickOnInternationalRadioButton() {
		internationalRadioButton.click();
	}

	public void clickOnIndiaRadioButton() {
		indiaRadioButton.click();
	}

	public void clickOnSameAsBillingAddressCheck() {
		sameAsBillingAddressCheck.click();

	}

	public void clickOnShippingAddressSection() {
		shippingAddress.click();
	}

	public void clickOnBillingAddressSection() {
		billingAddress.click();
	}

	public void clickOnCancelButton() {
		cancelButton.click();
	}

	public void clickOnConfirmButton() {
		confirmButton.click();
	}

	public void selecttaxRate() throws Exception {
		String taxRates = Configuration.getConfig("taxRate");
		Select taxRate = new Select(taxRateValue);
		taxRate.selectByVisibleText(taxRates);
	}

	public void selectUnitType() throws Exception {
		String itemUnit = Configuration.getConfig("unitType");
		Select unit = new Select(unitType);
		unit.selectByVisibleText(itemUnit);
	}

	public void sendcessValue() throws Exception {
		String cess = Configuration.getConfig("cessValue");
		cessValue.sendKeys(cess);

	}

	public void sendDiscountValue() throws Exception {
		String discount = Configuration.getConfig("discountValue");
		discountValue.sendKeys(discount);
	}

	public void sendItemQuantity() throws Exception {
		String quantity = Configuration.getConfig("itemQuantity");
		itemQuantity.sendKeys(quantity);
	}

	public void sendHsnCode() throws Exception {
		String hsn = Configuration.getConfig("hsnCode");
		hsnCode.sendKeys(hsn);
	}

	public void sendItemRate() throws Exception {
		String rate = Configuration.getConfig("itemRate");
		itemRate.sendKeys(rate);
	}

	public void selectitemName() throws Exception {
		String productName = Configuration.getConfig("itemName");
		Select itemName = new Select(itemOrProductName);
		itemName.selectByVisibleText(productName);
	}

	public void selectdifferentialPercentage() throws Exception {
		String diffPercentage = Configuration.getConfig("differentialPercentage");
		Select dP = new Select(differentialPercentage);
		dP.selectByVisibleText(diffPercentage);
	}

	public void clickOnIgstAct() {
		igstAct.click();
	}

	public void clickOnautoPopulateForRefunds() {
		autoPopulateForRefunds.click();
	}

	public void clickOnRegularRadioButton() {
		regularRadioButton.click();
	}

	public void sendGstinNo() throws Exception {
		String gstin = Configuration.getConfig("gstin");
		gstinNo.sendKeys(gstin);
	}

	public void sendLegalName() throws Exception {
		String legalName = Configuration.getConfig("legalName");
		legalNameTradeName.sendKeys(legalName);
	}

	public void selectDepartment() throws Exception {
		String depName = Configuration.getConfig("departmentName");
		Select Department = new Select(department);
		Department.selectByVisibleText(depName);
	}

	public void selectPlaceOfSupply(String state) {

		Select pos = new Select(placeOfSupply);
		pos.selectByVisibleText(state);
	}

	public void sendEcomGstin() throws Exception {
		String ecommerceGstin = Configuration.getConfig("ecommerceGstin");
		ecomGstin.sendKeys(ecommerceGstin);
	}

	public void clickOnsupplyAttractReverseCharge() {
		supplyAttractReverseCharge.click();
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
