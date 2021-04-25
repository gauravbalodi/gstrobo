package com.automation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.Base.BaseTest;

public class CreditDebitNoteTest extends BaseTest {

	@BeforeMethod
	public void reload() {

		driver.navigate().refresh();
	}

	@Test(priority = 1, description="user is able to redirect to credit/debit note page")
	public void navigateToCreditDebitPage() throws InterruptedException {

		globalNavigation.navigateToSalesInvoiceMenu();
		Thread.sleep(1000);
		creditDebitNote.clickOnCdnMenu();
        Assert.assertEquals("Credit/Debit Notes", creditDebitNote.getCdnText());
	}


    @Test(priority=2, description ="User is able to redirect to add new credit/debit note page.")
    public void navigateToAddCdnPage() {
    	creditDebitNote.clickOnNewCdnButton();
    	Assert.assertEquals("Add Credit/Debit Note", creditDebitNote.getAddCdnText());
    }

    @Test(priority = 3, description = "Verify that user should redirect to Tax Invoice page after clicking on Cancel Button")
	public void backToTaxInvoicePage() throws InterruptedException {
		Thread.sleep(1000);
		creditDebitNote.clickOnCancelButton();
		Assert.assertEquals("Tax Invoice", taxInvoice.getTaxInvoiceText());
		driver.navigate().forward();
		
	}

    @Test(priority = 4, description = "Verify that validations message should show for all mandatory fields")
	public void validation() {
    	creditDebitNote.clickOnConfirmButton();

    	creditDebitNote.checkRequiredFeilds();
	}

}
