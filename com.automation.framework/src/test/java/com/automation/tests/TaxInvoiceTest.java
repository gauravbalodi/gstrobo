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
		globalNavigation.navigateToSalesInvoiceMenu();
		Assert.assertEquals("Tax Invoice", taxInvoice.getTaxInvoiceText());
		Thread.sleep(2000);
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

	// @Test(priority = 12, description = "Verify user is redirecting to Tax Invoice
	// page after creating order")
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

	// @Test(priority = 13, description = "Verify that created Tax Invoice is
	// showing on Tax Invoice listing page")
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

	// @Test(priority = 14, description = "Verify that user is able to create
	// invoice without entering Shipping Address")
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

	// @Test(priority=15, description="User is able to create Tax Invoice with
	// multiple line items")
	public void verifyMultipleLineItems() throws Exception {
		taxInvoice.clickOnRegularRadioButton();
		taxInvoice.selectPlaceOfSupply("TAMIL NADU");
		taxInvoice.clickOnRegularRadioButton();
		taxInvoice.sendGstinNo();
		taxInvoice.selectDepartment();
		taxInvoice.selectPlaceOfSupply("DELHI");
		taxInvoice.indianBillingAddress();
		taxInvoice.enterMultipleLineItems();
		taxInvoice.clickOnConfirmButton();
		String invoice = taxInvoice.getInvoiceNo();
		Thread.sleep(3000);
		String createdInvoice = taxInvoice.getCreatedInvoice();
		Assert.assertEquals(invoice, createdInvoice);
		driver.navigate().forward();
	}

	// @Test(priority=16, description="User is able to delete multiple line items")
	public void deleteMultipleLineItems() throws Exception {
		taxInvoice.clickOnRegularRadioButton();
		taxInvoice.sendGstinNo();
		taxInvoice.selectDepartment();
		taxInvoice.selectPlaceOfSupply("DELHI");
		taxInvoice.indianBillingAddress();
		taxInvoice.deleteLineItem();
	}

	// @Test(priority = 17, description="User is able to edit invoice")
	public void editCreatedTaxInvoice() throws Exception {
		taxInvoice.clickOnRegularRadioButton();
		taxInvoice.sendGstinNo();
		taxInvoice.selectDepartment();
		taxInvoice.selectPlaceOfSupply("TAMIL NADU");
		taxInvoice.indianBillingAddress();
		taxInvoice.selectitemName();
		taxInvoice.sendItemQuantity();
		taxInvoice.selecttaxRate();
		taxInvoice.clickOnConfirmButton();
		Thread.sleep(3000);
		taxInvoice.clickOnEditButton();
		taxInvoice.selectPlaceOfSupply("DELHI");
		taxInvoice.clickOnConfirmButton();
		taxInvoice.getAlertMessage();

	}

	/*
	 * @Test(priority=18,
	 * description="Verify that GSTIN field should show when user selects Deemed Export as Export Type"
	 * ) public void gstinFieldDisplayCheck1() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("Deemed Exports");
	 * Assert.assertTrue(taxInvoice.isGstinFieldDisplayed()); }
	 * 
	 * @Test(priority=19,
	 * description="Verify that GSTIN field should show when user selects SEZ Exports with payment as Export Type"
	 * ) public void gstinFieldDisplayCheck2() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("SEZ Exports with payment");
	 * Assert.assertTrue(taxInvoice.isGstinFieldDisplayed()); }
	 * 
	 * @Test(priority=20,
	 * description="Verify that GSTIN field should show when user selects  SEZ exports without payment as Export Type"
	 * ) public void gstinFieldDisplayCheck3() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("SEZ exports without payment");
	 * Assert.assertTrue(taxInvoice.isGstinFieldDisplayed()); }
	 * 
	 * @Test(priority=21,
	 * description="Verify that GSTIN field should not show when user selects  Export Invoice with payment of Tax as Export Type"
	 * ) public void gstinFieldDisplayCheck4() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("Export Invoice with payment of Tax");
	 * Assert.assertFalse(taxInvoice.isGstinFieldDisplayed()); }
	 * 
	 * @Test(priority=22,
	 * description="Verify that GSTIN field should not show when user selects  Export under Bond or LUT as Export Type"
	 * ) public void gstinFieldDisplayCheck5() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("Export under Bond or LUT");
	 * Assert.assertFalse(taxInvoice.isGstinFieldDisplayed()); }
	 * 
	 * @Test(priority=23,
	 * description="Verify that Place Of Supply Field should show when user selects Deemed Export as Export Type"
	 * ) public void posFieldDisplayCheck1() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("Deemed Exports");
	 * Assert.assertTrue(taxInvoice.isPosFieldDisplayed()); }
	 * 
	 * @Test(priority=24,
	 * description="Verify that Place Of Supply Field should show when user selects SEZ Exports with payment as Export Type"
	 * ) public void posFieldDisplayCheck2() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("SEZ Exports with payment");
	 * Assert.assertTrue(taxInvoice.isPosFieldDisplayed()); }
	 * 
	 * @Test(priority=25,
	 * description="Verify that Place Of Supply Field should show when user selects SEZ exports without payment as Export Type"
	 * ) public void posFieldDisplayCheck3() throws InterruptedException {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("SEZ exports without payment");
	 * Assert.assertTrue(taxInvoice.isPosFieldDisplayed()); }
	 * 
	 * @Test(priority=26,
	 * description="Verify that Place Of Supply Field should not show  when user selects Export Invoice with payment of Tax as Export Type"
	 * ) public void posFieldDisplayCheck4() throws InterruptedException {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("Export Invoice with payment of Tax");
	 * Assert.assertFalse(taxInvoice.isPosFieldDisplayed()); }
	 * 
	 * @Test(priority=27,
	 * description="Verify that Place Of Supply Field should not show  when user selects Export under Bond or LUT as Export Type"
	 * ) public void posFieldDisplayCheck5() throws InterruptedException {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("Export under Bond or LUT");
	 * Assert.assertFalse(taxInvoice.isPosFieldDisplayed()); }
	 * 
	 * @Test(priority=28,
	 * description="Verify that 'Is Supplier Claiming Refund checkbox' should show  when user selects Deemed Exports as Export Type"
	 * ) public void suppClaimDisplayCheck1() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("Deemed Exports");
	 * Assert.assertTrue(taxInvoice.isSuppClaimIsDisplayed()); }
	 * 
	 * @Test(priority=29,
	 * description="Verify that 'Is Supplier Claiming Refund checkbox' should show  when user selects SEZ Exports with payment as Export Type"
	 * ) public void suppClaimDisplayCheck2() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("SEZ Exports with payment");
	 * Assert.assertTrue(taxInvoice.isSuppClaimIsDisplayed()); }
	 * 
	 * @Test(priority=30,
	 * description="Verify that 'Is Supplier Claiming Refund checkbox' should not show  when user selects SEZ exports without payment as Export Type"
	 * ) public void suppClaimDisplayCheck3() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("SEZ exports without payment");
	 * Assert.assertFalse(taxInvoice.isSuppClaimIsDisplayed());
	 * 
	 * }
	 * 
	 * @Test(priority=31,
	 * description="Verify that 'Is Supplier Claiming Refund checkbox' should not show  when user selects Export Invoice with payment of Tax as Export Type"
	 * ) public void suppClaimDisplayCheck4() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("Export Invoice with payment of Tax");
	 * Assert.assertFalse(taxInvoice.isSuppClaimIsDisplayed()); }
	 * 
	 * 
	 * @Test(priority=32,
	 * description="Verify that 'Is Supplier Claiming Refund checkbox' should not show  when user selects Export under Bond or LUT as Export Type"
	 * ) public void suppClaimDisplayCheck5() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("Export under Bond or LUT");
	 * Assert.assertFalse(taxInvoice.isSuppClaimIsDisplayed()); }
	 * 
	 * @Test(priority=33,
	 * description="Verify that 'Is supply covered under section 7 of IGST Act checkbox' should show  when user selects Deemed Exports as Export Type"
	 * ) public void igstActDisplayCheck1() { taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("Deemed Exports");
	 * Assert.assertTrue(taxInvoice.isIgstActDisplayed()); }
	 * 
	 * //@Test(priority=34,
	 * description="Verify that 'Is supply covered under section 7 of IGST Act checkbox' should show  when user selects SEZ Exports with payment as Export Type"
	 * ) public void igstActDisplayCheck2() { taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("SEZ Exports with payment");
	 * Assert.assertFalse(taxInvoice.isIgstActDisplayed()); }
	 * 
	 * //@Test(priority=35,
	 * description="Verify that 'Is supply covered under section 7 of IGST Act checkbox' should show  when user selects SEZ exports without payment as Export Type"
	 * ) public void igstActDisplayCheck3() { taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("SEZ exports without payment");
	 * Assert.assertFalse(taxInvoice.isIgstActDisplayed()); }
	 * 
	 * //@Test(priority=36,
	 * description="Verify that 'Is supply covered under section 7 of IGST Act checkbox' should not show  when user selects Export Invoice with payment of Tax as Export Type"
	 * ) public void igstActDisplayCheck4() { taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("Export Invoice with payment of Tax");
	 * Assert.assertFalse(taxInvoice.isIgstActDisplayed()); }
	 * 
	 * //@Test(priority=37,
	 * description="Verify that 'Is supply covered under section 7 of IGST Act checkbox' should not show  when user selects Export under Bond or LUT as Export Type"
	 * ) public void igstActDisplayCheck5() { taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("Export under Bond or LUT");
	 * Assert.assertFalse(taxInvoice.isIgstActDisplayed()); }
	 * 
	 * //@Test(priority=38,
	 * description="Verify that Differential Percentage dropdown should show  when user selects Deemed Exports as Export Type"
	 * ) public void differentialPercentagDisplayCheck1() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("Deemed Exports");
	 * Assert.assertTrue(taxInvoice.isDifferentialPercentageDisplayed()); }
	 * 
	 * //@Test(priority=39,
	 * description="Verify that Differential Percentage dropdown should show  when user selects SEZ Exports with payment as Export Type"
	 * ) public void differentialPercentagDisplayCheck2() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("SEZ Exports with payment");
	 * Assert.assertTrue(taxInvoice.isDifferentialPercentageDisplayed()); }
	 * 
	 * //@Test(priority=40,
	 * description="Verify that Differential Percentage dropdown should show  when user selects SEZ exports without payment as Export Type"
	 * ) public void differentialPercentagDisplayCheck3() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("SEZ exports without payment");
	 * Assert.assertTrue(taxInvoice.isDifferentialPercentageDisplayed()); }
	 * 
	 * //@Test(priority=41,
	 * description="Verify that Differential Percentage dropdown should not show  when user selects Export Invoice with payment of Tax as Export Type"
	 * ) public void differentialPercentagDisplayCheck4() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("Export Invoice with payment of Tax");
	 * Assert.assertFalse(taxInvoice.isDifferentialPercentageDisplayed()); }
	 * 
	 * //@Test(priority=42,
	 * description="Verify that Differential Percentage dropdown should not show  when user selects Export under Bond or LUT as Export Type"
	 * ) public void differentialPercentagDisplayCheck5() {
	 * taxInvoice.clickOnExportRadioButton();
	 * taxInvoice.selectExportType("Export under Bond or LUT");
	 * Assert.assertFalse(taxInvoice.isDifferentialPercentageDisplayed()); }
	 

	@Test(priority = 43, description = "Verify that Total Tax should not get calculate in case of SEZ exports without payment")
	public void taxCalcualtionSezwop() throws Exception {
		taxInvoice.clickOnExportRadioButton();
		taxInvoice.selectExportType("SEZ exports without payment");
		taxInvoice.selectitemName();
		taxInvoice.selecttaxRate();
		taxInvoice.sendItemQuantity();
		Assert.assertEquals("0.00", taxInvoice.checkTotalTaxValue());
	}

	@Test(priority = 44, description = "Verify that Total Tax should not get calculate in case of Export under Bond or LUT")
	public void taxCalcualtionExwop() throws Exception {
		taxInvoice.clickOnExportRadioButton();
		taxInvoice.selectExportType("SEZ exports without payment");
		taxInvoice.selectitemName();
		taxInvoice.selecttaxRate();
		taxInvoice.sendItemQuantity();
		Assert.assertEquals("0.00", taxInvoice.checkTotalTaxValue());
	}


	@Test(priority = 45, description = "Verify that Total Tax should get calculate in case of Deemed Exports")
	public void taxCalcualtionDe() throws Exception {
		taxInvoice.clickOnExportRadioButton();
		taxInvoice.selectExportType("Deemed Exports");
		taxInvoice.selectitemName();
		taxInvoice.selecttaxRate();
		taxInvoice.sendItemQuantity();	
		Assert.assertNotEquals("0.00", taxInvoice.checkTotalTaxValue());
	}
	
	@Test(priority = 46, description = "Verify that Total Tax should get calculate in case of SEZ Exports with payment")
	public void taxCalcualtionSezwp() throws Exception {
		taxInvoice.clickOnExportRadioButton();
		taxInvoice.selectExportType("SEZ Exports with payment");
		taxInvoice.selectitemName();
		taxInvoice.selecttaxRate();
		taxInvoice.sendItemQuantity();
		Assert.assertNotEquals("0.00", taxInvoice.checkTotalTaxValue());
	}
	
	@Test(priority = 47, description = "Verify that Total Tax should get calculate in case of Export Invoice with payment of Tax")
	public void taxCalcualtionExwp() throws Exception {
		taxInvoice.clickOnExportRadioButton();
		taxInvoice.selectExportType("Export Invoice with payment of Tax");
		taxInvoice.selectitemName();
		taxInvoice.selecttaxRate();
		taxInvoice.sendItemQuantity();
		Assert.assertNotEquals("0.00", taxInvoice.checkTotalTaxValue());
	}
	
	
	@Test(priority = 48, description= "Verify that validation message is showing for Export Type Field when not selected by user")
	public void checkExportTypevalidationMsg() {
		taxInvoice.clickOnExportRadioButton();
		taxInvoice.clickOnConfirmButton();
		taxInvoice.checkExportTypeReqMsg();
	}
	
	@Test(priority = 49, description= "Verify that validation message is showing for 'Shipping Bill No./Bill of Export No' when only 'Shipping Bill/Bill of Export Date' is selected")
	public void checkShipBillNoValidationMsg() throws Exception {
		taxInvoice.clickOnExportRadioButton();
		taxInvoice.clickOnShipBillDate();
		taxInvoice.selectExportType("Deemed Exports");
		taxInvoice.sendGstinNo();
		taxInvoice.selectDepartment();
		taxInvoice.selectPlaceOfSupply("DELHI");
		taxInvoice.selectitemName();
		taxInvoice.selecttaxRate();
		taxInvoice.sendItemQuantity();
		taxInvoice.clickOnConfirmButton();
		taxInvoice.checkShipBillNoReqMsg();
		
	}

	@Test(priority = 50, description= "Verify that validation message is showing for 'Shipping Bill/Bill of Export Date' when only 'Shipping Bill No./Bill of Export No' is Entered")
	public void checkShipBillExDateValidationMsg() throws Exception {
		taxInvoice.clickOnExportRadioButton();
		taxInvoice.sendShippinfBillNo();
		taxInvoice.selectExportType("Deemed Exports");
		taxInvoice.sendGstinNo();
		taxInvoice.selectDepartment();
		taxInvoice.selectPlaceOfSupply("DELHI");
		taxInvoice.selectitemName();
		taxInvoice.selecttaxRate();
		taxInvoice.sendItemQuantity();
		taxInvoice.clickOnConfirmButton();
		taxInvoice.checkShipBillExDateReqMsg();
		
	}*/
	
	@Test(priority = 51, description="Verify that currency field should get mandatory and validation message should also show when user switch to regular invoice type from export and again switch to Export Invoice type")
	public void checkCurrencyValidationMsg() {
		taxInvoice.clickOnExportRadioButton();
		taxInvoice.clickOnConfirmButton();
		Assert.assertFalse(taxInvoice.checkCurrencyReqMsg());
		taxInvoice.clickOnRegularRadioButton();
		taxInvoice.clickOnExportRadioButton();
		Assert.assertTrue(taxInvoice.checkCurrencyReqMsg());
			
    }
	

	@Test(priority = 51, description="Verify that currency field should get mandatory and validation message should also show when user switch to regular invoice type from export and again switch to Export Invoice type")
	public void checkCurrencyValidationMsg() {
		taxInvoice.clickOnExportRadioButton();
		taxInvoice.clickOnConfirmButton();
		Assert.assertFalse(taxInvoice.checkCurrencyReqMsg());
		taxInvoice.clickOnRegularRadioButton();
		taxInvoice.clickOnExportRadioButton();
		Assert.assertTrue(taxInvoice.checkCurrencyReqMsg());
			
    }
}
