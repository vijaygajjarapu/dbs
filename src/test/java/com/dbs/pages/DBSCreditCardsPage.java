package com.dbs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.dbs.Helper;
import com.dbs.stepDefinitions.BrowserConfig;
import org.assertj.core.api.SoftAssertions;

import junit.framework.Assert;

public class DBSCreditCardsPage extends Helper{
	public static WebDriver driver = BrowserConfig.driver;
	private Helper helper; 
	SoftAssertions softAssertions = new SoftAssertions();
	ArrayList<String> similarities = new ArrayList<>();
	ArrayList<String> differences = new ArrayList<>();
	String card1="";
	String card2="";
	
	public DBSCreditCardsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		helper = new Helper();
	}
	
	@FindBy(xpath = "//div[@id='flpHeader']//a[text()='Cards']")
	public WebElement webCardsLink;

	@FindBy(xpath = "//a[text()='Credit Cards' and not(contains(@data-ajax,'credit-cards'))]")
	public WebElement webCreditCards;
    
	@FindBy(id = "cardCompareBtn")
	public WebElement compareButton;
	
	public void navigateToCreditCardsPage() {
		Webdriver_waitToClick(webCardsLink);
		webCardsLink.click();
		BrowserConfig.parentTest.createNode("Clicked on Cards");
		Webdriver_waitToClick(webCreditCards);
		webCreditCards.click();
		BrowserConfig.parentTest.createNode("Clicked on Credit Cards for Comparision");
	}	
	
	public void selectCardsAndClickOnCompare(String card1,String card2) {
		String firstCard = "//input[@data-title='"+card1+"']/following-sibling::label/div[@class='option-alignment']";
		String firstCard1 = "//input[@data-title='"+card1+"']/following-sibling::label/a[contains(@class,'applyNowBtn')]";
		scrollTo(firstCard1);
		waitForElement(firstCard);
		clickUsingJS(firstCard);
		//driver.findElement(By.xpath(firstCard)).click();
		BrowserConfig.parentTest.createNode("Clicked on compare check Box for first card");
		String secondCard = "//input[@data-title='"+card2+"']/following-sibling::label/div[@class='option-alignment']";
		//driver.findElement(By.xpath(secondCard)).click();
		waitForElement(secondCard);
		clickUsingJS(secondCard);
		BrowserConfig.parentTest.createNode("Clicked on compare check Box for second card");
		compareButton.click();
		BrowserConfig.parentTest.createNode("Clicked on Compare button");
	}
	
	public void compareBestFor() {		
		card1 = "//div[@id='card0']//div[text()='Best For']/following-sibling::div[1]";
		scrollTo(card1);
		card2 = "//div[text()='Best For']/ancestor::div[@id='card0']/following-sibling::div/div[@class='section-seperator'][1]/div[2]";		
		BrowserConfig.parentTest.createNode("Verify Best For");		
		String bestForCard1 = driver.findElement(By.xpath(card1)).getText();
		BrowserConfig.parentTest.createNode("First Card Best For value is "+bestForCard1);
		String bestForCard2 = driver.findElement(By.xpath(card2)).getText();
		BrowserConfig.parentTest.createNode("Second Card Best For value is "+bestForCard2);
		softAssertions.assertThat(bestForCard1).isEqualTo(bestForCard2);		
	}
	
	public void compareCardType() {		
		card1 = "//div[@id='card0']//div[text()='Card Type']/following-sibling::div[1]";
		scrollTo(card1);
		card2 = "//div[text()='Card Type']/ancestor::div[@id='card0']/following-sibling::div/div[@class='section-seperator'][1]/div[4]";		
		BrowserConfig.parentTest.createNode("Verify CardType");		
		String bestForCard1 = driver.findElement(By.xpath(card1)).getText();
		BrowserConfig.parentTest.createNode("First Card Card Type value is "+bestForCard1);
		String bestForCard2 = driver.findElement(By.xpath(card2)).getText();
		BrowserConfig.parentTest.createNode("Second Card Card Type value is "+bestForCard2);
		softAssertions.assertThat(bestForCard1).isEqualTo(bestForCard2);		
	}
	
	public void compareMinIncome() {		
		card1 = "//div[@id='card0']//div[text()='Min Income Per Annum']/following-sibling::div[1]";
		scrollTo(card1);
		card2 = "//div[text()='Min Income Per Annum']/ancestor::div[@id='card0']/following-sibling::div/div[@class='section-seperator'][1]/div[6]";		
		BrowserConfig.parentTest.createNode("Verify MinIncome");		
		String bestForCard1 = driver.findElement(By.xpath(card1)).getText();
		BrowserConfig.parentTest.createNode("First Card Min Income value is "+bestForCard1);
		String bestForCard2 = driver.findElement(By.xpath(card2)).getText();
		BrowserConfig.parentTest.createNode("Second Card Min Income value is "+bestForCard2);
		softAssertions.assertThat(bestForCard1).isEqualTo(bestForCard2);
	}
	
	public void minIncomeForForeigners() {
		card1 = "//div[@id='card0']//div[text()='Min Income Per Annum Foreigners']/following-sibling::div[1]";
		scrollTo(card1);
		card2 = "//div[text()='Min Income Per Annum Foreigners']/ancestor::div[@id='card0']/following-sibling::div/div[@class='section-seperator'][1]/div[8]";		
		BrowserConfig.parentTest.createNode("Verify MinIncome for Foreigners");		
		String firstCard = driver.findElement(By.xpath(card1)).getText();
		BrowserConfig.parentTest.createNode("First Card Min Income for Foreigners value is "+firstCard);
		String secondCard = driver.findElement(By.xpath(card2)).getText();
		BrowserConfig.parentTest.createNode("Second Card Min Income for Foreigners value is "+secondCard);
		softAssertions.assertThat(firstCard).isEqualTo(secondCard);
	}
	
	public void AnnualFeeWavier() {
		card1 = "//div[@id='card0']//div[text()='Annual Fee Waiver']/following-sibling::div[1]";
		scrollTo(card1);
		card2 = "//div[text()='Card Benefits']/ancestor::div[@id='card0']/following-sibling::div/div[@class='section-seperator'][1]//div[12]";		
		BrowserConfig.parentTest.createNode("Verify Annual Feel Wavier");		
		String firstCard = driver.findElement(By.xpath(card1)).getText();
		BrowserConfig.parentTest.createNode("First Card - Verify Annual Feel Wavier value is "+firstCard);
		String secondCard = driver.findElement(By.xpath(card2)).getText();
		BrowserConfig.parentTest.createNode("Second Card - Verify Annual Feel Wavier value is "+secondCard);
		softAssertions.assertThat(firstCard).isEqualTo(secondCard);
	}
	
	public void cardBenefits() {
		card1 = "//div[@id='card0']//div[text()='Card Benefits']/following-sibling::div[1]//li";
		scrollTo(card1);
		card2 = "//div[text()='Card Benefits']/ancestor::div[@id='card0']/following-sibling::div/div[@class='section-seperator'][2]/div[2]//li";		
		BrowserConfig.parentTest.createNode("Verify Card Benefits");
		List<WebElement> elements = driver.findElements(By.xpath(card1));		
		for(WebElement element:elements) {
		BrowserConfig.parentTest.createNode("First Card Benefits value is "+element.getText());	
		}
		//String firstCard = driver.findElement(By.xpath(card1)).getText();
		//BrowserConfig.parentTest.log(Status.PASS,"First Card Min Income for Foreigners value is "+firstCard);
		 elements = driver.findElements(By.xpath(card2));		
			for(WebElement element:elements) {
			BrowserConfig.parentTest.createNode("Second Card Benefits value is "+element.getText());	
			}
	}
	
	public void cardRewards() {
		card1 = "//div[@id='card0']//div[text()='Card Rewards']/following-sibling::div[1]//li";
		scrollTo(card1);
		card2 = "//div[text()='Card Rewards']/ancestor::div[@id='card0']/following-sibling::div/div[@class='section-seperator'][3]/div[2]//li";		
		BrowserConfig.parentTest.createNode("Verify Card Rewards");
		List<WebElement> elements = driver.findElements(By.xpath(card1));		
		for(WebElement element:elements) {
		BrowserConfig.parentTest.createNode("First Card Rewards value is "+element.getText());	
		}
		 elements = driver.findElements(By.xpath(card2));		
			for(WebElement element:elements) {
			BrowserConfig.parentTest.createNode("Second Card Reqards value is "+element.getText());	
		}
	}
	
	public void liftStylePrivileges() {
		card1 = "//div[@id='card0']//div[text()='Lifestyle Privileges']/following-sibling::div[1]";
		scrollTo(card1);
		card2 = "//div[text()='Lifestyle Privileges']/ancestor::div[@id='card0']/following-sibling::div/div[@class='section-seperator'][4]/div[2]";		
		BrowserConfig.parentTest.createNode("Verify Life Style Privileges");		
		String firstCard = driver.findElement(By.xpath(card1)).getText();
		BrowserConfig.parentTest.createNode("First Card Life Style Privileges value is "+firstCard);
		String secondCard = driver.findElement(By.xpath(card2)).getText();
		BrowserConfig.parentTest.createNode("Second Card Life Style Privileges value is "+secondCard);
		softAssertions.assertThat(firstCard).isEqualTo(secondCard);
	}
	
	public void motoring() {
		card1 = "//div[@id='card0']//div[text()='Motoring']/following-sibling::div[1]";
		scrollTo(card1);
		card2 = "//div[text()='Motoring']/ancestor::div[@id='card0']/following-sibling::div/div[@class='section-seperator'][5]//div[2]";		
		BrowserConfig.parentTest.createNode("Verify Motoring");		
		String firstCard = driver.findElement(By.xpath(card1)).getText();
		BrowserConfig.parentTest.createNode("First Card Motoring value is "+firstCard);
		String secondCard = driver.findElement(By.xpath(card2)).getText();
		BrowserConfig.parentTest.createNode("Second Card Motoring value is "+secondCard);
		softAssertions.assertThat(firstCard).isEqualTo(secondCard);
	}
	
	public void dining() {
		card1 = "//div[@id='card0']//div[text()='Dining']/following-sibling::div[1]";
		scrollTo(card1);
		card2 = "//div[text()='Dining']/ancestor::div[@id='card0']/following-sibling::div/div[@class='section-seperator'][6]//div[2]";		
		BrowserConfig.parentTest.createNode("Verify Dining");		
		String firstCard = driver.findElement(By.xpath(card1)).getText();
		BrowserConfig.parentTest.createNode("First Card Dining value is "+firstCard);
		String secondCard = driver.findElement(By.xpath(card2)).getText();
		BrowserConfig.parentTest.createNode("Second Card Dining value is "+secondCard);
		softAssertions.assertThat(firstCard).isEqualTo(secondCard);
	}
	
	public void movies() {
		card1 = "//div[@id='card0']//div[text()='Dining']/following-sibling::div[1]";
		scrollTo(card1);
		card2 = "//div[text()='Movies']/ancestor::div[@id='card0']/following-sibling::div/div[@class='section-seperator'][7]//div[2]";		
		BrowserConfig.parentTest.createNode("Verify Movies");		
		String firstCard = driver.findElement(By.xpath(card1)).getText();
		BrowserConfig.parentTest.createNode("First Card Movies value is "+firstCard);
		String secondCard = driver.findElement(By.xpath(card2)).getText();
		BrowserConfig.parentTest.createNode("Second Card Movies value is "+secondCard);
		softAssertions.assertThat(firstCard).isEqualTo(secondCard);
	}
	
	public void travel() {
		card1 = "//div[@id='card0']//div[text()='Travel']/following-sibling::div[1]";
		scrollTo(card1);
		card2 = "//div[text()='Travel']/ancestor::div[@id='card0']/following-sibling::div/div[@class='section-seperator'][8]//div[2]";		
		BrowserConfig.parentTest.createNode("Verify Travel");		
		String firstCard = driver.findElement(By.xpath(card1)).getText();
		BrowserConfig.parentTest.createNode("First Card Travel value is "+firstCard);
		String secondCard = driver.findElement(By.xpath(card2)).getText();
		BrowserConfig.parentTest.createNode("Second Card Travel value is "+secondCard);
		softAssertions.assertThat(firstCard).isEqualTo(secondCard);
	}
	
	public void healthCare() {
		card1 = "//div[@id='card0']//div[text()='Healthcare']/following-sibling::div[1]";
		scrollTo(card1);
		card2 = "//div[text()='Healthcare']/ancestor::div[@id='card0']/following-sibling::div/div[@class='section-seperator'][9]//div[2]";		
		BrowserConfig.parentTest.createNode("Verify HealthCare");		
		String firstCard = driver.findElement(By.xpath(card1)).getText();
		BrowserConfig.parentTest.createNode("First Card Health care value is "+firstCard);
		String secondCard = driver.findElement(By.xpath(card2)).getText();
		BrowserConfig.parentTest.createNode("Second Card Health Care value is "+secondCard);
		softAssertions.assertThat(firstCard).isEqualTo(secondCard);
		softAssertions.assertAll();
	}
}
