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

public class TaxInvoiceTest extends BaseTest {

	@BeforeMethod
	public void reload() {

		driver.navigate().refresh();
	}

	@Test(priority = 1, description = "Verify User is able to redirect to Tax Invoice page.")
	public void navigateToTaxInvoicePage() throws InterruptedException {
		Thread.sleep(1000);
		globalNavigation.navigateToSalesInvoiceMenu();
		taxInvoice.clivkOnTaxInvoiceMenu();
		Assert.assertEquals("Tax Invoice", taxInvoice.getTaxInvoiceText());
	}

	@Test(priority = 2, description = "Verify User is able to redirect to Add tax Invoice Page")
	public void navigateToAddTaxInvoicePage() throws InterruptedException {
		Thread.sleep(6000);
		taxInvoice.clickOnNewTaxInvoiceButton();
		Assert.assertEquals("Add Tax Invoice", taxInvoice.getaddtaxInvoiceText());

	}

	// @Test(priority = 3, description = "Verify that user should redirect to Tax
	// Invoice page after clicking on Cancel Button")
	public void backToTaxInvoicePage() throws InterruptedException {
		Thread.sleep(1000);
		taxInvoice.clickOnCancelButton();
		Assert.assertEquals("Tax Invoice", taxInvoice.getTaxInvoiceText());
		driver.navigate().forward();
	}

	// @Test(priority = 4, description = "Verify that validations message should
	// show for all mandatory fields")
	public void validation() {
		taxInvoice.clickOnConfirmButton();

		taxInvoice.checkRequiredFeilds();
	}

	// @Test(priority = 5, description = "Verify that alert message should show when
	// user enters billing address without selecting Invoice Type.")
	public void invoiceTypeValidation() throws InterruptedException {
		taxInvoice.clickOnBillingAddressSection();
		Thread.sleep(500);
		Assert.assertEquals("Please select the invoice type.", taxInvoice.getAlertMessage());
		taxInvoice.clickOnOkButton();
	}

	// @Test(priority = 6, description = "Verify that same billing address is
	// fetching in shipping address section when user checks Same as billing address
	// option")
	public void checkSameAsBillingAddressFunctionality() throws Exception {
		taxInvoice.clickOnRegularRadioButton();
		taxInvoice.indianBillingAddress();
		taxInvoice.clickOnSameAsBillingAddressCheck();
	}

	// @Test(priority = 7, description = "An alert should show when user enters
	// international address as billing address in case of Regular invoice type.")
	public void verifyIndianAlertMessage() throws Exception {
		taxInvoice.clickOnRegularRadioButton();
		taxInvoice.internationalBillingAddress();
		Thread.sleep(500);
		Assert.assertEquals("Only India Address Required for Regular Invoice", taxInvoice.getAlertMessage());
		taxInvoice.clickOnOkButton();
	}

	// @Test(priority = 8, description = "Verify that reverse charge should show
	// when user checks Supply Attract Reverse Charge option")
	public void verifySupplyReverseCharge() {
		taxInvoice.clickOnsupplyAttractReverseCharge();
		taxInvoice.checkReverseCharge();
	}

	// @Test(priority = 9, description = "Verify that IGST value should not get
	// calculate when user selects same POS state as of Supplier's")

	public void verifyIgstValue() throws Exception {
		taxInvoice.clickOnRegularRadioButton();
		taxInvoice.selectPlaceOfSupply("TAMIL NADU");
		taxInvoice.selectitemName();
		taxInvoice.sendItemQuantity();
		taxInvoice.selecttaxRate();
		Assert.assertEquals("0.00", taxInvoice.checkIgstValue());
		Assert.assertNotEquals("0.00", taxInvoice.checkCgstValue());
		Assert.assertNotEquals("0.00", taxInvoice.checkSgstValue());
	}

