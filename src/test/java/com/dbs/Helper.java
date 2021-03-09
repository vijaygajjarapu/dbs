package com.dbs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dbs.stepDefinitions.BrowserConfig;

public class Helper {
	public static WebDriver driver=BrowserConfig.driver;
	public Helper(){
		
	}
	public void Webdriver_waitToClick(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
		}
	}

	public void Webdriver_waitToVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
		}
	}
	
	public void scrollTo(String locator) {
		WebElement ele = null;
		try {
			Thread.sleep(3000);
			ele = driver.findElement(By.xpath(locator));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);           

		} catch (Exception e) {
		}
	} 
	
	public void clickUsingJS(String locator) {
		WebElement ele = null;
		try {
			Thread.sleep(3000);
			ele = driver.findElement(By.xpath(locator));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);          
            } catch (Exception e) {
		}
	}  
	
	public WebElement waitForElement(String locator) {
		WebElement ele = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locator))));         
            } catch (Exception e) {
		}
		return ele;
	} 
	
	
}
