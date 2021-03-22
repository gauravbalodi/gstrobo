package com.automation.Base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	
    public void clickOnElement(String locator, WebDriver driver) {
    	
    	driver.findElement(By.xpath(locator)).click();
        
    }

}