	// @Test(priority = 10, description = "Verify that CGST and SGST/UTGST value
	// should not get calculate when user selects different POS state as of
	// Supplier's")
	public void verifyCgstAndSgstValue() throws Exception {
		taxInvoice.clickOnRegularRadioButton();
		taxInvoice.selectPlaceOfSupply("DELHI");
		taxInvoice.selectitemName();
		taxInvoice.sendItemQuantity();
		taxInvoice.selecttaxRate();
		Assert.assertEquals("0.00", taxInvoice.checkCgstValue());
		Assert.assertEquals("0.00", taxInvoice.checkSgstValue());
		Assert.assertNotEquals("0.00", taxInvoice.checkIgstValue());

	}

	// @Test(priority = 11, description = "Verify that CGST and SGST/UTGST value
	// should not get calculate when user checks IGST Act though POS state and
	// Supplier's state is same")
	public void verifyIgstActFunctionality() throws Exception {
		taxInvoice.clickOnRegularRadioButton();
		taxInvoice.selectPlaceOfSupply("TAMIL NADU");
		taxInvoice.clickOnIgstAct();
		taxInvoice.selectitemName();
		taxInvoice.sendItemQuantity();
		taxInvoice.selecttaxRate();
		Assert.assertEquals("0.00", taxInvoice.checkCgstValue());
		Assert.assertEquals("0.00", taxInvoice.checkSgstValue());
		Assert.assertNotEquals("0.00", taxInvoice.checkIgstValue());
	}

	//@Test(priority = 12, description = "Verify user is redirecting to Tax Invoice page after creating order")
	public void verifyRedirectionToTaxInvoicePage() throws Exception {
		taxInvoice.clickOnRegularRadioButton();
		taxInvoice.sendGstinNo();
		taxInvoice.selectDepartment();
		taxInvoice.selectPlaceOfSupply("DELHI");
		taxInvoice.indianBillingAddress();
		taxInvoice.clickOnSameAsBillingAddressCheck();
		taxInvoice.selectitemName();
		taxInvoice.sendItemQuantity();
		taxInvoice.selecttaxRate();
		taxInvoice.clickOnConfirmButton();
		Thread.sleep(3000);
		Assert.assertEquals("Tax Invoice", taxInvoice.getTaxInvoiceText());
		driver.navigate().forward();

	}

	//@Test(priority = 13, description = "Verify that created Tax Invoice is showing on Tax Invoice listing page")
	public void verifyCreatedInvoice() throws Exception {
		taxInvoice.clickOnRegularRadioButton();
		taxInvoice.sendGstinNo();
		taxInvoice.selectDepartment();
		taxInvoice.selectPlaceOfSupply("DELHI");
		taxInvoice.indianBillingAddress();
		taxInvoice.clickOnSameAsBillingAddressCheck();
		taxInvoice.selectitemName();
		taxInvoice.sendItemQuantity();
		taxInvoice.selecttaxRate();
		taxInvoice.clickOnConfirmButton();
		String invoice = taxInvoice.getInvoiceNo();
		Thread.sleep(3000);
		String createdInvoice = taxInvoice.getCreatedInvoice();
		Assert.assertEquals(invoice, createdInvoice);
		driver.navigate().forward();
	}

	//@Test(priority = 14, description = "Verify that user is able to create invoice without entering Shipping Address")
	public void verifyInvoiceCreationWithoutShippingAddress() throws Exception {
		taxInvoice.clickOnRegularRadioButton();
		taxInvoice.sendGstinNo();
		taxInvoice.selectDepartment();
		taxInvoice.selectPlaceOfSupply("DELHI");
		taxInvoice.indianBillingAddress();
		taxInvoice.selectitemName();
		taxInvoice.sendItemQuantity();
		taxInvoice.selecttaxRate();
		taxInvoice.clickOnConfirmButton();
		String invoice = taxInvoice.getInvoiceNo();
		Thread.sleep(3000);
		String createdInvoice = taxInvoice.getCreatedInvoice();
		Assert.assertEquals(invoice, createdInvoice);
		driver.navigate().forward();
	}
	
	@Test(priority=15)
	public void verifyMultipleEntry() throws Exception {
		taxInvoice.clickOnRegularRadioButton();
		taxInvoice.selectPlaceOfSupply("TAMIL NADU");
		taxInvoice.enterMultipleLineItems();
	}

}
