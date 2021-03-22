package com.automation.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.pages.BillOfSupply;
import com.automation.pages.CreditDebitNote;
import com.automation.pages.GlobalNavigation;
import com.automation.pages.TaxInvoice;

import Utilities.Configuration;

public class BaseTest extends BasePage {
	
	protected TaxInvoice taxInvoice;
	protected CreditDebitNote creditDebitNote;
	protected BillOfSupply billOfSupply;
	protected GlobalNavigation globalNavigation;
	public WebDriver driver;
	
	@BeforeSuite
	public void before() throws Exception {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
        
        String applicationUrl = Configuration.getConfig("url");
        String userName = Configuration.getConfig("username");
        String password = Configuration.getConfig("password");
		
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(applicationUrl);
		
		driver.findElement(By.id("txtUN")).sendKeys(userName);

		driver.findElement(By.name("txtPwd")).sendKeys(password);

		Thread.sleep(11000);
		
		clickOnElement("//Button[@ng-click='UserLogin()']",driver);

		//Thread.sleep(1000);

        Select Gstin=new Select(driver.findElement(By.name("GSTINo")));
		
		Gstin.selectByVisibleText("33GSPTN9422G3Z1");
		
		clickOnElement("//button[contains(text(),'Next')]",driver);
		
		System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).getText());

		System.out.println(driver.getTitle());

		System.out.println(driver.getCurrentUrl());

		

	
	}
	
	@BeforeClass
	public void setup() {
		initPageObjects();
	}
	
	@AfterClass
	public void tearDown() {
		cleanPageObjects();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void initPageObjects() {
		taxInvoice = PageFactory.initElements(getDriver(), TaxInvoice.class);
		creditDebitNote = PageFactory.initElements(getDriver(), CreditDebitNote.class);
		billOfSupply = PageFactory.initElements(getDriver(), BillOfSupply.class);
		globalNavigation = PageFactory.initElements(getDriver(), GlobalNavigation.class);
	}
	
	public void cleanPageObjects() {
		taxInvoice = null;
		creditDebitNote = null;
		billOfSupply = null;
		globalNavigation = null;
	}
	
	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
