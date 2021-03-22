package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.Configuration;

public class Login {

	@FindBy(id = "txtUN")
	WebElement id;

	@FindBy(name = "txtPwd")
	WebElement pwd;

	@FindBy(xpath = "//Button[@ng-click='UserLogin()']")
	WebElement submitButton;

	public void userLogin() throws Exception {

		String applicationUrl = Configuration.getConfig("url");
		String userName = Configuration.getConfig("username");
		String password = Configuration.getConfig("password");
		
		id.sendKeys(userName);
		pwd.sendKeys(password);
		
		Thread.sleep(11000);
		
		submitButton.click();

	}

}
