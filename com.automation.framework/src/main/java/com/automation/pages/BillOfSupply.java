package com.automation.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.automation.Base.BaseTest;

import Utilities.Configuration;

public class BillOfSupply {
	
	

	@FindBy(xpath = "//a[contains(text(),'New Credit/Debit Note')]")
	WebElement newCdnButton;

	@FindBy(xpath = "//h1[contains(text(),'Add Credit/Debit Note')]")
	WebElement addCdnText;

	@FindBy(css = "input[name='GstinNo']")
	WebElement gstinNo;

	@FindBy(css = "input[name='LegalName']")
	WebElement legalNameTradeName;

	@FindBy(xpath = "//select[@id='DeptID']")
	WebElement department;

	@FindBy(xpath = "//select[@id='POS']")
	WebElement placeOfSupply;

	@FindBy(xpath = "//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[3]/div[1]/div[1]/label[1]")
	WebElement autoPopulateForRefunds;

	@FindBy(xpath = "//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[4]/div[1]/div[1]/label[1]")
	WebElement igstAct;

	@FindBy(xpath = "//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]")
	WebElement billingAddress;

	@FindBy(css = "label[class='sameCheck']")
	WebElement sameAsBillingAddressCheck;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/ng-form[1]/div[2]/div[1]/div[1]")
	WebElement shippingAddress;

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
	
	@FindBy(xpath = "//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[6]/div[1]/select[1]")
	WebElement differentialPercentage;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]/div[1]/div[1]/select[1]")
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

	@FindBy(xpath = "//tbody/tr[1]/td[6]/ng-form[1]/div[1]/div[1]/select[1]")
	WebElement taxRateValue;
	
	@FindBy(xpath = "//a[contains(text(),'Confirm')]")
	WebElement confirmButton;

	@FindBy(xpath = "//a[contains(text(),'Cancel')]")
	WebElement cancelButton;
	
	@FindBy(xpath = "//div[@id='divAlert']//div[@class='modal-body']/div[1]/div")
	WebElement alertMessages;

	@FindBy(xpath = "//div[@id='divAlert']//div[@class='modal-body']/div[2]//button")
	WebElement okAlertMessages;
	
 /*
	public String getCdnText() {
		return creditDebitNoteText.getText();
	}

	public void clickOnNewCdnButton() {
		newCdnButton.click();
	}

	public String getAddCdnText() {
		return addCdnText.getText();
	}

	public void sendGstinNo() {
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

	public void clickOnautoPopulateForRefunds() {
		autoPopulateForRefunds.click();
	}

	public void clickOnIgstAct() {
		igstAct.click();
	}

	public void clickOnBillingAddressSection() {
		billingAddress.click();
	}

	public void clickOnSameAsBillingAddressCheck() {
		sameAsBillingAddressCheck.click();

	}

	public void clickOnShippingAddressSection() {
		shippingAddress.click();
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

	public WebDriver getDriver() {
		BaseTest.getDriver();
	}

	public void selectdifferentialPercentage() throws Exception {
		String diffPercentage = Configuration.getConfig("differentialPercentage");
		Select dP = new Select(differentialPercentage);
		dP.selectByVisibleText(diffPercentage);
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
	
	public void clickOnCancelButton() {
		cancelButton.click();
	}

	public void clickOnConfirmButton() {
		confirmButton.click();
	}
	
	public void clickOnOkButton() {
		okAlertMessages.click();
	}

	public String getAlertMessage() {
        String msg= alertMessages.getText();
        System.out.println("msg id"+ msg);
		return msg;
	}
	
	public void enterMultipleLineItems() throws Exception {
		int row;
		int length=6;
		for (row = 1; row<=length; row++) {
			Thread.sleep(500);
			WebDriver driver = getDriver();
			WebElement itemProductName = driver.findElement(By.xpath("//tbody/tr["+row+"]/td[1]/div[1]/div[1]/select[1]"));
			WebElement addButton = driver.findElement(By.xpath("//tbody/tr["+row+"]/td[11]/button[@data-original-title='Add']"));
			WebElement qty = driver.findElement(By.xpath("//tbody/tr["+row+"]/td[5]//input"));
			WebElement tax= driver.findElement(By.xpath("//tbody/tr["+row+"]/td[6]/ng-form/div[1]/div[1]/select[1]"));
			
			
			String productName = Configuration.getConfig("itemName");
			Select itemName = new Select(itemProductName);
			itemName.selectByVisibleText(productName);
			String quantity = Configuration.getConfig("itemQuantity");
			qty.clear();
			qty.sendKeys(quantity);
			String taxRates = Configuration.getConfig("taxRate");
			Select taxRate = new Select(tax);
			taxRate.selectByVisibleText(taxRates);
				
			if(row == length) {
				break;
			}
			addButton.click();
			
		}
		
*/
}
