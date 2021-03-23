package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(css="input[name='LegalName']")
	WebElement legalNameTradeName;
	
	@FindBy(xpath="//select[@id='DeptID']")
	WebElement department;
	
	@FindBy(xpath="//select[@id='POS']")
	WebElement placeOfSupply;
	
	@FindBy(xpath="//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[2]/div[1]/div[1]/label[1]")
	WebElement supplyAttractReverseCharge;
	
	@FindBy(xpath="//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[3]/div[1]/div[1]/label[1]")
	WebElement autoPopulateForRefunds;
	
	@FindBy(xpath="//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[4]/div[1]/div[1]/label[1]")
	WebElement igstAct;
	
	@FindBy(xpath="//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[6]/div[1]/select[1]")
	WebElement differentialPercentage;
	
	@FindBy(xpath="//tbody/tr[1]/td[1]/div[1]/div[1]/button[1]/span[1]")
	WebElement itemOrProductName;
	
	@FindBy(css="input[title='Rate']")
	WebElement itemRate;
	
    @FindBy(css="input[title='Hsn Code']")
	WebElement hsnCode;
    
    @FindBy(css="input[title='Quantity']")
	WebElement itemQuantity;
    
    @FindBy(css="input[title='Discount']")
	WebElement discountValue;
    
    @FindBy(css="input[title='Cess']")
	WebElement cessValue;
    
    @FindBy(xpath="//tbody/tr[1]/td[4]/ng-form[1]/div[1]/div[1]/select[1]")
    WebElement unitType;
    
    @FindBy(xpath="//tbody/tr[1]/td[4]/ng-form[1]/div[1]/div[1]/select[1]")
    WebElement taxRateValue;
    
    @FindBy(xpath="//a[contains(text(),'Confirm')]")
    WebElement confirmButton;
    
    @FindBy(xpath="//a[contains(text(),'Cancel')]")
    WebElement cancelButton;
    
    @FindBy(xpath="//body/div[@id='mainSectionLayout']/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]")
    WebElement billingAddress;
    
    @FindBy(xpath="//body[1]/div[1]/div[1]/div[2]/div[1]/section[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/ng-form[1]/div[2]/div[1]/div[1]")
    WebElement shippingAddress;
    
    @FindBy(css="label[class='sameCheck']")
    WebElement sameAsBillingAddressCheck;
    
    @FindBy(xpath="//label[@class='radio-inline'][1]")
    WebElement indiaRadioButton;
    
    @FindBy(xpath="//label[@class='radio-inline'][2]")
    WebElement internationalRadioButton;
    
    @FindBy(xpath="//body/div[1]/form[1]/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/ng-form[1]/div[1]/input[1]")
    WebElement indianAddress1;
    
    @FindBy(xpath="//body/div[1]/form[1]/div[1]/div[2]/div[1]/section[1]/div[1]/div[2]/ng-form[1]/div[1]/input[1]")
    WebElement indianAddress2;
    
    @FindBy(xpath="//body/div[1]/form[1]/div[1]/div[2]/div[1]/section[1]/div[2]/div[1]/div[1]/ng-form[1]/div[1]/div[1]/select[1]")
    WebElement indianState;
    
    @FindBy(xpath="//body/div[1]/form[1]/div[1]/div[2]/div[1]/section[2]/div[3]/div[1]/ng-form[1]/div[1]/input[1]")
    WebElement commonCity;
    
    @FindBy(xpath="//body/div[1]/form[1]/div[1]/div[2]/div[1]/section[1]/div[3]/div[2]/ng-form[1]/div[1]/div[1]/div[1]/select[1]")
    WebElement indianPincode;
    
        @FindBy(xpath="//body/div[1]/form[1]/div[1]/div[2]/div[1]/section[1]/div[1]/div[1]/ng-form[1]/div[1]/input[1]")
    WebElement internationalAddress1;
   
    @FindBy(xpath="//body/div[1]/form[1]/div[1]/div[2]/div[1]/section[2]/div[1]/div[2]/ng-form[1]/div[1]/input[1]")
    WebElement internationalAddress2;
    
    @FindBy(xpath="//body/div[1]/form[1]/div[1]/div[2]/div[1]/section[2]/div[2]/div[1]/div[1]/ng-form[1]/div[1]/div[1]/select[1]")
    WebElement internationalCountry;
    
    @FindBy(xpath="//input[@id='State']")
    WebElement internationalState;
   
    @FindBy(xpath="//input[@id='PinCode']")
    WebElement internationalPinCode;

    @FindBy(xpath="//button[contains(text(),'Save')]")
    WebElement addressSaveButton; 

    @FindBy(xpath="//button[contains(text(),'Cancel')]")
    WebElement addressCancelButton;
    

    

    public void selectInternationalCountry(String country) {
   	 Select countries= new Select(internationalCountry);
   	 countries.selectByVisibleText(country);
   }
    
    public void sendInternationalState(String state) {
    	internationalState.sendKeys(state);
    }
    
    public void sendInternationalPinCode(String pinCode ) {
    	internationalPinCode.sendKeys(pinCode);
    }
    
    public void clickOnAddressSaveButton() {
    	addressSaveButton.click();
    }
    
    public void sendInternationalAddress2(String address2 ) {
    	internationalAddress2.sendKeys(address2);
    }
    
    public void sendInternationalAddress1(String address1) {
    	internationalAddress1.sendKeys(address1);
    }
    
    public void clickOnAddressCancelButton() {
    	addressCancelButton.click();
    }
    

    public void selectIndianPincode(String pincode) {
    	Select indiaPincode=new Select(indianPincode);
    	indiaPincode.selectByVisibleText(pincode);
    }

    public void sendCity(String city) {
    	commonCity.sendKeys(city);
    }
    
    public void selectIndianState() {
    	
    	Select indiaState=new Select(indianState);
    	indiaState.selectByVisibleText("Delhi");
    }
    
    public void sendIndianAddress2(String address2) {
    	indianAddress2.sendKeys(address2);
    }
    
    
    public void sendIndianAddress1(String address1) {
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
    
    public void selecttaxRate() {
    	Select taxRate=new Select(taxRateValue);
    	taxRate.selectByVisibleText("3");
    }
    
    public void selectUnitType() {
    	Select unit=new Select(unitType);
    	unit.selectByVisibleText("BOX");
    }
    
    public void sendcessValue(String cess) {
		cessValue.sendKeys(cess);
		
	}  
       
    public void sendDiscountValue(String discount) {
		discountValue.sendKeys(discount);
	} 
    

	public void sendItemQuantity(String quantity) {
		itemQuantity.sendKeys(quantity);
	}
       

	public void sendHsnCode(String hsn) {
		hsnCode.sendKeys(hsn);
	}
	
	public void sendItemRate(String rate) {
		itemRate.sendKeys(rate);
	}
	
	public void selectitemName() {
		Select itemName=new Select(itemOrProductName);
		itemName.selectByVisibleText("BATTERIES");
	}
	
	public void selectdifferentialPercentage() {
		Select dP=new Select(differentialPercentage);
		dP.selectByVisibleText("65");
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
	
	public void sendGstinNo(String gstin) {
		gstinNo.sendKeys(gstin);
	}
	
	public void sendLegalName(String legalName) {
		legalNameTradeName.sendKeys(legalName);
	}
	
	public void selectDepartment() {
        Select Department=new Select(department);
		Department.selectByVisibleText("HUMAN RESOURCE");
	}
	
	public void selectPlaceOfSupply() {
		Select pos= new Select(placeOfSupply);
		pos.selectByVisibleText("DELHI");
	}
	
	public void sendEcomGstin(String ecommerceGstin) {
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








